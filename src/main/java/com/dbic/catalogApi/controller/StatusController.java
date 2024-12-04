package com.dbic.catalogApi.controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
// import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

@RestController
public class StatusController {
	// @Value("${app.appVersion:notset}")
    // private String appVersion;
	// @Value("${app.instance:notset}")
    // private String instance;
	// @Value("${app.database:notset}")
    // private String database;

	@Autowired
    private Environment environment;

	@GetMapping("/")
		public Map<String, String> statusMessage() {
    	HashMap<String, String> map = new HashMap<>();
    	map.put("instance", environment.getProperty("instance"));
    	map.put("Database", environment.getProperty("Database"));
    	map.put("appVersion", environment.getProperty("appVersion"));
    	map.put("Status", "OK");
    return map;
	}
}
