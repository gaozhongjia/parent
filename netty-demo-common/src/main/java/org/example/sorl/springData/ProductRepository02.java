package org.example.sorl.springData;

import org.example.sorl.SolrProductDO;
import org.springframework.data.solr.repository.SolrCrudRepository;


//因为 Spring Data Solr 是 Spring Data 体系中的一员，所以也能享受到基于方法名查询的福利。
public interface ProductRepository02 extends SolrCrudRepository<SolrProductDO, Integer> {

    SolrProductDO findByName(String name);

}