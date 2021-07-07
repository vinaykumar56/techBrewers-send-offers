package com.ibm.tb.sendoffers.api.service;

import com.ibm.tb.sendoffers.api.client.CallCategoryDetails;
import com.ibm.tb.sendoffers.api.client.CallOfferDetails;
import com.ibm.tb.sendoffers.api.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OffersService {
    @Autowired
    private CallCategoryDetails categoryDetails;
    @Autowired
    private CallOfferDetails offerDetails;

    public SendAllOfferDetails getAllOffers() {
        SendAllOfferDetails allOfferDetails = new SendAllOfferDetails();
        List<CustomerCategoryDetails> categoryDetailsList =	categoryDetails.getCategoryDetails();
        List<OfferDetails> offerDetailsList =	offerDetails.getOfferDetails();

        for (CustomerCategoryDetails categoryDetails :categoryDetailsList) {

            List<AggregateCategoryDetails> transactionCategoryDetailsList =	categoryDetails.getTransactionCategoryDetails();
            String tempC = null;
            double tempAmount = 0;
            for (AggregateCategoryDetails t: transactionCategoryDetailsList) {

                if (t.getTotalAmountSpent() > tempAmount) {
                    tempAmount = t.getTotalAmountSpent();
                    tempC = t.getCategory();
                }
            }

            for (OfferDetails offer: offerDetailsList) {
                if (tempC != null && tempC.equalsIgnoreCase(offer.getCategory())) {
                    SendOfferDetails sendOfferDetails = new SendOfferDetails();
                    sendOfferDetails.setCustomerId(categoryDetails.getCustomerId());
                    sendOfferDetails.getOfferDetails().add(offer);
                    allOfferDetails.getSendOfferDetails().add(sendOfferDetails);
                }
            }
        }

        return allOfferDetails;
    }
}
