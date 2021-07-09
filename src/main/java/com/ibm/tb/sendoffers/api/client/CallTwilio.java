package com.ibm.tb.sendoffers.api.client;

import com.ibm.tb.sendoffers.api.model.SendSMS;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CallTwilio {
    @Autowired
    private RestTemplate restTemplate;

    private final String accountSid = "AC302ea8c90119323d6c35258987f2d000";
    private final String token = "a5d50bb1020d748198932dffd11a21fc";

    public void postCustomerOfferMessage(SendSMS sms){

        Twilio.init(this.accountSid,this.token);
        Message message = Message.creator(new PhoneNumber(sms.getTo()), new PhoneNumber(sms.getFrom()), sms.getBody()).create();
        System.out.println("---------------------------------------- "+message.getStatus());
    }
}
