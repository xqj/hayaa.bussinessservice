package hayaa.bussiness.service.model;

import hayaa.basemodel.model.BaseData;

public class Custom extends BaseData {
    private Integer customId;

    public void setCustomId(Integer customIdvalue) {
        this.customId = customIdvalue;
    }

    public Integer getCustomId() {
        return this.customId;
    }

    private Integer customPersonId;

    public void setCustomPersonId(Integer customPersonIdvalue) {
        this.customPersonId = customPersonIdvalue;
    }

    public Integer getCustomPersonId() {
        return this.customPersonId;
    }

    private String nickName;

    public void setNickName(String nickNamevalue) {
        this.nickName = nickNamevalue;
    }

    public String getNickName() {
        return this.nickName;
    }

    private String photo;

    public void setPhoto(String photovalue) {
        this.photo = photovalue;
    }

    public String getPhoto() {
        return this.photo;
    }

    private Integer group;

    public void setGroup(Integer groupvalue) {
        this.group = groupvalue;
    }

    public Integer getGroup() {
        return this.group;
    }
}