package org.example.gongchang;

/**
 * 工厂方法模式
 * @author gaozj
 * @date 2022年01月05日 9:30
 */
public abstract class FactoryMethod {

    protected  abstract Product createProduct(String  name);

    public Product Product(String activity,String name){
        Product product = createProduct(name);
        product.setProductName(name);
        return product;
    }

    public static class Product{
        public String productName;

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }
    }


}
