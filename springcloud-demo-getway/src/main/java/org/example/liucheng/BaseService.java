package org.example.liucheng;

import org.springframework.aop.config.AopConfigUtils;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author gaozj
 * @date 2022年01月07日 10:21
 */
public class BaseService implements ApplicationContextAware {
    // spring bean 上下文
    protected  static  ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        BaseService.applicationContext = applicationContext;
    }

    public static Object getBeanByName(String name) {
        return applicationContext.getBean(name);
    }

    /**
     * 根据class 类型获取bean
     *
     */
    public static <T> T getSingleBeanByType(Class<T> clazz) throws Exception{
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames){
            Object beanByName = getBeanByName(beanName);
            if (beanByName != null){
                Object target = AopProxyUtils.getSingletonTarget(beanByName);
                if (clazz.getName().equals(target.getClass().getName())){
                    return (T) beanByName;
                }
            }
        }
        throw new RuntimeException();
    }
}
