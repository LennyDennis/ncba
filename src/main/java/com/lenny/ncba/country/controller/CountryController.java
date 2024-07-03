package com.lenny.ncba.country.controller;

import com.lenny.ncba.country.dto.CountryDto;
import com.lenny.ncba.country.service.ICountryService;
import com.lenny.ncba.shared.controller.BaseController;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/country")
public class CountryController extends BaseController {

    @Autowired
    private ICountryService iCountryService;

    @PostMapping("/sentence-case")
    public ResponseEntity<CountryDto> convertCountryNameToSentenceCase(@Valid @RequestBody CountryDto countryDto){
        return entity(iCountryService.convertCountryNameToSentenceCase(countryDto));
    }

    @GetMapping()
    public ResponseEntity<List<CountryDto>> getAllCountries(){
        return entity(iCountryService.getAllCountries());
    }

    @GetMapping("{id}")
    public ResponseEntity<CountryDto> getCountryById(@PathVariable("id") Long countryId){
        return entity(iCountryService.getCountryById(countryId));
    }

    @PutMapping("{id}")
    public ResponseEntity<CountryDto> updateCountryInformation(@PathVariable("id") Long countryId, @RequestBody CountryDto countryDto){
        return entity(iCountryService.updateCountryInformation(countryId, countryDto));
    }


    @DeleteMapping("{id}")
    public ResponseEntity<CountryDto> deleteCountryInformation(@PathVariable("id") Long countryId){
        return success(iCountryService.deleteCountryInformation(countryId));
    }

}
