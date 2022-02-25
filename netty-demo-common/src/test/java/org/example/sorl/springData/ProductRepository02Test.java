package org.example.sorl.springData;

import org.example.App;
import org.example.sorl.SolrProductDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class ProductRepository02Test {

    @Autowired
    private ProductRepository02 productRepository;

    @Test // 根据名字获得一条记录
    public void testFindByName() {
        SolrProductDO product = productRepository.findByName("哈哈哈哈");
        System.out.println(product);
    }

}