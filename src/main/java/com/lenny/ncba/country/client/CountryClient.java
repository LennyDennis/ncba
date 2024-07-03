package com.lenny.ncba.country.client;

import com.lenny.ncba.wsdl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Component
public class CountryClient extends WebServiceGatewaySupport {

    @Value("${country.info.service.uri}")
    private String serviceUri;

    @Value("${country.info.service.base.url}")
    private String baseUrl;

    Logger logger = LoggerFactory.getLogger(CountryClient.class);

    public String getCountryISOCode(String countryName) {
        try {
            CountryISOCode request = new CountryISOCode();
            request.setSCountryName(countryName);

            SoapActionCallback soapActionCallback = new SoapActionCallback(baseUrl + "CountryISOCode");

            CountryISOCodeResponse countryISOCodeResponse = (CountryISOCodeResponse) getWebServiceTemplate()
                    .marshalSendAndReceive(serviceUri, request, soapActionCallback);

            logger.info("Retrieved country iso code {} from name", countryISOCodeResponse.getCountryISOCodeResult());

            return countryISOCodeResponse.getCountryISOCodeResult();
        } catch (Exception e) {
            logger.error("Error getting country ISO code", e);
            throw new RuntimeException(e);
        }
    }

    public TCountryInfo getCountryInfo(String countryIsoCode) {
        try {
            FullCountryInfo request = new FullCountryInfo();
            request.setSCountryISOCode(countryIsoCode);

            SoapActionCallback soapActionCallback = new SoapActionCallback(baseUrl + "FullCountryInfo");

            FullCountryInfoResponse fullCountryInfoResponse = (FullCountryInfoResponse) getWebServiceTemplate()
                    .marshalSendAndReceive(serviceUri, request, soapActionCallback);

            logger.info("Retrieved country information {}", fullCountryInfoResponse.getFullCountryInfoResult().getSName());

            return fullCountryInfoResponse.getFullCountryInfoResult();
        } catch (Exception e) {
            logger.error("Error while getting country information", e);
            throw new RuntimeException(e);
        }
    }

}
