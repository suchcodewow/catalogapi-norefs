package com.dbic.catalogApi.controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;

@RestController
public class StatusController {
	@Value("${app.appVersion:notset}")
    private String appVersion;
	@Value("${spring.cloud.gcp.sql.instance-connection-name:notset}")
    private String instance;
	@Value("${spring.cloud.gcp.sql.database-name:notset}")
    private String database;

	@GetMapping("/")
		public Map<String, String> statusMessage() {
    	HashMap<String, String> map = new HashMap<>();
    	map.put("instance", instance);
    	map.put("Database", database);
    	map.put("appVersion", appVersion);
    	map.put("Status", "OK @ /api/v1/catalog");
    return map;
	}
}
