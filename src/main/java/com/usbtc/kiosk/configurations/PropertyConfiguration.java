package com.usbtc.kiosk.configurations;

import org.modelmapper.ModelMapper;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "api.spankie")
public class PropertyConfiguration {

  private String url;
  private int port;
  private String from;
  private boolean mylog;

  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }

  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public final String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public boolean isMylog() {
    return mylog;
  }

  public void setMylog(boolean mylog) {
    this.mylog = mylog;
  }

  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }

}