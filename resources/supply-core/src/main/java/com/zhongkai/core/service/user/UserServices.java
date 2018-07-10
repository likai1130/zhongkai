package com.zhongkai.core.service.user;

import com.zhongkai.common.exception.NameRepetitionException;
import com.zhongkai.common.exception.ParameterErrorExecption;
import com.zhongkai.common.exception.ResponseException;
import com.zhongkai.common.util.HttpStatusCode;
import com.zhongkai.common.util.MD5Util;
import com.zhongkai.common.util.TokenUtil;
import com.zhongkai.core.dao.user.UserRepository;
import com.zhongkai.core.entity.User;
import com.zhongkai.core.service.auth.AccessTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: LoginService
 * @Description: 登录
 * @date 2018/1/15
 * @Copyright © 2017北京数人科技有限公司
 */
@Service
public class UserServices {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AccessTokenService accessTokenService;
    /**
     * 登录
     * @param user
     */
    public String loginService(User user){
        String userName = user.getUserName();
        String password = user.getPassword();
        String passwordMd5 = MD5Util.MD5(password);
        Integer integer = userRepository.countAllByUserNameAndPassword(userName, passwordMd5);
        if (integer>0){
            String token = accessTokenService.createToken(userName, TokenUtil.genarateToken(userName, password));
            return token;
        }else {
            throw new ParameterErrorExecption(HttpStatusCode.BADREQUEST,"用户名或密码不正确");
        }
    }

    /**
     * 登出
     * @param token
     */
    @Transactional
    public void logOut(String token){
         accessTokenService.clearToken(token);
    }

    /**
     * 新增用户
     * @param user
     * @return
     */
    public User addUser(User user) {
        String md5 = MD5Util.MD5(user.getPassword());
        user.setPassword(md5);
        try {
            return  userRepository.save(user);
        }catch (DataIntegrityViolationException e){
            throw new NameRepetitionException(409,"该用户已存在");
        }
    }

    /**
     * 获取所有用户
     * @return
     */
    public List<User> getUsers(){
        return  userRepository.findAll();
    }

}
