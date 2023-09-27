package matdb.entity;

import com.google.gson.Gson;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Arrays;


@Document(collection = "mongodata")
public class Matentity {

    @Field("uid")
    private String uid;
    @Id
    private String id;
    @Field("structure")
    private String structure;
    @Field("name")
    private String name;
    @Field("symmetry")
    private String symmetry;
    @Field("metal")
    private String metal;
    @Field("bandgappbe")
    private String bandgappbe;
    @Field("bandgaphse")
    private String bandgaphse;
    @Field("doi")
    private String doi;
    @Field("url")
    private String url;
    @Field("publication")
    private String publication;
    @Field("speciality")
    private String[] speciality;

    public Matentity(){};

    public Matentity(String uid, String id, String structure, String name, String symmetry, String metal, String bandgappbe, String bandgaphse, String doi, String url, String publication, String[] speciality) {
        this.uid = uid;
        this.id = id;
        this.structure = structure;
        this.name = name;
        this.symmetry = symmetry;
        this.metal = metal;
        this.bandgappbe = bandgappbe;
        this.bandgaphse = bandgaphse;
        this.doi = doi;
        this.url = url;
        this.publication = publication;
        this.speciality = speciality;
    }

    public String toJson(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }



    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymmetry() {
        return symmetry;
    }

    public void setSymmetry(String symmetry) {
        this.symmetry = symmetry;
    }

    public String getMetal() {
        return metal;
    }

    public void setMetal(String metal) {
        this.metal = metal;
    }

    public String getBandgappbe() {
        return bandgappbe;
    }

    public void setBandgappbe(String bandgappbe) {
        this.bandgappbe = bandgappbe;
    }

    public String getBandgaphse() {
        return bandgaphse;
    }

    public void setBandgaphse(String bandgaphse) {
        this.bandgaphse = bandgaphse;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public String[] getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String[] speciality) {
        this.speciality = speciality;
    }
}