package com.ibm.tb.sendoffers.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OfferDetails {
    private int offerId;
    private String category;
    private String description;
}
