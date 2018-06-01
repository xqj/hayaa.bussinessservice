package hayaa.bussiness.service.model;

import java.util.Date;
import java.util.List;

public class CustomPersonSearchPamater {
    private Integer customPersonId;

    public void setCustomPersonId(Integer customPersonIdvalue) {
        this.customPersonId = customPersonIdvalue;
    }

    public Integer getCustomPersonId() {
        return this.customPersonId;
    }

    private List<Integer> customPersonIdList;

    public void setcustomPersonIdList(List<Integer> customPersonIdvalue) {
        this.customPersonIdList = customPersonIdvalue;
    }

    public List<Integer> getcustomPersonIdList() {
        return this.customPersonIdList;
    }

    private Integer customPersonIdMax;

    public void setcustomPersonIdMax(Integer customPersonIdvalue) {
        this.customPersonIdMax = customPersonIdvalue;
    }

    public Integer getcustomPersonIdMax() {
        return this.customPersonIdMax;
    }

    private Integer customPersonIdMin;

    public void setcustomPersonIdMin(Integer customPersonIdvalue) {
        this.customPersonIdMin = customPersonIdvalue;
    }

    public Integer getcustomPersonIdMin() {
        return this.customPersonIdMin;
    }

    private String name;

    public void setName(String namevalue) {
        this.name = namevalue;
    }

    public String getName() {
        return this.name;
    }

    private List<String> nameList;

    public void setnameList(List<String> namevalue) {
        this.nameList = namevalue;
    }

    public List<String> getnameList() {
        return this.nameList;
    }

    private Boolean sex;

    public void setSex(Boolean sexvalue) {
        this.sex = sexvalue;
    }

    public Boolean getSex() {
        return this.sex;
    }

    private List<Boolean> sexList;

    public void setsexList(List<Boolean> sexvalue) {
        this.sexList = sexvalue;
    }

    public List<Boolean> getsexList() {
        return this.sexList;
    }

    private Boolean sexMax;

    public void setsexMax(Boolean sexvalue) {
        this.sexMax = sexvalue;
    }

    public Boolean getsexMax() {
        return this.sexMax;
    }

    private Boolean sexMin;

    public void setsexMin(Boolean sexvalue) {
        this.sexMin = sexvalue;
    }

    public Boolean getsexMin() {
        return this.sexMin;
    }

    private Date birthday;

    public void setBirthday(Date birthdayvalue) {
        this.birthday = birthdayvalue;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    private List<Date> birthdayList;

    public void setbirthdayList(List<Date> birthdayvalue) {
        this.birthdayList = birthdayvalue;
    }

    public List<Date> getbirthdayList() {
        return this.birthdayList;
    }

    private Date birthdayMax;

    public void setbirthdayMax(Date birthdayvalue) {
        this.birthdayMax = birthdayvalue;
    }

    public Date getbirthdayMax() {
        return this.birthdayMax;
    }

    private Date birthdayMin;

    public void setbirthdayMin(Date birthdayvalue) {
        this.birthdayMin = birthdayvalue;
    }

    public Date getbirthdayMin() {
        return this.birthdayMin;
    }

    private String carID;

    public void setCarID(String carIDvalue) {
        this.carID = carIDvalue;
    }

    public String getCarID() {
        return this.carID;
    }

    private List<String> carIDList;

    public void setcarIDList(List<String> carIDvalue) {
        this.carIDList = carIDvalue;
    }

    public List<String> getcarIDList() {
        return this.carIDList;
    }
}