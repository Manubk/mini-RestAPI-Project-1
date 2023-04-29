package com.jrtp.properties;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "app-msgs")
@Configuration
public class AppMessages {
	
	private Map<String, String> messages = new HashMap<>();
	
}
