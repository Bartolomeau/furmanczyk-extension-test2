package pl.kurs.furmanczykextensiontest2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.kurs.furmanczykextensiontest2.models.Mother;

@Repository
public interface MotherRepository extends JpaRepository<Mother, Long> {

    @Query("SELECT COUNT(c) FROM Mother m JOIN m.newborns c WHERE c.name = m.name")
    Long countChildrenWithMothersName();

}


