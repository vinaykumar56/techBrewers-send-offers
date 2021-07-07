package com.ibm.tb.sendoffers.api.client;

import com.ibm.tb.sendoffers.api.model.OfferDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class CallOfferDetails {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${offers.url.get}")
    private String getUrl;

    public List<OfferDetails> getOfferDetails(){
        ParameterizedTypeReference<List<OfferDetails>> type = new ParameterizedTypeReference<List<OfferDetails>>() {
        };
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<OfferDetails>> responseEntity = restTemplate.exchange(
                getUrl, HttpMethod.GET,null,type );

        return  responseEntity.getBody();
    }
}
