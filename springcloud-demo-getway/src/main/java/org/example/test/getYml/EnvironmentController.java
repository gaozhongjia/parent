package org.example.test.getYml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.YamlMapFactoryBean;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Properties;

@RestController
public class EnvironmentController {
    @Autowired
    private Environment environment;

    //person:
    //  name: hydra
    //  gender: male
    //  age: 18


    // 方式一  Environment
    @GetMapping("envTest")
    private void getEnv(){
        System.out.println(environment.getProperty("person.name"));
        System.out.println(environment.getProperty("person.gender"));

        Integer autoClose = environment
            .getProperty("person.age", Integer.class);
        System.out.println(autoClose);
        String defaultValue = environment
            .getProperty("person.other", String.class, "defaultValue");
        System.out.println(defaultValue);
    }


    // 方式二 YamlPropertiesFactoryBean
    // 配合 PropertyConfig 这个类使用

    @GetMapping("fcTest")
    public void ymlProFctest(){
        YamlPropertiesFactoryBean yamlProFb = new YamlPropertiesFactoryBean();
        yamlProFb.setResources(new ClassPathResource("application2.yml"));
        Properties properties = yamlProFb.getObject();
        System.out.println(properties.get("person2.name"));
        System.out.println(properties.get("person2.gender"));
        System.out.println(properties.toString());
    }

    @GetMapping("fcMapTest")
    public void ymlMapFctest(){
        YamlMapFactoryBean yamlMapFb = new YamlMapFactoryBean();
        yamlMapFb.setResources(new ClassPathResource("application2.yml"));
        Map<String, Object> map = yamlMapFb.getObject();
        System.out.println(map);
    }

}