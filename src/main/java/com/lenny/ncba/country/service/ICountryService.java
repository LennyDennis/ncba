package com.lenny.ncba.country.service;

import com.lenny.ncba.country.dto.CountryDto;

import java.util.List;

public interface ICountryService {

    CountryDto convertCountryNameToSentenceCase(CountryDto countryDto);

    List<CountryDto> getAllCountries();

    CountryDto getCountryById(Long countryId);

    CountryDto updateCountryInformation(Long countryId, CountryDto countryDto);

    String deleteCountryInformation(Long countryId);
}
