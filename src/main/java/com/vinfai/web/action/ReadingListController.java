package com.vinfai.web.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author vinfai
 * @since 2017/5/10
 */
@Controller
@RequestMapping("/")
public class ReadingListController {

    @RequestMapping("/home")
    @ResponseBody
    String home(){
        return "hello world";
    }
}
