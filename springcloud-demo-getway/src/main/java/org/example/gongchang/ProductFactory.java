package org.example.gongchang;

/**
 * 抽象工厂实现方法
 * @author gaozj
 * @date 2022年01月05日 9:36
 */
public class ProductFactory extends FactoryMethod{
    @Override
    protected Product createProduct(String name) {
        if (EnumProductType.activityOne.getName().equals(name)){
            return new OneProduct();
        }else if (EnumProductType.activityTwo.getName().equals(name)){
            return new TwoProduct();
        }
        return null;
    }

    public static class OneProduct extends Product{

    }

    public static class TwoProduct extends Product{

    }
}
