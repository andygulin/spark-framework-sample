package spark.framework.sample.bean;

import java.io.Serializable;

public class Result implements Serializable {

    private boolean ret;
    private Object data;

    public Result(boolean ret, Object data) {
        this.ret = ret;
        this.data = data;
    }

    public boolean isRet() {
        return ret;
    }

    public void setRet(boolean ret) {
        this.ret = ret;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
