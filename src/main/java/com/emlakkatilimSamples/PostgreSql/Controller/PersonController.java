package com.emlakkatilimSamples.PostgreSql.Controller;

import com.emlakkatilimSamples.PostgreSql.Dto.PersonDto;
import com.emlakkatilimSamples.PostgreSql.Service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping
    public ResponseEntity<PersonDto> Add(@RequestBody PersonDto personDto){
        return ResponseEntity.ok(personService.save(personDto));
    }

    @GetMapping
    public  ResponseEntity<List<PersonDto>> GetAll(){
        return ResponseEntity.ok(personService.getAll());
    }
}
