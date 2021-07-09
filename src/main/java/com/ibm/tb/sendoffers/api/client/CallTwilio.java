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

    @Value("${account}")
    private String accountSid;
    @Value("${token}")
    private String token;

    public void postCustomerOfferMessage(SendSMS sms){

        Twilio.init(this.accountSid,this.token);
        Message message = Message.creator(new PhoneNumber(sms.getTo()), new PhoneNumber(sms.getFrom()), sms.getBody()).create();
        System.out.println("---------------------------------------- "+message.getStatus());
    }
}
