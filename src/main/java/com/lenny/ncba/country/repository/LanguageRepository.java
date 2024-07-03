package com.lenny.ncba.country.repository;

import com.lenny.ncba.country.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Long> {
}
