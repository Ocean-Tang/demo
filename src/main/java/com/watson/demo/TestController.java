package com.watson.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangcanjie
 */
@RequestMapping("/test")
@RestController
public class TestController {

    @GetMapping("/")
    public String test() {
        return "Hello, World!";
    }

}
