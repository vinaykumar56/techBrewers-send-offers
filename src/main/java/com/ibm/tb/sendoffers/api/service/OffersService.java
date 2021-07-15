package com.ibm.tb.sendoffers.api.service;

import com.ibm.tb.sendoffers.api.client.CallCategoryDetails;
import com.ibm.tb.sendoffers.api.client.CallOfferDetails;
import com.ibm.tb.sendoffers.api.client.CallTwilio;
import com.ibm.tb.sendoffers.api.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class OffersService {
    @Autowired
    private CallCategoryDetails categoryDetails;
    @Autowired
    private CallOfferDetails offerDetails;
    @Autowired
    private CallTwilio twilio;

    @Value("${phone.to.1001}")
    private String to1001;
    @Value("${phone.to.1002}")
    private String to1002;
    @Value("${phone.from}")
    private String from;

    public SendAllOfferDetails getAllOffers() {
        SendAllOfferDetails allOfferDetails = new SendAllOfferDetails();
        List<CustomerCategoryDetails> categoryDetailsList =	categoryDetails.getCategoryDetails();
        List<OfferDetails> offerDetailsList =	offerDetails.getOfferDetails();
        List<SendOfferDetails> SendOfferDetailsList = new ArrayList<SendOfferDetails>();

        System.out.println(categoryDetailsList);
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
                    List<OfferDetails> offerDetails = new ArrayList<>();
                    offerDetails.add(offer);
                    sendOfferDetails.setOfferDetails(offerDetails);
                    SendOfferDetailsList.add(sendOfferDetails);
                }
            }
        }

        allOfferDetails.setSendOfferDetails(SendOfferDetailsList);
        System.out.println(allOfferDetails);

        for (SendOfferDetails sendOfferDetails : SendOfferDetailsList) {
            if (sendOfferDetails.getCustomerId() == 1001) {
                SendSMS sms = new SendSMS();
                sms.setFrom(from);
                sms.setTo(to1001);
                sms.setBody(sendOfferDetails.getOfferDetails().get(0).getDescription());
                twilio.postCustomerOfferMessage(sms);
            } else if (sendOfferDetails.getCustomerId() == 1002) {
                SendSMS sms = new SendSMS();
                sms.setFrom(from);
                sms.setTo(to1002);
                sms.setBody(sendOfferDetails.getOfferDetails().get(0).getDescription());
                twilio.postCustomerOfferMessage(sms);
            }

        }
        return allOfferDetails;
    }
}
