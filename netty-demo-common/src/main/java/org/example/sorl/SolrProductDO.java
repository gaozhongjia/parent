package org.example.sorl;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(collection = "test_11")
public class SolrProductDO {

    /**
     * ID 主键
     */
    @Id
    @Indexed(name = "id", type = "int")
    private Integer id;

    /**
     * SPU 名字
     */
    @Indexed(name = "name", type = "string")
    private String name;
    /**
     * 描述
     */
    @Indexed(name = "description", type = "string")
    private String description;
    /**
     * 分类编号
     */
    @Indexed(name = "cid", type = "cid")
    private Integer cid;
    /**
     * 分类名
     */
    @Indexed(name = "category_name", type = "string")
    private String categoryName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}