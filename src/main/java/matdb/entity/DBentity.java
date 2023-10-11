package matdb.entity;

import com.google.gson.Gson;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Arrays;

@Document(collection = "templatedata")
public class DBentity {
    @Id
    private String id;
    @Field("title")
    private String title;
    @Field("introduction")
    private String introduction;
    @Field("type")
    private String type;
    @Field("username")
    private String username;
    @Field("speciality")
    private String[] speciality;

    @Field("specialityType")
    private String[] specialityType;
    public DBentity(){};

    public DBentity(String id, String title, String introduction, String type, String username, String[] speciality, String[] specialityType) {
        this.id = id;
        this.title = title;
        this.introduction = introduction;
        this.type = type;
        this.username = username;
        this.speciality = speciality;
        this.specialityType = specialityType;
    }

    @Override
    public String toString() {
        return "DBentity{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", introduction='" + introduction + '\'' +
                ", type='" + type + '\'' +
                ", username='" + username + '\'' +
                ", speciality=" + Arrays.toString(speciality) +
                ", specialityType=" + Arrays.toString(specialityType) +
                '}';
    }

    public String toJson(){
        Gson gson = new Gson();
        return gson.toJson(this);
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

}
