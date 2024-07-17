package com.example.Controller;

import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.pojo.ApiVisibility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.system.SystemInfo;
import com.example.Service.system.SystemInfoService;

@Api(name = "System Info Controller", description = "This is a System Info controller for demonstration purposes",group="System",visibility = ApiVisibility.PUBLIC)
@RestController
@RequestMapping("/api/v1/system-details")
//@Api(tags = "SystemInfo Controller", description = "To checking System Resources")
public class SystemInfoController {

    @Autowired
    private SystemInfoService systemInfoService;

    private static final Logger logger = LoggerFactory.getLogger(SystemInfoController.class);

    @ApiMethod(description = "Get sample message")
    @GetMapping(value="/system-msg")
    //@ApiOperation("Greeting message by system")
    public ResponseEntity<String> getResponse(){
        String response = "Welcome to Information of the System";
        logger.info("response: {}", response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiMethod(description = "To Get system details")
    @GetMapping("/system-info")
    //@ApiOperation("To Retrieving the system resources")
    public SystemInfo getSystemInfo() {
        logger.info("MethodName: {}", "getSystemInfo");
        return systemInfoService.getSystemInfo();
    }
}

/*
    http://localhost:9999/jsondoc-ui.html
    http://localhost:9999/jsondoc
 */