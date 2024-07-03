package com.lenny.ncba.country.mapper;

import com.lenny.ncba.country.dto.LanguageDto;
import com.lenny.ncba.country.entity.CountryInfo;
import com.lenny.ncba.country.entity.Language;
import com.lenny.ncba.wsdl.TLanguage;

public class LanguageMapper {

    public static Language mapTLanguageToLanguage(TLanguage tLanguage, CountryInfo countryInfo){
        Language language = new Language();
        language.setName(tLanguage.getSName());
        language.setLanguageIsoCode(tLanguage.getSISOCode());
        language.setCountry(countryInfo);
        return language;
    }

    public static LanguageDto mapLanguageToLanguageDto(Language language){
        LanguageDto languageDto = new LanguageDto();
        languageDto.setLanguageId(language.getId());
        languageDto.setLanguageName(language.getName());
        languageDto.setLanguageIsoCode(language.getLanguageIsoCode());
        return languageDto;
    }

    public static Language mapLanguageDtoToLanguageEntity(LanguageDto languageDto, CountryInfo countryInfo){
        Language language = new Language();
        language.setId(languageDto.getLanguageId());
        language.setName(languageDto.getLanguageName());
        language.setLanguageIsoCode(languageDto.getLanguageIsoCode());
        language.setCountry(countryInfo);
        return language;
    }

}
