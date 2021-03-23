package com.sizheming.webstudy.service;

/**
 * @ClassName LoginService
 * @Description TODO
 * @Author Chris
 * @Date 2021/3/23
 **/


import com.sizheming.webstudy.dao.LoginDao;
import com.sizheming.webstudy.domain.User;

import javax.servlet.http.HttpSession;

public class LoginService {

    LoginDao loginDao = new LoginDao();

    public String login(String username, String password,
                        HttpSession session) {
        User user = loginDao.selectOne(username);
        if (user == null) {
            return "用户不存在";
        } else {
            if (password.equals(user.getPassword())) {
                session.setAttribute("user", user);
                session.setAttribute("isLogin", true);
                return "1";
            } else {
                return "密码错误";
            }
        }
    }
}
