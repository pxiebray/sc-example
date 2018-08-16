package com.ztest.sc.business.user.vo;

/**
 * @author Administrator
 * @version 1.0
 * @data 2018/8/14 0014 00
 */
public class UserInfo {

    private Long id;
    private String name;
    private String img;
    private String sign;

    public UserInfo(Long id, String name, String img, String sign) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.sign = sign;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
