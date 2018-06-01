package hayaa.bussiness.service.model;

import hayaa.basemodel.model.BaseData;

public class Spu extends BaseData {
    private Integer spuId;

    public void setSpuId(Integer spuIdvalue) {
        this.spuId = spuIdvalue;
    }

    public Integer getSpuId() {
        return this.spuId;
    }

    private String spuCode;

    public void setSpuCode(String spuCodevalue) {
        this.spuCode = spuCodevalue;
    }

    public String getSpuCode() {
        return this.spuCode;
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

    private String defaultImg;

    public void setDefaultImg(String defaultImgvalue) {
        this.defaultImg = defaultImgvalue;
    }

    public String getDefaultImg() {
        return this.defaultImg;
    }

    private String content;

    public void setContent(String contentvalue) {
        this.content = contentvalue;
    }

    public String getContent() {
        return this.content;
    }
}