package com.lenny.ncba.country.service;

import com.lenny.ncba.country.dto.CountryDto;
import com.lenny.ncba.country.dto.CountryReportDto;

public interface ICountryService {

    CountryDto convertCountryNameToSentenceCase(CountryDto countryDto);

    CountryReportDto getAllCountries(int page, int size);

    CountryDto getCountryById(Long countryId);

    CountryDto updateCountryInformation(Long countryId, CountryDto countryDto);

    String deleteCountryInformation(Long countryId);
}
