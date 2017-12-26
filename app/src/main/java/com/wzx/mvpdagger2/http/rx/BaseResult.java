package com.wzx.mvpdagger2.http.rx;


import com.google.gson.annotations.SerializedName;

public class BaseResult<T> {

    @SerializedName("sta")
    private String status;
    @SerializedName("msg")
    private String msg;
    @SerializedName("hourly")
    private T data;

    @Override
    public String toString() {
        return "BaseResult{" +
                "status='" + status + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public boolean isSuccess() {
        return status.equals("1");
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
