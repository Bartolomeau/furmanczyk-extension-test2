package pl.kurs.furmanczykextensiontest2.dto;

import pl.kurs.furmanczykextensiontest2.models.Newborn;
import java.util.HashSet;
import java.util.Set;

public class MotherDto {

    private Long id;
    private String name;
    private Integer age;
    private Set<Newborn> newborns = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Set<Newborn> getNewborns() {
        return newborns;
    }

    public void setNewborns(Set<Newborn> newborns) {
        this.newborns = newborns;
    }
}