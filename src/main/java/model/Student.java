package model;

/**
 * 类成员方法有变量的set和get方法和自定义的构造方法，toString方法
 */
public class Student {
    //实体类的属性和表的字段名称一一对应
    private String name;
    private Integer qq;
    private String type;
    private Long time;
    private String school;
    private Integer number;
    private String link;
    private String hope;
    private String referrer;
    private String fromWhere;
    private Integer id;
    private Long createAt;
    private Long updateAt;

    /**
     * 重新定义构造方法
     */
    public void Student(String name,Integer qq,String type,Long time,String school,Integer number,String link,String hope,
                        String referrer,String fromWhere,Integer id,Long createAt,Long updateAt){
        this.name=name;
        this.qq=qq;
        this.type=type;
        this.time=time;
        this.school=school;
        this.number=number;
        this.link=link;
        this.hope=hope;
        this.referrer=referrer;
        this.fromWhere=fromWhere;
        this.id=id;
        this.createAt=createAt;
        this.updateAt=updateAt;
    }
    //类成员变量的Set与get方法

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQq() {
        return qq;
    }

    public void setQq(Integer qq) {
        this.qq = qq;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getHope() {
        return hope;
    }

    public void setHope(String hope) {
        this.hope = hope;
    }

    public String getReferrer() {
        return referrer;
    }

    public void setReferrer(String referrer) {
        this.referrer = referrer;
    }

    public String getFromWhere() {
        return fromWhere;
    }

    public void setFromWhere(String fromWhere) {
        this.fromWhere = fromWhere;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

    //重构toString方法
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", qq=" + qq +
                ", type='" + type + '\'' +
                ", time=" + time +
                ", school='" + school + '\'' +
                ", number=" + number +
                ", link='" + link + '\'' +
                ", hope='" + hope + '\'' +
                ", referrer='" + referrer + '\'' +
                ", fromWhere='" + fromWhere + '\'' +
                ", id=" + id +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}