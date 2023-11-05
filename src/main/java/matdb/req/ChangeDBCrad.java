package matdb.req;

public class ChangeDBCrad {
    private String id;
    private String title;
    private String introduction;
    public ChangeDBCrad(){}

    public ChangeDBCrad(String id, String title, String introduction) {
        this.id = id;
        this.title = title;
        this.introduction = introduction;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public String toString() {
        return "ChangeDBCrad{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", introduction='" + introduction + '\'' +
                '}';
    }
}
