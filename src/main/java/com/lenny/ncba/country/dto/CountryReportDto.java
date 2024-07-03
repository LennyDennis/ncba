package com.lenny.ncba.country.dto;

import java.util.List;

public class CountryReportDto {

    private final PageInfo pageInfo;

    private final List<CountryDto> countries;

    public CountryReportDto(PageInfo pageInfo, List<CountryDto> countries) {
        this.pageInfo = pageInfo;
        this.countries = countries;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public List<CountryDto> getCountries() {
        return countries;
    }

    public static class PageInfo {
        private final int currentPage, totalPages;

        public PageInfo(int currentPage, int totalPages) {
            this.currentPage = currentPage;
            this.totalPages = totalPages;
        }

        public int getTotalPages() {
            return totalPages;
        }

        public int getCurrentPage() {
            return currentPage;
        }
    }

}
