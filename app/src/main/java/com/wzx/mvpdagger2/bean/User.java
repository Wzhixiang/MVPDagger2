package com.wzx.mvpdagger2.bean;

/**
 * 描述 TODO
 * Created by Administrator on 2017/12/25.
 * 公司名称 广州安腾网络科技有限公司
 */

public class User {
    private String avatar;//头像链接
    private Long id;//用户id
    private String nickname;//昵称
    private String password;
    private String phone;//手机号
    private String signature;//个性签名
    private String email_validate;//邮箱
    private int gender;//性别：1man,0woman
    private boolean rst;
    private int state;
    private String username;//用户账号
    private String token;//token

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getEmail_validate() {
        return email_validate;
    }

    public void setEmail_validate(String email_validate) {
        this.email_validate = email_validate;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public boolean isRst() {
        return rst;
    }

    public void setRst(boolean rst) {
        this.rst = rst;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
