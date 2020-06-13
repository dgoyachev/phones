package com.calltouch.phones.web.controller;

import com.calltouch.phones.domain.PhoneData;
import com.calltouch.phones.domain.criteria.PhoneSearchCriteria;
import com.calltouch.phones.service.PhoneService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by morgan on 30.05.2020
 */

@RestController
@RequestMapping("/phones")
@Api(value = "Simple phone controller", description = "Simple phone controller description")
public class PhoneController {

    private final PhoneService phoneService;

    @Autowired
    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @GetMapping("/test")
    @ApiOperation(value = "Print out test string", response = String.class)
    public String test(Principal principal) {
        System.err.println(principal);
        return "test";

    }

    @GetMapping("/list")
    public Page<PhoneData> list(@ModelAttribute PhoneSearchCriteria criteria, Pageable pageable) {
        return phoneService.list(criteria, pageable);
    }
}
