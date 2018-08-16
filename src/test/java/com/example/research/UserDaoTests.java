package com.example.research;

import com.example.research.dao.UserDao;
import com.example.research.pojo.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

/**
 * @ Author     ：zhangcx
 * @ Date       ：Created in 17:51 2018/8/14
 * @ Description：用户单元测试类
 * @ Modified By：
 * @Version: $version$
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTests {
    @Autowired
    private UserDao userRepository;

    @Test
    public void test() throws Exception {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);
        List<User> list = userRepository.findAll();
        System.out.println("数量——————————————————————"+list.size());
        //userRepository.save(new User("aa4", "aa@126.com", "aa", "123456",formattedDate));
        //userRepository.save(new User("bb5", "bb@126.com", "bb", "23456",formattedDate));
        //userRepository.save(new User("cc6", "cc@126.com", "cc", "ccc123456",formattedDate));
        Thread.sleep(2000);
        Assert.assertEquals(6, userRepository.findAll().size());
        Assert.assertEquals("bb", userRepository.findByUserNameOrEmail("bb2", "bb").getNickName());
        userRepository.delete(userRepository.findByUserName("aa1"));
    }
}
