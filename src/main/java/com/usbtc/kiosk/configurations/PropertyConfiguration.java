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
  private String from = "From Jide";
  private boolean logfilter;

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

  public boolean isLogFilter() {
    return logfilter;
  }

  public void setLogFilter(boolean logfilter) {
    this.logfilter = logfilter;
  }

}