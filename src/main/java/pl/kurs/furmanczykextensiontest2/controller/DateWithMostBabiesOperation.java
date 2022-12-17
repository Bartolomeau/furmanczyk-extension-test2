package pl.kurs.furmanczykextensiontest2.controller;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.kurs.furmanczykextensiontest2.repository.NewbornRepository;
import java.time.LocalDate;
import java.util.List;

@Service
@Qualifier("most-popular-birthdate")
public class DateWithMostBabiesOperation implements Operation<LocalDate> {

    private final NewbornRepository newbornRepository;

    public DateWithMostBabiesOperation(NewbornRepository newbornRepository) {
        this.newbornRepository = newbornRepository;
    }

    @Override
    public String key() {
        return "most-popular-birthdate";
    }

    @Override
    public LocalDate getResponse() {
        return newbornRepository.findMostPopularBirthDate()
                .stream()
                .findFirst()
                .orElse(null);
    }
}




