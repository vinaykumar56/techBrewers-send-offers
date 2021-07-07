package com.ibm.tb.sendoffers.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import java.util.List;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SendAllOfferDetails {
	@Id
	private String _id;
	private List<SendOfferDetails> sendOfferDetails;
	public SendAllOfferDetails() {
	}
}
