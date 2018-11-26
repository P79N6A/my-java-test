package priv.zc.autosign.vo;

public class ResultVo {
	private long code;
	private String msg;
	private Object data;

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResultVo [code=" + code + ", msg=" + msg + ", data=" + data + "]";
	}

	public ResultVo(long code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public ResultVo() {
	}

	
	public static ResultVo success(Object data){
		return new ResultVo(0,"success",data);
	}
}
