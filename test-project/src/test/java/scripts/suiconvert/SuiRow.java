package scripts.suiconvert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SuiRow {
    private String type;
    private String date;
    private String cate;
    private String sedCate;
    private String account1;
    private String account2;
    private String money;
    private String member;
    private String merchant;
    private String project;
    private String remark;

    public String toConsoleString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(type).append('\t');
        sb.append(date).append('\t');
        sb.append(cate).append('\t');
        sb.append(sedCate).append('\t');
        sb.append(account1).append('\t');
        sb.append(account2).append('\t');
        sb.append(money).append('\t');
        sb.append(member).append('\t');
        sb.append(merchant).append('\t');
        sb.append(project).append('\t');
        sb.append(remark).append('\t');
        return sb.toString();
    }
}
