package com.zhongkai.core.dao.user;

import com.zhongkai.core.entity.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginUserRepository extends JpaRepository<LoginUser,String> {

    LoginUser findLoginUserByToken(String token);

    void deleteLoginUserByToken(String token);
}
