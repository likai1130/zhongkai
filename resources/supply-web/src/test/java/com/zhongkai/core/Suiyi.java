package com.zhongkai.core;

import io.swagger.models.auth.In;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @ClassName: Suiyi
 * @Description:
 * @date 2018/2/2
 * @Copyright © 2017北京数人科技有限公司
 */
public class Suiyi {

    public static void main(String[] args){
        List<Integer> numbersList = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> numbersStream  = numbersList.stream();
        System.out.println("int强制类型转换为byte后的值等于"+numbersStream);
    }
}
