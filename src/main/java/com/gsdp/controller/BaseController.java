package com.gsdp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by yizijun on 2016/10/31 0031.
 */
@Controller
public class BaseController {

    /**
     * 当直接访问我们项目的根目录，直接跳转到index.jsp
     * TODO 这里只是做了一个跳转，并没有做相关的查询数据操作
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String viewIndex() {
        return "index";
    }
}
