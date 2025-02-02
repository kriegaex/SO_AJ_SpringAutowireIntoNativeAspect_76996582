package com.example.svc.configuration;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfiguration {

  @Bean
  public ObjectMapper createMapper() {
    ObjectMapper m = new ObjectMapper();
    m.registerModule(new JavaTimeModule());
    m.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    m.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    m.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
    m.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    m.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    return m;
  }

}
