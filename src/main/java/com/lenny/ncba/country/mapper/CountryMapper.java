package com.lenny.ncba.country.mapper;

import com.lenny.ncba.country.dto.CountryDto;
import com.lenny.ncba.country.dto.LanguageDto;
import com.lenny.ncba.country.entity.CountryInfo;
import com.lenny.ncba.country.entity.Language;
import com.lenny.ncba.wsdl.TCountryInfo;

import java.util.List;
import java.util.stream.Collectors;

public class CountryMapper {

    public static CountryInfo mapTCountryInfoToCountryInfo(TCountryInfo tCountryInfo){
        CountryInfo countryInfo = new CountryInfo();
        countryInfo.setCountryIsoCode(tCountryInfo.getSISOCode());
        countryInfo.setName(tCountryInfo.getSName());
        countryInfo.setCapitalCity(tCountryInfo.getSCapitalCity());
        countryInfo.setPhoneCode(tCountryInfo.getSPhoneCode());
        countryInfo.setContinentCode(tCountryInfo.getSContinentCode());
        countryInfo.setCurrencyCode(tCountryInfo.getSCurrencyISOCode());
        countryInfo.setFlag(tCountryInfo.getSCountryFlag());
        return countryInfo;
    }

    public static CountryDto mapCountryInfoToCountryDto(CountryInfo countryInfo){
        return mapCountryInfoToCountryDtoImpl(countryInfo, null);
    }

    public static CountryDto mapCountryInfoToCountryDto(CountryInfo countryInfo, List<Language> languages){
        return mapCountryInfoToCountryDtoImpl(countryInfo, languages);
    }

    private static CountryDto mapCountryInfoToCountryDtoImpl(CountryInfo countryInfo, List<Language> languages){
        if(languages == null){
            languages = countryInfo.getLanguages();
        }
        CountryDto countryDto = new CountryDto();
        countryDto.setCountryId(countryInfo.getId());
        countryDto.setName(countryInfo.getName());
        countryDto.setCountryIsoCode(countryInfo.getCountryIsoCode());
        countryDto.setCapitalCity(countryInfo.getCapitalCity());
        countryDto.setPhoneCode(countryInfo.getPhoneCode());
        countryDto.setContinentCode(countryInfo.getContinentCode());
        countryDto.setCurrencyCode(countryInfo.getCurrencyCode());
        countryDto.setFlag(countryInfo.getFlag());
        countryDto.setLanguages(toLanguageDTOs(languages));
        return countryDto;
    }

    private static List<LanguageDto> toLanguageDTOs(List<Language> languages) {
        return languages.stream()
                .map(LanguageMapper::mapLanguageToLanguageDto)
                .collect(Collectors.toList());
    }

    public static CountryInfo mapCountryDtoToCountryEntity(CountryDto countryDto, CountryInfo countryInfo) {
        countryInfo.setCountryIsoCode(countryDto.getCountryIsoCode());
        countryInfo.setName(countryDto.getName());
        countryInfo.setCapitalCity(countryDto.getCapitalCity());
        countryInfo.setPhoneCode(countryDto.getPhoneCode());
        countryInfo.setContinentCode(countryDto.getContinentCode());
        countryInfo.setCurrencyCode(countryDto.getCurrencyCode());
        countryInfo.setFlag(countryDto.getFlag());
        countryInfo.setLanguages(toLanguageEntities(countryDto.getLanguages(), countryInfo));
        return countryInfo;
    }

    private static List<Language> toLanguageEntities(List<LanguageDto> languageDTOs, CountryInfo countryInfo) {
        return languageDTOs.stream().map(languageDto -> LanguageMapper.mapLanguageDtoToLanguageEntity(languageDto, countryInfo)).collect(Collectors.toList());
    }
}
