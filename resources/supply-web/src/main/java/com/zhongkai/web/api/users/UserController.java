package com.zhongkai.web.api.users;

import com.zhongkai.auth.annotation.Authentication;
import com.zhongkai.common.util.HttpStatusCode;
import com.zhongkai.common.util.ResponseMapper;
import com.zhongkai.core.entity.User;
import com.zhongkai.core.service.user.UserServices;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: Controller
 * @Description: 访问入口
 * @date 2018/1/9
 * @Copyright © 2017北京数人科技有限公司
 */
@CrossOrigin(origins = "*", methods = { RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.POST, RequestMethod.GET,
        RequestMethod.DELETE, RequestMethod.PATCH })
@RestController
@RequestMapping(value = "/v1")
public class UserController {

    @Autowired
    private UserServices userServices;

    /**
     * 登录
     * @param user
     * @return
     */
    @ApiOperation(value = "登录", notes = "登录")
    @PostMapping(value = "/login")
    public ResponseMapper<String> login(@RequestBody User user) {
        ResponseMapper<String> responseMapper = new ResponseMapper<>();
        responseMapper.setResult(HttpStatusCode.SUCCESS,"登录成功",userServices.loginService(user));
        return responseMapper;
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @ApiOperation(value = "添加用户", notes = "添加用户")
    @PostMapping(value = "/users")
    public ResponseMapper<User> addUser(@RequestBody User user) {
        ResponseMapper<User> responseMapper = new ResponseMapper<>();
        responseMapper.setResult(HttpStatusCode.SUCCESS,"添加成功",userServices.addUser(user));
        return responseMapper;
    }

    /**
     * 获取所有用户
     * @return
     */
    @Authentication
    @ApiOperation(value = "获取所有用户", notes = "获取所有用户")
    @GetMapping(value = "/users")
    public ResponseMapper<List<User>> getUsers(
           // @ApiParam(required = true, name = "authorization", value = "请求头token权限认证") @RequestHeader String authorization
    ){
        ResponseMapper<List<User>> responseMapper = new ResponseMapper<>();
        List<User> users = userServices.getUsers();
        System.out.println(users);
        responseMapper.setResult(HttpStatusCode.SUCCESS,"获取成功",users);
        return responseMapper;
    }

    /**
     * 获取所有用户
     * @return
     */
    @Authentication
    @ApiOperation(value = "登出", notes = "登出")
    @PostMapping(value = "/logout")
    public ResponseMapper<String> logout(@ApiParam(required = true, name = "authorization", value = "请求头token权限认证") @RequestHeader String authorization){
        ResponseMapper<String> responseMapper = new ResponseMapper<>();
        userServices.logOut(authorization);
        responseMapper.setResult(HttpStatusCode.SUCCESS,"获取成功");
        return responseMapper;
    }

}
