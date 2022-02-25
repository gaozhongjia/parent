package org.example.sorl;

import org.springframework.data.solr.repository.SolrCrudRepository;

public interface ProductRepository extends SolrCrudRepository<SolrProductDO, Integer> {

}