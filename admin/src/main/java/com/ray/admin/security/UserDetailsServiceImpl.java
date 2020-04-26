package com.ray.admin.security;

import com.ray.admin.entity.SysUser;
import com.ray.admin.service.ISysUserService;
import com.ray.core.exception.PhoenixException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Marie
 * @date 2020/4/26 10:35 PM
 **/
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ISysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        SysUser user = sysUserService.getByName(name);
        if (null == name) {
            throw new PhoenixException("该用户不存在");
        }
        Set<String> permissions = sysUserService.findPermissions(name);
        List<GrantedAuthorityImpl> grantedAuthorities = permissions.stream().map(GrantedAuthorityImpl::new).collect(Collectors.toList());

        JwtUserDetails jwtUserDetails = new JwtUserDetails();
        jwtUserDetails.setAuthorities(grantedAuthorities);
        jwtUserDetails.setPassword(user.getPassword());
        jwtUserDetails.setSalt(user.getSalt());
        jwtUserDetails.setUsername(user.getName());
        return jwtUserDetails;
    }
}
