package hayaa.bussiness.service.model;

import hayaa.basemodel.model.BaseData;

public class Sku extends BaseData {
    private Integer skuId;

    public void setSkuId(Integer skuIdvalue) {
        this.skuId = skuIdvalue;
    }

    public Integer getSkuId() {
        return this.skuId;
    }

    private Integer spuId;

    public void setSpuId(Integer spuIdvalue) {
        this.spuId = spuIdvalue;
    }

    public Integer getSpuId() {
        return this.spuId;
    }

    private String name;

    public void setName(String namevalue) {
        this.name = namevalue;
    }

    public String getName() {
        return this.name;
    }

    private String title;

    public void setTitle(String titlevalue) {
        this.title = titlevalue;
    }

    public String getTitle() {
        return this.title;
    }

    private Double price;

    public void setPrice(Double pricevalue) {
        this.price = pricevalue;
    }

    public Double getPrice() {
        return this.price;
    }

    private Integer total;

    public void setTotal(Integer totalvalue) {
        this.total = totalvalue;
    }

    public Integer getTotal() {
        return this.total;
    }
}