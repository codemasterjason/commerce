package com.lifeisquest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jason Park
 * @since v1.0.0
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class WebTestApplication {

  public static void main(String[] args) {

    SpringApplication.run(WebTestApplication.class, args);
  }
}
