package com.ibm.tb.sendoffers.api.client;

import com.ibm.tb.sendoffers.api.model.CustomerCategoryDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Component
public class CallCategoryDetails {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${category.url.get}")
    private String getUrl;

    public List<CustomerCategoryDetails> getCategoryDetails(){
        ParameterizedTypeReference<List<CustomerCategoryDetails>> type = new ParameterizedTypeReference<List<CustomerCategoryDetails>>() {
        };
        ResponseEntity<List<CustomerCategoryDetails>> responseEntity = restTemplate.exchange(
                getUrl, HttpMethod.GET,null,type );

        return  responseEntity.getBody();
    }
}
