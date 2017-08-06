package model;

public class Student {
    private String name;
    private Integer qq;
    private String type;
    private String time;
    private String school;
    private Integer number;
    private String link;
    private String hope;
    private String referrer;
    private String from;
    private Integer id;
    private Integer create_at;
    private Integer update_at;
    public Student(){
        super();
        //TODO Auto-generated constructor stub
    }
    public Student(String name,Integer qq,String type,String time,String school,Integer number,String link,String hope,
                   String referrer,String from,Integer id,Integer create_at,Integer update_at){
        super();
        this.name = name;
        this.qq = qq;
        this.type = type;
        this.time = time;
        this.school = school;
        this.number = number;
        this.link = link;
        this.hope = hope;
        this.referrer = referrer;
        this.from = from;
        this.id = id;
        this.create_at = create_at;
        this.update_at = update_at;
    }

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
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

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Integer create_at) {
        this.create_at = create_at;
    }

    public Integer getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Integer update_at) {
        this.update_at = update_at;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", qq=" + qq +
                ", type='" + type + '\'' +
                ", time='" + time + '\'' +
                ", school='" + school + '\'' +
                ", number=" + number +
                ", link='" + link + '\'' +
                ", hope='" + hope + '\'' +
                ", referrer='" + referrer + '\'' +
                ", from='" + from + '\'' +
                ", id=" + id +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                '}';
    }
}