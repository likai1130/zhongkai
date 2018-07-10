package com.zhongkai.web.exception;

import com.zhongkai.common.exception.AuthorityException;
import com.zhongkai.common.exception.NameRepetitionException;
import com.zhongkai.common.exception.OauthTokensException;
import com.zhongkai.common.exception.ParameterErrorExecption;
import com.zhongkai.common.util.HttpStatusCode;
import com.zhongkai.common.util.ResponseMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: GlobalExamptionHandler
 * @Description: 全局异常类
 * @date 2018/1/16
 * @Copyright © 2017北京数人科技有限公司
 */
@ControllerAdvice
@ResponseBody
public class GlobalExamptionHandler {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(NameRepetitionException.class)
    public ResponseMapper<String> NameRepetitionExceptionHandler(NameRepetitionException nre, HttpServletResponse response){
        logger.error(nre.getMessage(), nre);
        ResponseMapper<String> mapper = new ResponseMapper<String>();
        mapper.setCode(HttpStatusCode.CONFLICT);
        mapper.setMessage(nre.getMessage());
        response.setStatus(mapper.getCode());
        mapper.setData(nre.toString());
        return mapper;
    }

    @ExceptionHandler(AuthorityException.class)
    public ResponseMapper<String> authorityExceptionHandler(AuthorityException ae, HttpServletResponse response) {
        logger.error(ae.getMessage(), ae);
        ResponseMapper<String> mapper = new ResponseMapper<String>();
        mapper.setCode(HttpStatusCode.AUTHERROR);
        response.setStatus(mapper.getCode());
        mapper.setMessage("权限不足，请与管理员联系！");
        mapper.setData(ae.toString());
        return mapper;
    }

    @ExceptionHandler(OauthTokensException.class)
    public ResponseMapper<String> oauthTokensException(OauthTokensException ae, HttpServletResponse response) {
        logger.error(ae.getMessage(), ae);
        ResponseMapper<String> mapper = new ResponseMapper<String>();
        mapper.setCode(HttpStatusCode.TOKENERROR);
        response.setStatus(mapper.getCode());
        mapper.setMessage("Token失效，请与管理员联系！");
        mapper.setData(ae.toString());
        return mapper;
    }

    @ExceptionHandler(ParameterErrorExecption.class)
    public ResponseMapper<String> parameterErrorExecption(ParameterErrorExecption ae, HttpServletResponse response) {
        logger.error(ae.getMessage(), ae);
        ResponseMapper<String> mapper = new ResponseMapper<String>();
        mapper.setCode(HttpStatusCode.BADREQUEST);
        response.setStatus(mapper.getCode());
        mapper.setMessage("参数错误！");
        mapper.setData(ae.toString());
        return mapper;
    }

    @ExceptionHandler(Exception.class)
    public ResponseMapper<String> exceptionHandler(Exception e, HttpServletResponse response) {
        logger.error(e.getMessage(), e);
        ResponseMapper<String> mapper = new ResponseMapper<String>();
        mapper.setCode(HttpStatusCode.SERVERERROR);
        response.setStatus(mapper.getCode());
        mapper.setMessage("服务器故障，请与技术人员联系！");
        mapper.setData(e.toString());
        return mapper;
    }
}
