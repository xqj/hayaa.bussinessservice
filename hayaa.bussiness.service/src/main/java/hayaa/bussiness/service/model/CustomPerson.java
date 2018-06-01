package hayaa.bussiness.service.model;

import hayaa.basemodel.model.BaseData;

import java.util.Date;

public class CustomPerson extends BaseData {
    private Integer customPersonId;

    public void setCustomPersonId(Integer customPersonIdvalue) {
        this.customPersonId = customPersonIdvalue;
    }

    public Integer getCustomPersonId() {
        return this.customPersonId;
    }

    private String name;

    public void setName(String namevalue) {
        this.name = namevalue;
    }

    public String getName() {
        return this.name;
    }

    private Boolean sex;

    public void setSex(Boolean sexvalue) {
        this.sex = sexvalue;
    }

    public Boolean getSex() {
        return this.sex;
    }

    private Date birthday;

    public void setBirthday(Date birthdayvalue) {
        this.birthday = birthdayvalue;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    private String carID;

    public void setCarID(String carIDvalue) {
        this.carID = carIDvalue;
    }

    public String getCarID() {
        return this.carID;
    }
}