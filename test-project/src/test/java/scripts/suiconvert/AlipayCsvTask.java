package scripts.suiconvert;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.Builder;
import lombok.Data;

public class AlipayCsvTask {
    public static void main(String[] args) {
        alipay("");
    }

    public static void alipay(String file) {
        fileToSuiRow(file).forEach(e -> System.out.println(e.toConsoleString()));
    }

    public static List<SuiRow> fileToSuiRow(String file) {
        List<String> allLines = Collections.EMPTY_LIST;
        try {
            allLines = Files.readAllLines(Paths.get(file), Charset.forName("GB2312"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<String> recordLines = filterLines(allLines);
        List<Record> records = transLineToRecord(recordLines);
        List<SuiRow> suiRows = toSuiRow(records);
        return suiRows;
    }

    public static List<String> filterLines(List<String> lines) {
        List<String> result = new ArrayList<>();
        // 从第五行开始，直到遇到----开头
        for (int i = 0; i < lines.size(); i++) {
            if (i < 5) {
                continue;
            }
            String line = lines.get(i);
            if (line.startsWith("-----")) {
                break;
            }
            result.add(line);
        }
        return result;
    }

    public static List<Record> transLineToRecord(List<String> lines) {
        List<Record> records = new ArrayList<>();
        for (String line : lines) {
            String[] field = line.split(",");
            if (!"交易成功".equals(field[11].trim())) {
                continue;
            }
            int i = 0;
            Record r = Record.builder()
                    .payId(field[i++].trim())
                    .orderId(field[i++].trim())
                    .createTime(field[i++].trim())
                    .payTime(field[i++].trim())
                    .updateTime(field[i++].trim())
                    .source(field[i++].trim())
                    .type(field[i++].trim())
                    .merchant(field[i++].trim())
                    .product(field[i++].trim())
                    .money(field[i++].trim())
                    .direction(field[i++].trim())
                    .status(field[i++].trim())
                    .serviceMoney(field[i++].trim())
                    .refundMoney(field[i++].trim())
                    .remark(field[i++].trim())
                    .moneyStatus(field[i++].trim())
                    .build();
            records.add(r);
        }
        return records;
    }

    public static List<SuiRow> toSuiRow(List<Record> recordList) {
        List<SuiRow> list = new ArrayList<>();
        for (Record record : recordList) {
            String[] cate = ConvUtils.cateConv(record.getMerchant());
            SuiRow suiRow = SuiRow.builder().type("支出")
                    .date(record.getPayTime())
                    .cate(cate[0])
                    .sedCate(cate[1])
                    .account1("浦发信用卡")
                    .account2("")
                    .money(record.getMoney())
                    .member("")
                    .merchant("")
                    .project("")
                    .remark(record.getProduct() + "  " + record.getMerchant())
                    .build();
            list.add(suiRow);
        }
        return list;
    }

    @Data
    @Builder
    public static class Record {
        private String payId;
        private String orderId;
        private String createTime;
        private String payTime;
        private String updateTime;
        private String source;
        private String type;
        private String merchant;
        private String product;
        private String direction;
        private String money;
        private String status;
        private String serviceMoney;
        private String refundMoney;
        private String remark;
        private String moneyStatus;

    }
}
