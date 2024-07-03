package com.lenny.ncba.country.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "countries")
public class CountryInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Size(max = 50)
    @Column(name = "country_iso_code", nullable = false)
    private String countryIsoCode;

    @Basic(optional = false)
    @NotNull
    @Size(max = 250)
    @Column(name = "name", nullable = false)
    private String name;

    @Basic(optional = false)
    @NotNull
    @Size(max = 300)
    @Column(name = "capital_city", nullable = false)
    private String capitalCity;

    @Basic(optional = false)
    @NotNull
    @Size(max = 50)
    @Column(name = "phone_code", nullable = false)
    private String phoneCode;

    @Basic(optional = false)
    @NotNull
    @Size(max = 50)
    @Column(name = "continent_code", nullable = false)
    private String continentCode;

    @Basic(optional = false)
    @NotNull
    @Size(max = 50)
    @Column(name = "currency_code", nullable = false)
    private String currencyCode;

    @Basic(optional = false)
    @NotNull
    @Column(name = "flag", nullable = false)
    private String flag;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Language> languages = new ArrayList<>();

    public CountryInfo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull @Size(max = 50) String getCountryIsoCode() {
        return countryIsoCode;
    }

    public void setCountryIsoCode(@NotNull @Size(max = 50) String countryIsoCode) {
        this.countryIsoCode = countryIsoCode;
    }

    public @NotNull @Size(max = 250) String getName() {
        return name;
    }

    public void setName(@NotNull @Size(max = 250) String name) {
        this.name = name;
    }

    public @NotNull @Size(max = 300) String getCapitalCity() {
        return capitalCity;
    }

    public void setCapitalCity(@NotNull @Size(max = 300) String capitalCity) {
        this.capitalCity = capitalCity;
    }

    public @NotNull @Size(max = 50) String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(@NotNull @Size(max = 50) String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public @NotNull @Size(max = 50) String getContinentCode() {
        return continentCode;
    }

    public void setContinentCode(@NotNull @Size(max = 50) String continentCode) {
        this.continentCode = continentCode;
    }

    public @NotNull @Size(max = 50) String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(@NotNull @Size(max = 50) String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public @NotNull String getFlag() {
        return flag;
    }

    public void setFlag(@NotNull String flag) {
        this.flag = flag;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryInfo that = (CountryInfo) o;
        return Objects.equals(id, that.id) && Objects.equals(countryIsoCode, that.countryIsoCode) && Objects.equals(name, that.name) && Objects.equals(capitalCity, that.capitalCity) && Objects.equals(phoneCode, that.phoneCode) && Objects.equals(continentCode, that.continentCode) && Objects.equals(currencyCode, that.currencyCode) && Objects.equals(flag, that.flag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, countryIsoCode, name, capitalCity, phoneCode, continentCode, currencyCode, flag);
    }

    @Override
    public String toString() {
        return "CountryInfo{" +
                "id=" + id +
                ", countryIsoCode='" + countryIsoCode + '\'' +
                ", name='" + name + '\'' +
                ", capitalCity='" + capitalCity + '\'' +
                ", phoneCode='" + phoneCode + '\'' +
                ", continentCode='" + continentCode + '\'' +
                ", currencyCode='" + currencyCode + '\'' +
                ", flag='" + flag + '\'' +
                '}';
    }
}
