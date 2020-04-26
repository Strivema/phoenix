package com.ray.admin.security;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

/**
 * 封装权限
 *
 * @author Marie
 * @date 2020/4/26 10:33 PM
 **/
@Data
public class GrantedAuthorityImpl implements GrantedAuthority {

    private String authority;

    public GrantedAuthorityImpl(String authority) {
        this.authority = authority;
    }
}
