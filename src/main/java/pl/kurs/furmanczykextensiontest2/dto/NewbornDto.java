package pl.kurs.furmanczykextensiontest2.dto;

import pl.kurs.furmanczykextensiontest2.models.Mother;
import java.time.LocalDate;

public class NewbornDto {

    private Long id;
    private Character sex;
    private String name;
    private LocalDate birthDate;
    private Integer weightInGrams;
    private Integer heightInCentimeters;
    private Mother mother;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getWeightInGrams() {
        return weightInGrams;
    }

    public void setWeightInGrams(Integer weightInGrams) {
        this.weightInGrams = weightInGrams;
    }

    public Integer getHeightInCentimeters() {
        return heightInCentimeters;
    }

    public void setHeightInCentimeters(Integer heightInCentimeters) {
        this.heightInCentimeters = heightInCentimeters;
    }

    public Mother getMother() {
        return mother;
    }

    public void setMother(Mother mother) {
        this.mother = mother;
    }
}