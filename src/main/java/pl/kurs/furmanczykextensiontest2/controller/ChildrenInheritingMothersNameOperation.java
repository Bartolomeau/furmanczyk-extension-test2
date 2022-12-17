package pl.kurs.furmanczykextensiontest2.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.kurs.furmanczykextensiontest2.repository.MotherRepository;

@Service
@Qualifier("children-inheriting-mothers-name")
public class ChildrenInheritingMothersNameOperation implements Operation<Long>{

    private final MotherRepository motherRepository;

    public ChildrenInheritingMothersNameOperation(MotherRepository motherRepository) {
        this.motherRepository = motherRepository;
    }

    @Override
    public String key() {
        return "children_inheriting_mothers_name";
    }

    @Override
    public Long getResponse() {
        return motherRepository.countChildrenWithMothersName();
    }
}
