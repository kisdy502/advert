package com.sdt.advert;

import com.sdt.advert.utils.MyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

@Component
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(DefaultInterceptor.class);
    @Resource
    private DefaultInterceptor baseInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(baseInterceptor);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String path = MyUtils.getUploadFilePath() + "upload/";
        logger.info("path:{}", path);
        registry.addResourceHandler("/upload/**").addResourceLocations("file:" + MyUtils.getUploadFilePath() + "upload/");
        super.addResourceHandlers(registry);
    }
}
