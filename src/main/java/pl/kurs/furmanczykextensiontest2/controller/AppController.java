package pl.kurs.furmanczykextensiontest2.controller;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kurs.furmanczykextensiontest2.dto.MotherDto;
import pl.kurs.furmanczykextensiontest2.dto.NewbornDto;
import pl.kurs.furmanczykextensiontest2.models.Newborn;
import pl.kurs.furmanczykextensiontest2.repository.MotherRepository;
import pl.kurs.furmanczykextensiontest2.repository.NewbornRepository;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/newborn")
public class AppController {

    private NewbornRepository newbornRepository;
    private MotherRepository motherRepository;
    private ModelMapper mapper;

    public AppController(NewbornRepository newbornRepository, MotherRepository motherRepository, ModelMapper mapper) {
        this.newbornRepository = newbornRepository;
        this.motherRepository = motherRepository;
        this.mapper = mapper;
    }

    //1)zwroc najwyzszego chlopca
    @GetMapping(value = "thetallestboy")
    public NewbornDto getTheTallestBoy(){
         return newbornRepository.findAllBySex('s')
                 .stream()
                 .max(Comparator.comparingInt(Newborn::getHeightInCentimeters))
                 .map(x -> mapper.map(x, NewbornDto.class))
                 .orElseThrow(NoSuchElementException::new);
    }

    //2)zwroc najwyzsza dziewczynke
    @GetMapping(value = "thetallestgirl")
    public NewbornDto getTheTallestGirl(){
        return newbornRepository.findAllBySex('c')
                .stream()
                .max(Comparator.comparingInt(Newborn::getHeightInCentimeters))
                .map(x -> mapper.map(x, NewbornDto.class))
                .orElseThrow(NoSuchElementException::new);
    }


    //3)zwroc date w ktorym urodzilo sie najwiecej dzieci
    @GetMapping(value = "mostchildrenborn")
    public LocalDate getDateWhenMostChildrenBorn(){
          return newbornRepository.findAll()
                  .stream()
                  .collect(Collectors.groupingBy(Newborn::getBirthDate, Collectors.counting()))
                  .entrySet()
                  .stream()
                  .max(Comparator.comparingLong(x -> x.getValue()))
                  .map(Map.Entry::getKey)
                  .orElseThrow(IllegalStateException::new);
    }


    //4)zwroc matki ktore urodzily dzieci powyzej 4000g a same maja ponizej 25 lat
    @GetMapping(value = "childrenupper4kg")
    public List<MotherDto> getMothersWith4kgChild(){
        return motherRepository.findAll()
                .stream()
                .filter(x -> x.getAge() < 25)
                .filter(x -> x.getNewborns().stream().anyMatch(y -> y.getWeightInGrams() > 4000))
                .map(x -> mapper.map(x, MotherDto.class))
                .collect(Collectors.toList());
    }

    //5)ile dzieci odziedziczylo imie po matce?
    @GetMapping(value = "inheritedname")
    public long getChildrenWithInheritedNameFromMother(){
        long answer;
        return answer = newbornRepository.findAll()
                .stream()
                .filter(x -> x.getName().equals(x.getMother().getName()))
                .count();
    }


    //6)zwroc matki ktore urodzily bliznieta.
    @GetMapping(value = "twins")
    public List<MotherDto> getMothersWithTwins(){
        return motherRepository.findAll()
                .stream()
                .filter(x -> x.getNewborns().size() == 2)
                .map(x -> mapper.map(x, MotherDto.class))
                .collect(Collectors.toList());
    }

}
