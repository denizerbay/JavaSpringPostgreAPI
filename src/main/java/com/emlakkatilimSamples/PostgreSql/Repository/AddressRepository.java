package com.emlakkatilimSamples.PostgreSql.Repository;

import com.emlakkatilimSamples.PostgreSql.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
