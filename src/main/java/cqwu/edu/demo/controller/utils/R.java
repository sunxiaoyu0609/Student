package cqwu.edu.demo.controller.utils;
//前后端数据访问协议
public class R {
    private Boolean flag;
    private Object data;
    private String message;

    public R(String message) {
        this.message = message;
    }

    public R(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }
    public R(Boolean flag) {
        this.flag = flag;
    }

    public R(Boolean flag, String message) {
        this.flag = flag;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getFlag() {
        return flag;
    }

    public Object getData() {
        return data;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
