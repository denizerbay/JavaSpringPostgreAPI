package com.emlakkatilimSamples.PostgreSql.Service;

import com.emlakkatilimSamples.PostgreSql.Dto.PersonDto;
import com.emlakkatilimSamples.PostgreSql.Entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonService {

   PersonDto save(PersonDto personDto);

    void delete(Long id);

   List<PersonDto> getAll();

    Page<PersonDto> getAll(Pageable pageable);

}
