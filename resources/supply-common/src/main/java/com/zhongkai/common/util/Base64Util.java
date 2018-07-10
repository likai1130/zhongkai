package com.zhongkai.common.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @author zhaocc
 * @ClassName: Base64Util
 * @Description: TODO(Base64工具类)
 * @date 2017年6月9日 下午2:28:47
 * @Copyright © 2017北京数人科技有限公司
 */
@SuppressWarnings("restriction")
public class Base64Util {

    /**
     * @return String
     * @method getBase64(加密)
     * @author zhaocc
     * @date 2017年6月9日 下午2:31:47
     */
    public static String getBase64(String str) {

        byte[] b = null;
        String s = null;
        try {
            b = str.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (b != null) {
            s = new BASE64Encoder().encode(b);
        }
        return s;
    }

    /**
     * @return byte[]
     * @method decode(解密)
     * @author zhaocc
     * @date 2017年6月9日 下午2:32:02
     */
    public static byte[] decode(String str) {

        byte[] bt = null;
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            bt = decoder.decodeBuffer(str);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bt;
    }
}
