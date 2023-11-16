package matdb.dto;

import java.util.Arrays;

public class DBInfoDto {
    private String id;

    private String title;

    private String introduction;

    private String type;

    private byte[] img;

    public DBInfoDto(){}

    public DBInfoDto(String id, String title, String introduction, String type, byte[] img) {
        this.id = id;
        this.title = title;
        this.introduction = introduction;
        this.type = type;
        this.img = img;
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

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "DBInfoDto{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", introduction='" + introduction + '\'' +
                ", type='" + type + '\'' +
                ", img=" + Arrays.toString(img) +
                '}';
    }
}
