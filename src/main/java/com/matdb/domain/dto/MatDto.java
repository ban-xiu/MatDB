package com.matdb.domain.dto;

import java.io.Serializable;
import java.util.Arrays;

public class MatDto implements Serializable {

    private String id;

    private String structure;

    private String formula;

    private String name;

    private String symmetry;

    private String metal;

    private String bandgappbe;

    private String bandgaphse;

    private String doi;

    private String url;

    private String publication;

    private String[] speciality;

    public MatDto(){}

    public MatDto(String id, String structure, String formula, String name, String symmetry, String metal, String bandgappbe, String bandgaphse, String doi, String url, String publication, String[] speciality) {
        this.id = id;
        this.structure = structure;
        this.formula = formula;
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

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
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

    @Override
    public String toString() {
        return "MatDto{" +
                "id='" + id + '\'' +
                ", structure='" + structure + '\'' +
                ", formula='" + formula + '\'' +
                ", name='" + name + '\'' +
                ", symmetry='" + symmetry + '\'' +
                ", metal='" + metal + '\'' +
                ", bandgappbe='" + bandgappbe + '\'' +
                ", bandgaphse='" + bandgaphse + '\'' +
                ", doi='" + doi + '\'' +
                ", url='" + url + '\'' +
                ", publication='" + publication + '\'' +
                ", speciality=" + Arrays.toString(speciality) +
                '}';
    }
}
