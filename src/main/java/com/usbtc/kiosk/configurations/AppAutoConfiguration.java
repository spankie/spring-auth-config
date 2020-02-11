package com.usbtc.kiosk.configurations;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * AppAutoConfiguration
 */
@Configuration
@ConditionalOnProperty(name = "api.spankie.logfilter", havingValue = "true")
public class AppAutoConfiguration {

  @Bean
  public FilterRegistrationBean<LogFilter> myLogFilter() {
    FilterRegistrationBean<LogFilter> frb = new FilterRegistrationBean<>();
    frb.setFilter(new LogFilter());
    return frb;
  }
}