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
    public String getName() {
        return name;
    }
    public Integer getAge() {
        return age;
    }
    public Set<Newborn> getNewborns() {
        return newborns;
    }
}
