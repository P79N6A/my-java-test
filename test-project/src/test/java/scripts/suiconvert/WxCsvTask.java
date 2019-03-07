package scripts.suiconvert;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import lombok.Builder;
import lombok.Data;

/**
 * 微信账单导出格式转换
 */
public class WxCsvTask {

    public static void csvFile(String filename) {
        fileToSuiRow(filename).stream().forEach(e -> System.out.println(e.toConsoleString()));
    }

    public static List<SuiRow> fileToSuiRow(String filename) {
        List<String> allLines = Collections.EMPTY_LIST;
        try {
            allLines = Files.readAllLines(Paths.get(filename), Charset.forName("UTF8"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<String> recordLines = filterLines(allLines);
        List<Record> records = transLineToRecord(recordLines);
        List<SuiRow> suiRows = toSuiRow(records);
        return suiRows;
    }

    private static List<SuiRow> toSuiRow(List<Record> recordList) {
        List<SuiRow> list = new ArrayList<>();
        for (Record record : recordList) {
            String[] cate = ConvUtils.cateConv(record.getMerchant());
            SuiRow suiRow = SuiRow.builder().type(record.getDirection())
                    .date(record.getDate())
                    .cate(cate[0])
                    .sedCate(cate[1])
                    .account1(getAccount(record))
                    .account2("")
                    .money(record.getMoney())
                    .member("")
                    .merchant("")
                    .project("")
                    .remark(ConvUtils.remarkGenerate(record.getMerchant(), record.getProduct()))
                    .build();
            list.add(suiRow);
        }
        return list;
    }

    private static List<Record> transLineToRecord(List<String> lines) {
        List<Record> records = new ArrayList<>();
        for (String line : lines) {
            String[] field = line.split(",");
            //            if (!"支付成功".equals(field[7].trim())) {
            //                continue;
            //            }
            int i = 0;
            Record r = Record.builder()
                    .date(field[i++].trim())
                    .type(field[i++].trim())
                    .merchant(field[i++].trim().replace("/", ""))
                    .product(StringUtils.strip(field[i++].trim(), "\"").replace("/", ""))
                    .direction(field[i++].trim().replace("/", ""))
                    .money(field[i++].trim().replace("¥", ""))
                    .payWay(field[i++].trim())
                    .status(field[i++].trim())
                    .tradeId(field[i++].trim())
                    .merchantId(field[i++].trim())
                    .remark(field[i++].trim().replace("/", ""))
                    .build();
            records.add(r);
        }
        return records;
    }

    private static List<String> filterLines(List<String> allLines) {
        List<String> result = new ArrayList<>();
        int startLine = 0;
        for (String line : allLines) {
            if (line.startsWith("-----")) {
                result = allLines.subList(startLine + 2, allLines.size() - 1);
                break;
            }
            startLine++;
        }
        return result;
    }

    private static String getAccount(Record record) {
        if (record.getType().equals("微信红包") || record.getType().equals("转账")) {
            return "微信零钱";
        }
        return ConvUtils.accountConv(record.getPayWay());
    }

    @Data
    @Builder
    public static class Record {
        private String date;
        private String type;
        private String merchant;
        private String product;
        private String direction;
        private String money;
        private String payWay;
        private String status;
        private String tradeId;
        private String merchantId;
        private String remark;
    }
}
