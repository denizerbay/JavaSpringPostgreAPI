package com.emlakkatilimSamples.PostgreSql.Service.Impl;

import com.emlakkatilimSamples.PostgreSql.Dto.PersonDto;
import com.emlakkatilimSamples.PostgreSql.Entity.Address;
import com.emlakkatilimSamples.PostgreSql.Entity.Person;
import com.emlakkatilimSamples.PostgreSql.Repository.AddressRepository;
import com.emlakkatilimSamples.PostgreSql.Repository.PersonRepository;
import com.emlakkatilimSamples.PostgreSql.Service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;

    @Override
    @Transactional // Transaction commit or rollback
    public PersonDto save(PersonDto personDto) {

        //Assert.isNull(personDto.getName(), "Name alanı zorunlu");

        Person person = new Person();
        person.setName(personDto.getName());
        person.setSurname(personDto.getSurname());
        final Person personDb = personRepository.save(person);

        List<Address> addresses = new ArrayList<>();
        personDto.getAddresses().forEach(item -> {
            Address address = new Address();
            address.setAddressContent(item);
            address.setAddressType(Address.AddressType.HOME);
            address.setIsActive(true);
            address.setPerson(personDb);
            addresses.add(address);
        });
        addressRepository.saveAll(addresses);
        personDto.setId(personDb.getId());
        return null;
    }

    @Override
    public void delete(Long id) {

    }
    @Override
    public List<PersonDto> getAll() {
        List<Person> personList =  personRepository.findAll();
        List<PersonDto> personDtoList = new ArrayList<>();

        personList.forEach(x -> {
            PersonDto personDto = new PersonDto();
            personDto.setId(x.getId());
            personDto.setName(x.getName());
            personDto.setSurname(x.getSurname());
            personDto.setAddresses(x.getAddresses().stream().map(Address::getAddressContent)
                    .collect(Collectors.toList()));
            personDtoList.add(personDto);
        });

        return personDtoList;
    }

    @Override
    public Page<PersonDto> getAll(Pageable pageable) {
        return null;
    }
}
