package suiconvert;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCate() {
        return cate;
    }

    public void setCate(String cate) {
        this.cate = cate;
    }

    public String getSedCate() {
        return sedCate;
    }

    public void setSedCate(String sedCate) {
        this.sedCate = sedCate;
    }

    public String getAccount1() {
        return account1;
    }

    public void setAccount1(String account1) {
        this.account1 = account1;
    }

    public String getAccount2() {
        return account2;
    }

    public void setAccount2(String account2) {
        this.account2 = account2;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
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
