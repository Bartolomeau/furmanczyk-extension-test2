package pl.kurs.furmanczykextensiontest2.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.kurs.furmanczykextensiontest2.dto.NewbornDto;
import pl.kurs.furmanczykextensiontest2.models.Newborn;
import pl.kurs.furmanczykextensiontest2.repository.NewbornRepository;

@Service
@Qualifier("tallest-girl")
public class TallestGirlOperation implements Operation<NewbornDto> {

    private final NewbornRepository newbornRepository;
    private final ModelMapper mapper;

    public TallestGirlOperation(NewbornRepository newbornRepository, ModelMapper mapper) {
        this.newbornRepository = newbornRepository;
        this.mapper = mapper;
    }

    @Override
    public String key() {
        return "tallest-girl";
    }

    @Override
    public NewbornDto getResponse() {
        Newborn tallestGirl = newbornRepository.findTopBySexOrderByHeightInCentimetersDesc('c');
        return mapper.map(tallestGirl, NewbornDto.class);
    }

}
