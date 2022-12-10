package pl.kurs.furmanczykextensiontest2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kurs.furmanczykextensiontest2.models.Newborn;
import java.util.List;

public interface NewbornRepository extends JpaRepository<Newborn, Long> {

    List<Newborn> findAllBySex(Character sex);

}
