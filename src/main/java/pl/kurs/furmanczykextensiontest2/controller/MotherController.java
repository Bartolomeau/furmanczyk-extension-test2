package pl.kurs.furmanczykextensiontest2.controller;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kurs.furmanczykextensiontest2.repository.MotherRepository;

@RestController
@RequestMapping("/mother")
public class MotherController {

    private MotherRepository repository;
    private ModelMapper mapper;

    public MotherController(MotherRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
}
