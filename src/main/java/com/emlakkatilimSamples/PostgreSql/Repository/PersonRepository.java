package com.emlakkatilimSamples.PostgreSql.Repository;

import com.emlakkatilimSamples.PostgreSql.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
