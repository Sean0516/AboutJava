package com.controller;

import com.common.user.UserNotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sean
 * @date 2020/3/23  16:38
 */
@RestController
public class DemoController {
    @RequestMapping("demo")
    public String demo() {
        if (true) {
            throw new UserNotFoundException();
        }
        return "demo";
    }
}
