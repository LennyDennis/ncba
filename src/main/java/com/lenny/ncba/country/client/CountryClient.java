package com.lenny.ncba.country.client;

import com.lenny.ncba.wsdl.*;
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

    public String getCountryISOCode(String countryName) {
        try {
            CountryISOCode request = new CountryISOCode();
            request.setSCountryName(countryName);

            SoapActionCallback soapActionCallback = new SoapActionCallback(baseUrl + "CountryISOCode");

            CountryISOCodeResponse countryISOCodeResponse = (CountryISOCodeResponse) getWebServiceTemplate()
                    .marshalSendAndReceive(serviceUri, request, soapActionCallback);

            return countryISOCodeResponse.getCountryISOCodeResult();
        } catch (Exception e) {
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

            return fullCountryInfoResponse.getFullCountryInfoResult();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
