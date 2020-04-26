package com.ray.admin.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.ray.admin.entity.SysUser;
import com.ray.admin.security.JwtAuthenticationToken;
import com.ray.admin.service.ISysUserService;
import com.ray.admin.utils.SecurityUtils;
import com.ray.admin.vo.LoginBean;
import com.ray.common.utils.IOUtils;
import com.ray.common.utils.PasswordUtils;
import com.ray.core.http.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 登录前端控制器
 *
 * @author Marie
 * @date 2020/4/26 11:44 PM
 **/
@RestController
public class SysLoginController {
    @Autowired
    private Producer producer;

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public void captcha(HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

// 生成文字验证码
        String text = producer.createText();
// 生成图片验证码
        BufferedImage image = producer.createImage(text);
// 保存到验证码到 session
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, text);

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        IOUtils.closeQuietly(out);
    }

    @PostMapping(value = "/login")
    public HttpResult login(@RequestBody LoginBean loginBean, HttpServletRequest request) throws IOException {
        String username = loginBean.getAccount();
        String password = loginBean.getPassword();
        String captcha = loginBean.getCaptcha();
        // 从session中获取之前保存的验证码跟前台传来的验证码进行匹配
        Object kaptcha = request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (kaptcha == null) {
            return HttpResult.error("验证码已失效");
        }
        if (!captcha.equals(kaptcha)) {
            return HttpResult.error("验证码不正确");
        }
        // 用户信息
        SysUser user = sysUserService.getByName(username);
        // 账号不存在、密码错误
        if (user == null) {
            return HttpResult.error("账号不存在");
        }
        if (!PasswordUtils.matches(user.getSalt(), password, user.getPassword())) {
            return HttpResult.error("密码不正确");
        }
        // 账号锁定
        if (user.getStatus() == 0) {
            return HttpResult.error("账号已被锁定,请联系管理员");
        }
        // 系统登录认证
        JwtAuthenticationToken token = SecurityUtils.login(request, username, password, authenticationManager);
        return HttpResult.ok(token);
    }

}
