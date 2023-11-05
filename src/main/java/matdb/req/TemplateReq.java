package matdb.req;

import java.util.Arrays;

public class TemplateReq {
    private String title;
    private String introduction;
    private String type;
    private String username;
    private String[] speciality;
    private String[] specialityType;

    public TemplateReq(){}

    public TemplateReq(String title, String introduction, String type, String username, String[] speciality, String[] specialityType) {
        this.title = title;
        this.introduction = introduction;
        this.type = type;
        this.username = username;
        this.speciality = speciality;
        this.specialityType = specialityType;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String[] getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String[] speciality) {
        this.speciality = speciality;
    }

    public String[] getSpecialityType() {
        return specialityType;
    }

    public void setSpecialityType(String[] specialityType) {
        this.specialityType = specialityType;
    }

    @Override
    public String toString() {
        return "TemplateReq{" +
                "title='" + title + '\'' +
                ", introduction='" + introduction + '\'' +
                ", type='" + type + '\'' +
                ", username='" + username + '\'' +
                ", speciality=" + Arrays.toString(speciality) +
                ", specialityType=" + Arrays.toString(specialityType) +
                '}';
    }
}
