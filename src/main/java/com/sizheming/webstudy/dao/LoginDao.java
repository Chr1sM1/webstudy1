package com.sizheming.webstudy.dao;

/**
 * @ClassName LoginDao
 * @Description TODO
 * @Author Chris
 * @Date 2021/3/23
 **/


import com.sizheming.webstudy.db.JDBCUtil;
import com.sizheming.webstudy.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {

    public User selectOne(String username) {
        User user = null;
        try (ResultSet resultSet =
                     JDBCUtil.getInstance().executeQueryRS("select * from borrow_card where username=?",
                             new Object[]{username})) {

            while (resultSet.next()) {
                user = new User(resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("reader"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}
