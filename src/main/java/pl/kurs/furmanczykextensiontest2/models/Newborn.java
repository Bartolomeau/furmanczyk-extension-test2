package pl.kurs.furmanczykextensiontest2.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "newborn")
public class Newborn {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Character sex;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(name = "weight[g]", nullable = false)
    private Integer weightInGrams;

    @Column(name = "height[cm]", nullable = false)
    private Integer heightInCentimeters;
    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "mother_id")
    private Mother mother;

    public Newborn() {
    }

    public Newborn(Character sex, String name, LocalDate birthDate, Integer weightInGrams, Integer heightInCentimeters) {
        this.sex = sex;
        this.name = name;
        this.birthDate = birthDate;
        this.weightInGrams = weightInGrams;
        this.heightInCentimeters = heightInCentimeters;
    }

    public Long getId() {
        return id;
    }

    public Mother getMother() {
        return mother;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Newborn newborn = (Newborn) o;
        return Objects.equals(id, newborn.id) && Objects.equals(sex, newborn.sex) && Objects.equals(name, newborn.name) && Objects.equals(birthDate, newborn.birthDate) && Objects.equals(weightInGrams, newborn.weightInGrams) && Objects.equals(heightInCentimeters, newborn.heightInCentimeters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sex, name, birthDate, weightInGrams, heightInCentimeters);
    }
}
