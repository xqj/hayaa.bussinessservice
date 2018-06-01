package hayaa.bussiness.service.model;

import hayaa.basemodel.model.BaseData;

public class Order extends BaseData {
    private Integer orderId;

    public void setOrderId(Integer orderIdvalue) {
        this.orderId = orderIdvalue;
    }

    public Integer getOrderId() {
        return this.orderId;
    }

    private String orderCode;

    public void setOrderCode(String orderCodevalue) {
        this.orderCode = orderCodevalue;
    }

    public String getOrderCode() {
        return this.orderCode;
    }

    private Integer spuId;

    public void setSpuId(Integer spuIdvalue) {
        this.spuId = spuIdvalue;
    }

    public Integer getSpuId() {
        return this.spuId;
    }

    private Integer skuId;

    public void setSkuId(Integer skuIdvalue) {
        this.skuId = skuIdvalue;
    }

    public Integer getSkuId() {
        return this.skuId;
    }

    private Double price;

    public void setPrice(Double pricevalue) {
        this.price = pricevalue;
    }

    public Double getPrice() {
        return this.price;
    }

    private Integer status;

    public void setStatus(Integer statusvalue) {
        this.status = statusvalue;
    }

    public Integer getStatus() {
        return this.status;
    }
}