package com.zhongkai.core.dao.user;

import com.zhongkai.core.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer>{

    Integer countAllByUserNameAndPassword(String userName, String password);

    User findUserByUserName(String userName);
}