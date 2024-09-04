package com.example.gatewayservice;

import io.netty.resolver.DefaultAddressResolverGroup;
import java.util.Arrays;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import reactor.netty.http.client.HttpClient;

@Configuration
public class CorsConfig extends CorsConfiguration {

  @Bean
  public CorsWebFilter corsFilter() {
    org.springframework.web.cors.CorsConfiguration corsConfiguration =
        new org.springframework.web.cors.CorsConfiguration();
    corsConfiguration.addAllowedOrigin("*");
    corsConfiguration.setAllowedMethods(
        Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD"));
    corsConfiguration.addAllowedHeader("origin");
    corsConfiguration.addAllowedHeader("content-type");
    corsConfiguration.addAllowedHeader("accept");
    corsConfiguration.addAllowedHeader("authorization");
    corsConfiguration.addAllowedHeader("cookie");
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", corsConfiguration);
    return new CorsWebFilter(source);
  }

  @Bean
  public HttpClient httpClient() {
    return HttpClient.create().resolver(DefaultAddressResolverGroup.INSTANCE);
  }

}
