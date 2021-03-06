package com.lifeisquest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jason Park
 * @since v1.0.0
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableConfigurationProperties
public class ApiCommonApplication {

  public static void main(String[] args) {
    SpringApplication app = new SpringApplication(ApiCommonApplication.class);
    app.run(args);
  }
}
