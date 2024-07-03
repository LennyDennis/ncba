package com.lenny.ncba.country.service;

import com.lenny.ncba.country.client.CountryClient;
import com.lenny.ncba.country.dto.CountryDto;
import com.lenny.ncba.country.entity.CountryInfo;
import com.lenny.ncba.country.entity.Language;
import com.lenny.ncba.country.mapper.CountryMapper;
import com.lenny.ncba.country.mapper.LanguageMapper;
import com.lenny.ncba.country.repository.CountryRepository;
import com.lenny.ncba.country.repository.LanguageRepository;
import com.lenny.ncba.shared.exceptions.InvalidInputException;
import com.lenny.ncba.shared.exceptions.ResourceNotFoundException;
import com.lenny.ncba.wsdl.TCountryInfo;
import com.lenny.ncba.wsdl.TLanguage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements ICountryService{

    @Autowired
    private CountryClient countryClient;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private LanguageRepository languageRepository;

    Logger logger = LoggerFactory.getLogger(CountryServiceImpl.class);

    @Override
    public CountryDto convertCountryNameToSentenceCase(CountryDto countryDto) {
        String countryName = countryDto.getName();
        String sentenceCaseCountryName = countryName.substring(0, 1).toUpperCase() + countryName.substring(1);
        logger.info("Converted country name to sentence case {}", sentenceCaseCountryName);
        String countryIsoCode = countryClient.getCountryISOCode(sentenceCaseCountryName);
        logger.info("Retrieved ISO code {}", countryIsoCode);
        TCountryInfo countryInfo = countryClient.getCountryInfo(countryIsoCode);
        CountryInfo savedCountry = saveCountry(countryInfo);
        List<Language> saveLanguages = saveLanguages(countryInfo, savedCountry);
        logger.info("Saved country information for {}", sentenceCaseCountryName);
        return CountryMapper.mapCountryInfoToCountryDto(savedCountry, saveLanguages);
    }

    private CountryInfo saveCountry(TCountryInfo country) {
        CountryInfo countryInfo = CountryMapper.mapTCountryInfoToCountryInfo(country);
        countryRepository.save(countryInfo);
        return countryInfo;
    }

    private List<Language> saveLanguages(TCountryInfo country, CountryInfo countryInfo) {
        List<TLanguage> languageList = country.getLanguages().getTLanguage();
        List<Language> languagesToSave = languageList.stream().map( tLanguage -> LanguageMapper.mapTLanguageToLanguage(tLanguage, countryInfo)).toList();
        languageRepository.saveAll(languagesToSave);
        return languagesToSave;
    }

    @Override
    public List<CountryDto> getAllCountries() {
        List<CountryInfo> countryInfoList = countryRepository.findAll();
        List<CountryDto> countryDtoList = countryInfoList.stream().map(CountryMapper::mapCountryInfoToCountryDto).collect(Collectors.toList());
        return countryDtoList;
    }

    @Override
    public CountryDto getCountryById(Long countryId) {
        CountryInfo countryInfo = getCountryByCountryId(countryId);
        return CountryMapper.mapCountryInfoToCountryDto(countryInfo);
    }

    private CountryInfo getCountryByCountryId(Long countryId) {
        if(countryId == null){
            throw new InvalidInputException("country", "country id");
        }
        Optional<CountryInfo> countryDto = countryRepository.findById(countryId);
        if(countryDto.isEmpty()) {
            throw new ResourceNotFoundException("Country", "country id", countryId.toString());
        }
        return countryDto.get();
    }

    @Override
    public CountryDto updateCountryInformation(Long countryId, CountryDto countryDto) {
        CountryInfo countryInfo = getCountryByCountryId(countryId);
        countryInfo = CountryMapper.mapCountryDtoToCountryEntity(countryDto, countryInfo);
        countryRepository.save(countryInfo);
        return CountryMapper.mapCountryInfoToCountryDto(countryInfo);
    }

    @Override
    public String deleteCountryInformation(Long countryId) {
        CountryInfo countryInfo = getCountryByCountryId(countryId);
        String countryName = countryInfo.getName();
        List<Language> languageList = countryInfo.getLanguages();
        languageRepository.deleteAll(languageList);
        countryRepository.delete(countryInfo);
        return "Deleted " + countryName + " information successfully";
    }


}
