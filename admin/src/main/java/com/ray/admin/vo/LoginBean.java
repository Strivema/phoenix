package com.ray.admin.vo;

import lombok.Data;

/**
 * @author Marie
 * @date 2020/4/26 11:53 PM
 **/
@Data
public class LoginBean {
    private String account;
    private String password;
    private String captcha;

}
