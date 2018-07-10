package com.zhongkai.common.util;

/**
 * @author 张海阳
 * @ClassName: TokenUtil
 * @Description: TODO(Token工具类)
 * @date 2017年5月22日 下午6:48:27
 * @Copyright © 2017北京数人科技有限公司
 */
public class TokenUtil {

    /**
     * @return String
     * @method genarateToken(Token生成：md5(user_id + password + 当前时间)作为token。)
     * @author 张海阳
     * @date 2017年5月22日 下午4:00:27
     */
    public static String genarateToken(String username, String password) {

        return MD5Util.MD5(username + password + System.currentTimeMillis());
    }

}
