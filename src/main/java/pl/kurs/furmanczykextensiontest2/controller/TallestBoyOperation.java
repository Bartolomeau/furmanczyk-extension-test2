package pl.kurs.furmanczykextensiontest2.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.kurs.furmanczykextensiontest2.dto.NewbornDto;
import pl.kurs.furmanczykextensiontest2.models.Newborn;
import pl.kurs.furmanczykextensiontest2.repository.NewbornRepository;

@Service
@Qualifier("tallest-boy")
public class TallestBoyOperation implements Operation<NewbornDto> {

    private final NewbornRepository newbornRepository;
    private final ModelMapper mapper;

    public TallestBoyOperation(NewbornRepository newbornRepository, ModelMapper mapper) {
        this.newbornRepository = newbornRepository;
        this.mapper = mapper;
    }

    @Override
    public String key() {
        return "tallest-boy";
    }

    @Override
    public NewbornDto getResponse() {
        Newborn tallestBoy = newbornRepository.findTopBySexOrderByHeightInCentimetersDesc('s');
        return mapper.map(tallestBoy, NewbornDto.class);
    }



}
