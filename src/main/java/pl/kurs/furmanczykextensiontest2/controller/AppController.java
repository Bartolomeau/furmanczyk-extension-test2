package pl.kurs.furmanczykextensiontest2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kurs.furmanczykextensiontest2.dto.MotherDto;
import pl.kurs.furmanczykextensiontest2.dto.NewbornDto;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/newborn")
public class AppController {

    private final Map<String, Operation<?>> operatorMap;

    @Autowired
    public AppController(
            @Qualifier("children-inheriting-mothers-name") Operation<Long> childrenWithInheritingName,
            @Qualifier("most-popular-birthdate") Operation<LocalDate> mostPopularBirthdate,
            @Qualifier("mothers-of-twins") Operation<List<MotherDto>> motherOfTwins,
            @Qualifier("young-mothers-heavy-baby") Operation<List<MotherDto>> youngMotherWithHeavyBabe,
            @Qualifier("tallest-boy") Operation<NewbornDto> tallestBoyOperation,
            @Qualifier("tallest-girl") Operation<NewbornDto> tallestGirlOperation
    ) {
        operatorMap = new HashMap<>();
        operatorMap.put("children-inheriting-mothers-name", childrenWithInheritingName);
        operatorMap.put("most-popular-birthdate", mostPopularBirthdate);
        operatorMap.put("mothers-of-twins", motherOfTwins);
        operatorMap.put("young-mothers-heavy-baby", youngMotherWithHeavyBabe);
        operatorMap.put("tallest-boy", tallestBoyOperation);
        operatorMap.put("tallest-girl", tallestGirlOperation);
    }

    @GetMapping("/operations")
    public List<String> getOperations() {
        return operatorMap.keySet().stream()
                .sorted()
                .collect(Collectors.toList());
    }

    @GetMapping("/{operation}")
    public ResponseEntity<?> getResponse(@PathVariable String operation) {
        Operation<?> operator = operatorMap.get(operation);
        if (operator == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(operator.getResponse());
    }

}