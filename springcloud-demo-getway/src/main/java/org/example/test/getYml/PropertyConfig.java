/*
package org.example.test.getYml;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class PropertyConfig {
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        PropertySourcesPlaceholderConfigurer configurer 
            = new PropertySourcesPlaceholderConfigurer();
        YamlPropertiesFactoryBean yamlProFb
            = new YamlPropertiesFactoryBean();
        yamlProFb.setResources(new ClassPathResource("application2.yml"));
        configurer.setProperties(yamlProFb.getObject());
        return configurer;
    }
}*/
