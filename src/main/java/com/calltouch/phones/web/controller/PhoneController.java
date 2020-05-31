package com.calltouch.phones.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by morgan on 30.05.2020
 */

@RestController
@RequestMapping("/phones")
public class PhoneController {

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
