package com.lenny.ncba.country.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
@Table(name = "languages")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Size(max = 250)
    @Column(name = "name", nullable = false)
    private String name;

    @Basic(optional = false)
    @NotNull
    @Size(max = 50)
    @Column(name = "language_iso_code", nullable = false)
    private String languageIsoCode;

    @JsonIgnore
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CountryInfo country;

    public Language() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull @Size(max = 250) String getName() {
        return name;
    }

    public void setName(@NotNull @Size(max = 250) String name) {
        this.name = name;
    }

    public @NotNull @Size(max = 50) String getLanguageIsoCode() {
        return languageIsoCode;
    }

    public void setLanguageIsoCode(@NotNull @Size(max = 50) String languageIsoCode) {
        this.languageIsoCode = languageIsoCode;
    }

    public CountryInfo getCountry() {
        return country;
    }

    public void setCountry(CountryInfo country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Language language = (Language) o;
        return Objects.equals(id, language.id) && Objects.equals(name, language.name) && Objects.equals(languageIsoCode, language.languageIsoCode) && Objects.equals(country, language.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, languageIsoCode, country);
    }

    @Override
    public String toString() {
        return "Language{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", languageIsoCode='" + languageIsoCode + '\'' +
                ", country=" + country +
                '}';
    }
}
