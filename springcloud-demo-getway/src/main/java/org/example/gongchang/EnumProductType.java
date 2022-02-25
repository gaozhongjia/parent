package org.example.gongchang;

/**
 * @author gaozj
 * @date 2022年01月05日 9:34
 */
public enum EnumProductType {

    activityOne("one"),
    activityTwo("two");

    private String name;

    EnumProductType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
