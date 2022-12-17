package pl.kurs.furmanczykextensiontest2.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.kurs.furmanczykextensiontest2.dto.MotherDto;
import pl.kurs.furmanczykextensiontest2.repository.MotherRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Qualifier("young-mothers-heavy-baby")
public class MothersWithHeavyBabiesAndYoungAgeOperation implements Operation<List<MotherDto>> {

    private final MotherRepository motherRepository;
    private final ModelMapper mapper;

    public MothersWithHeavyBabiesAndYoungAgeOperation(MotherRepository motherRepository, ModelMapper mapper) {
        this.motherRepository = motherRepository;
        this.mapper = mapper;
    }

    @Override
    public String key() {
        return "young-mothers-heavy-baby";
    }

    @Override
    public List<MotherDto> getResponse() {
        return motherRepository.findAll()
                .stream()
                .filter(x -> x.getAge() < 25)
                .filter(x -> x.getNewborns().stream().anyMatch(y -> y.getWeightInGrams() > 4000))
                .map(x -> mapper.map(x, MotherDto.class))
                .collect(Collectors.toList());
    }

}
