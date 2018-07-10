package com.zhongkai.auth.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName: Permission
 * @Description: 权限控制
 * @date 2018/1/11
 * @Copyright © 2017北京数人科技有限公司
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Authentication {

}
