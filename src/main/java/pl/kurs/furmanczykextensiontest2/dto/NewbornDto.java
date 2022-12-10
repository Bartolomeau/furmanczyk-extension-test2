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
    public Character getSex() {
        return sex;
    }
    public String getName() {
        return name;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public Integer getWeightInGrams() {
        return weightInGrams;
    }
    public Integer getHeightInCentimeters() {
        return heightInCentimeters;
    }
    public Mother getMother() {
        return mother;
    }
}
