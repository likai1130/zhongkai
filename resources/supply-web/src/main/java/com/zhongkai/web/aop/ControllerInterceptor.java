package com.zhongkai.web.aop;

import com.alibaba.fastjson.JSON;
import com.zhongkai.common.exception.OauthTokensException;
import com.zhongkai.common.util.ResponseMapper;
import com.zhongkai.core.dao.audit.AuditRepository;
import com.zhongkai.core.entity.Audit;
import com.zhongkai.core.entity.User;
import com.zhongkai.core.service.auth.AccessTokenService;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.*;

/**
 * @ClassName: ControllerInterceptor
 * @Description: controller层日志拦截
 * @date 2018/1/9
 * @Copyright © 2017北京数人科技有限公司
 */
@Aspect
@Component
public class ControllerInterceptor {

    @Autowired
    AccessTokenService accessTokenService;

    @Autowired
    HttpServletRequest request;

    @Autowired
    private AuditRepository auditRepository;

    Long startTime = 0L;

    Audit autid = null;

    private static final Logger logger = LoggerFactory.getLogger(ControllerInterceptor.class);
    /**
     * 定义拦截器规则，拦截controller层
     */
    @Pointcut(value = "execution(* com.zhongkai.web.api..* (..))")
    public void controllerMethodPointcut() {}

    /**
     * tokenre认证 + 审计功能
     * @param joinPoint
     * @throws ParseException
     */
    @Before(value = "controllerMethodPointcut()")
    public void tokenAuthentation(JoinPoint joinPoint) throws ParseException {
        autid = new Audit();
        startTime = System.currentTimeMillis();
        //打印请求内容
        logger.info("===============请求内容===============");
        logger.info("请求地址:"+request.getRequestURL().toString());
        logger.info("请求方式:"+request.getMethod());
        logger.info("请求类方法:"+joinPoint.getSignature());
        logger.info("请求类方法参数:"+ Arrays.toString(joinPoint.getArgs()));
        if (!"GET".equals(request.getMethod())){
            autid.setRequestUrl(request.getRequestURL().toString());
            autid.setRequestMethod(joinPoint.getSignature().getName());
            autid.setRequestType(request.getMethod());
            autid.setParame(Arrays.toString(joinPoint.getArgs()));
            autid.setCreateAt(startTime);
            if ("login".equals(joinPoint.getSignature().getName())){
                Object[] args = joinPoint.getArgs();
                User user = (User) args[0];
                this.autid.setUserName(user.getUserName());
            }
        }
        String token = request.getHeader("Authorization");
        if (StringUtils.isNotBlank(token)){
            boolean isToken = accessTokenService.checkToken(token);
            if (isToken){
                String userName = accessTokenService.getUserByToken(token).getUserName();
                this.autid.setUserName(userName);
            }else{
                throw new OauthTokensException(401,"token失效,重新登录");
            }
        }
    }

    //在方法执行完结后打印返回内容
    @AfterReturning(returning = "responseMapper",pointcut = "controllerMethodPointcut()")
    public void methodAfterReturing(ResponseMapper responseMapper ){
        logger.info("--------------返回内容----------------");
        logger.info("Response内容:"+ JSON.toJSONString(responseMapper));
        autid.setResponse(JSON.toJSONString(responseMapper));
        logger.info("请求处理时间为:"+(System.currentTimeMillis() - startTime));
        auditRepository.save(autid);
    }
}
