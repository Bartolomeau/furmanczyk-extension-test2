package pl.kurs.furmanczykextensiontest2.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "mother")
public class Mother {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "mother")
    private Set<Newborn> newborns = new HashSet<>();

    public Mother() {
    }

    public Mother(String name, Integer age, Set<Newborn> newborns) {
        this.name = name;
        this.age = age;
        this.newborns = newborns;
    }

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