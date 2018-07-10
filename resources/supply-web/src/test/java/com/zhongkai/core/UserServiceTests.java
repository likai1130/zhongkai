package com.zhongkai.core;

import com.zhongkai.SupplyManageApplication;
import com.zhongkai.core.entity.User;
import com.zhongkai.core.service.user.UserServices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName: UserServiceTests
 * @Description:
 * @date 2018/1/26
 * @Copyright © 2017北京数人科技有限公司
 */
@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = SupplyManageApplication.class)
public class UserServiceTests {

    @Autowired
    private UserServices userServices;

    @Test
    public void loginService(){
        String[] unames = new String[]{"aa","bb","cc","dd","ee","rr"};
        for (int i = 0; i<unames.length; i++){
            User user = new User();
            String password ="123";
            user.setUserName(unames[i]);
            user.setPassword(password);
            //String integer = userServices.loginService(user);
           // System.out.println(integer);
            userServices.addUser(user);

        }
    }

    @Test
    public void addUser(){
        User user = new User();
        String userName = "kli";
        String password ="123";
        user.setUserName(userName);
        user.setPassword(password);
        user.setEmail("222.3333");
        user.setFullname("kkkk");
        user.setPhone("110");
        System.out.println(userServices.addUser(user));
    }
}
