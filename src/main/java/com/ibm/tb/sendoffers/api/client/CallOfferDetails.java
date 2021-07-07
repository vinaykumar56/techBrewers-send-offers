package com.ibm.tb.sendoffers.api.client;

import com.ibm.tb.sendoffers.api.model.OfferDetails;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class CallOfferDetails {
    public List<OfferDetails> getOfferDetails(){
        ParameterizedTypeReference<List<OfferDetails>> type = new ParameterizedTypeReference<List<OfferDetails>>() {
        };
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<OfferDetails>> responseEntity = restTemplate.exchange(
                "http://localhost:8081/techbrewers/transationcategory/get",
                        HttpMethod.GET,null,type );

        return  responseEntity.getBody();
    }
}
