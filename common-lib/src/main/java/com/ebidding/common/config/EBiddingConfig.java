package com.ebidding.common.config;

import com.ebidding.common.auth.AuthorizeInterceptor;
import com.ebidding.common.auth.FeignRequestHeaderInterceptor;
import feign.RequestInterceptor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Import({GlobalExceptionHandler.class})
public class EBiddingConfig implements WebMvcConfigurer {
    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthorizeInterceptor());
    }

    @Bean
    public RequestInterceptor feignRequestInterceptor() {
        return new FeignRequestHeaderInterceptor();
    }
}
