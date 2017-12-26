package com.wzx.mvpdagger2.mvp.modle;

/**
 * 描述 TODO
 * Created by Administrator on 2017/11/3.
 * 公司名称 广州安腾网络科技有限公司
 */

public class UserBean {
    private Long id;
    private String account;
    private String nickName;
    private int sex;//0man:2woman

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
