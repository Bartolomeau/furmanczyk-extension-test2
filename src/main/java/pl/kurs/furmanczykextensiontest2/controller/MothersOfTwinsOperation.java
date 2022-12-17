package pl.kurs.furmanczykextensiontest2.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.kurs.furmanczykextensiontest2.dto.MotherDto;
import pl.kurs.furmanczykextensiontest2.repository.MotherRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Qualifier("mothers-of-twins")
public class MothersOfTwinsOperation implements Operation<List<MotherDto>>{

    private final MotherRepository motherRepository;
    private final ModelMapper mapper;

    public MothersOfTwinsOperation(MotherRepository motherRepository, ModelMapper mapper) {
        this.motherRepository = motherRepository;
        this.mapper = mapper;
    }

    @Override
    public String key() {
        return "mothers-of-twins";
    }

    @Override
    public List<MotherDto> getResponse() {
        return motherRepository.findAll()
                .stream()
                .filter(x -> x.getNewborns().size() == 2)
                .map(x -> mapper.map(x, MotherDto.class))
                .collect(Collectors.toList());
    }
}
