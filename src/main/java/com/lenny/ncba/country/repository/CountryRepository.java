package com.lenny.ncba.country.repository;

import com.lenny.ncba.country.entity.CountryInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<CountryInfo, Long> {

}
