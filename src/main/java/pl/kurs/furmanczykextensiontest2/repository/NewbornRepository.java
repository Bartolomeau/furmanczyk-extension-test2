package pl.kurs.furmanczykextensiontest2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.kurs.furmanczykextensiontest2.models.Newborn;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface NewbornRepository extends JpaRepository<Newborn, Long> {

    Newborn findTopBySexOrderByHeightInCentimetersDesc(Character sex);
    @Query("SELECT c.birthDate FROM Newborn c GROUP BY c.birthDate ORDER BY COUNT(c) DESC")
    List<LocalDate> findMostPopularBirthDate();

}