package org.example.test.objectTo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReflectUtil {

    public  static List<Map<String,Object>> reflect(Object o) {
        //获取参数类
        Class cls = o.getClass();
        //将参数类转换为对应属性数量的Field类型数组（即该类有多少个属性字段 N 转换后的数组长度即为 N）
        Field[] fields = cls.getDeclaredFields();
        List<Map<String,Object>> list = new ArrayList<>();
        for (int i = 0; i < fields.length; i++) {
            Map<String,Object> map = new HashMap<>();
            Field f = fields[i];
            f.setAccessible(true);
            try {
                //f.getName()得到对应字段的属性名，f.get(o)得到对应字段属性值,f.getGenericType()得到对应字段的类型
                System.out.println("属性名：" + f.getName() + "；属性值：" + f.get(o) + ";字段类型：" + f.getGenericType());
                map.put(f.getName(),f.get(0));
                list.add(map);

            } catch (IllegalArgumentException | IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return list;
    }

  /*  public static void main(String[] args) {
        Student s = new Student();
        s.setName("张三");
        s.setAge(12);
        s.setGrade(89);
        reflect(s);
    }*/
}