package com.wzx.mvpdagger2.http.rx;


import com.google.gson.annotations.SerializedName;

/**
 * 服务端返回数据结构
 */
public class ServerResponse {

    /*另起名字*/
    @SerializedName("status")
    private String status;
    @SerializedName("msg")
    private String msg;

    public ServerResponse(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public boolean isSuccess(String successCode) {
        return status.equals(successCode);
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
}
