package com.example.research.dao;

import com.example.research.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ Author     ：zhangcx
 * @ Date       ：Created in 17:48 2018/8/14
 * @ Description：用户数据操作层
 * @ Modified By：
 * @Version: $version$
 */
public interface UserDao extends JpaRepository<User,Long> {
    User findByUserName(String userName);
    User findByUserNameOrEmail(String username, String email);
}
