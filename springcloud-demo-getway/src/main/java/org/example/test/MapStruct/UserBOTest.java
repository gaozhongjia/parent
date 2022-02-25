package org.example.test.MapStruct;

public class UserBOTest {

    public static void main(String[] args) {
        // 创建 UserDO 对象
        UserDO userDO = new UserDO(){{
            setId(1);
            setUsername("yudaoyuanma");
            setPassword("buzhidao");
        }};
        // <X> 进行转换
        UserBO userBO = UserConvert.INSTANCE.convert(userDO);
        System.out.println(userBO.getId());
        System.out.println(userBO.getUsername());
        System.out.println(userBO.getPassword());
    }

}