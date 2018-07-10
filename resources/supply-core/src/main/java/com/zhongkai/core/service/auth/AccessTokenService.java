package com.zhongkai.core.service.auth;

import com.zhongkai.common.util.TimeConversionUtil;
import com.zhongkai.core.dao.user.LoginUserRepository;
import com.zhongkai.core.dao.user.UserRepository;
import com.zhongkai.core.entity.LoginUser;
import com.zhongkai.core.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;

/**
 * @ClassName: AccessTokenService
 * @Description: token认证
 * @date 2018/1/28
 * @Copyright © 2017北京数人科技有限公司
 */
@Service
public class AccessTokenService {

    @Autowired
    private LoginUserRepository loginUserRepository;

    @Autowired
    private UserRepository userRepository;

    protected int tokenExpireSeconds = 7 * 24 * 3600;

    /**
     * 判断token是否存在，是否有效
     * @param token
     * @return
     */
    public boolean checkToken(String token) throws ParseException {
        LoginUser loginUserByToken = loginUserRepository.findLoginUserByToken(token);
        if (loginUserByToken!=null){
            long timeMillis = System.currentTimeMillis();
            String expireAt = loginUserByToken.getExpireAt();
            long expireAtTime = TimeConversionUtil.dateToTimeStamp(expireAt);
            if (timeMillis>expireAtTime){
                return false;
            }else {
                return true;
            }
        }else {
            return false;
        }
    }

    /**
     * 获取用户信息
     * @param token
     * @return
     */
    public User getUserByToken(String token){
        LoginUser loginUserByToken = loginUserRepository.findLoginUserByToken(token);
        String userName = loginUserByToken.getUserName();
        User userByUserName = userRepository.findUserByUserName(userName);
        return userByUserName;
    }
    /**
     * 创建token
     * @param userName
     * @param token
     * @return
     */
    public String createToken(String userName, String token){
        long timeMillis = System.currentTimeMillis();
        //token失效时间
        String date = TimeConversionUtil.timeStampToDate(timeMillis + tokenExpireSeconds * 1000);
        LoginUser loginUser = new LoginUser(userName, token, date);
        LoginUser save = loginUserRepository.saveAndFlush(loginUser);
        if (save!=null){
            return save.getToken();
        }else {
            return null;
        }
    }


    /**
     * 清除token
     * @param token
     */
    public void clearToken(String token){
        loginUserRepository.deleteLoginUserByToken(token);
    }
}
