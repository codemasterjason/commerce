package com.quest.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * @author Jason Park
 * @since v1.0.0
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

  /**
   * Create object mapper to support hibernate lazy mode.
   *
   * @return MappingJackson2HttpMessageConverter
   */
  public MappingJackson2HttpMessageConverter jacksonMessageConverter(){
    MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();

    ObjectMapper mapper = new ObjectMapper();
    //Registering Hibernate4Module to support lazy objects
    mapper.registerModule(new Hibernate4Module());
    messageConverter.setObjectMapper(mapper);

    return messageConverter;
  }

  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    converters.add(jacksonMessageConverter());
    super.configureMessageConverters(converters);
  }
}
