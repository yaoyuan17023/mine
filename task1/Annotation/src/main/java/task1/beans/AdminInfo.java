package task1.beans;

/**
 * created by 姚远 on 2017/8/15.
 */
public class AdminInfo {
    private String name;
    private Integer qq;
    private String type;
    private Long time;
    private String school;
    private Integer number;
    private String link;
    private String hope;
    private String referrer;
    private String from_where;
    private Integer id;
    private Long create_at;
    private Long update_at;

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

    public String getFrom_where() {
        return from_where;
    }

    public void setFrom_where(String from_where) {
        this.from_where = from_where;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Long create_at) {
        this.create_at = create_at;
    }

    public Long getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Long update_at) {
        this.update_at = update_at;
    }

    @Override
    public String toString() {
        return "AdminInfo{" +
                "name='" + name + '\'' +
                ", qq=" + qq +
                ", type='" + type + '\'' +
                ", time=" + time +
                ", school='" + school + '\'' +
                ", number=" + number +
                ", link='" + link + '\'' +
                ", hope='" + hope + '\'' +
                ", referrer='" + referrer + '\'' +
                ", from_where='" + from_where + '\'' +
                ", id=" + id +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                '}';
    }
}
