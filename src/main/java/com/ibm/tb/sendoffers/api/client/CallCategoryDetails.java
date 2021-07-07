package com.ibm.tb.sendoffers.api.client;

import com.ibm.tb.sendoffers.api.model.CustomerCategoryDetails;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Component
public class CallCategoryDetails {
    public List<CustomerCategoryDetails> getCategoryDetails(){
        ParameterizedTypeReference<List<CustomerCategoryDetails>> type = new ParameterizedTypeReference<List<CustomerCategoryDetails>>() {
        };
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<CustomerCategoryDetails>> responseEntity = restTemplate.exchange(
                "http://localhost:8081/techbrewers/transationcategory/get",
                        HttpMethod.GET,null,type );

        return  responseEntity.getBody();
    }
}
