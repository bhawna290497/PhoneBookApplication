package com.app.PhoneBookApp.props;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "app")
@Getter
@Setter
public class ApiProps {

	private Map<String,String> messages=new HashMap<String,String>();	
}
