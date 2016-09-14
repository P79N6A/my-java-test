package priv.zc.autosign.vo;

/**
 * Created by zongchao on 16/9/14.
 */
public class AjaxDoneVo {
    /**
     * {
     * "statusCode":"200",
     * "message":"\u64cd\u4f5c\u6210\u529f",
     * "navTabId":"",
     * "rel":"",
     * "callbackType":"",
     * "forwardUrl":"",
     * "confirmMsg":""
     * }
     */

    public static final String CALLBACK_TYPE_CLOSE_CURRENT = "closeCurrent";

    private String statusCode = "";
    private String message = "";
    private String navTabId = "";
    private String rel = "";
    private String callbackType = "";
    private String forwardUrl = "";
    private String confirmMsg = "";

    public AjaxDoneVo() {
    }

    public AjaxDoneVo(String statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNavTabId() {
        return navTabId;
    }

    public void setNavTabId(String navTabId) {
        this.navTabId = navTabId;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getCallbackType() {
        return callbackType;
    }

    public void setCallbackType(String callbackType) {
        this.callbackType = callbackType;
    }

    public String getForwardUrl() {
        return forwardUrl;
    }

    public void setForwardUrl(String forwardUrl) {
        this.forwardUrl = forwardUrl;
    }

    public String getConfirmMsg() {
        return confirmMsg;
    }

    public void setConfirmMsg(String confirmMsg) {
        this.confirmMsg = confirmMsg;
    }

    public static AjaxDoneVo success() {
        AjaxDoneVo vo = new AjaxDoneVo();
        vo.statusCode = "200";
        vo.message = "操作成功";
        vo.callbackType = CALLBACK_TYPE_CLOSE_CURRENT;
        return vo;
    }

    public static AjaxDoneVo error(){
        AjaxDoneVo vo =new AjaxDoneVo();
        vo.statusCode = "300";
        vo.message = "操作失败";
        return vo;
    }

    @Override
    public String toString() {
        return "AjaxDoneVo{" +
                "statusCode='" + statusCode + '\'' +
                ", message='" + message + '\'' +
                ", navTabId='" + navTabId + '\'' +
                ", rel='" + rel + '\'' +
                ", callbackType='" + callbackType + '\'' +
                ", forwardUrl='" + forwardUrl + '\'' +
                ", confirmMsg='" + confirmMsg + '\'' +
                '}';
    }
}
