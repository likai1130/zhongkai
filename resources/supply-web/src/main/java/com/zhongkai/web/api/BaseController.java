package com.zhongkai.web.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: BaseController
 * @Description:
 * @date 2018/2/9
 * @Copyright © 2017北京数人科技有限公司
 */
@Controller
public class BaseController {

    /**
     * 初始化界面
     * @return
     */
    @RequestMapping(value = "/v1/index")
    public String index(){
        return "index";
    }
}
