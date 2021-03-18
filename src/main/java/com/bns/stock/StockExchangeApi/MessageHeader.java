package com.bns.stock.StockExchangeApi;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Setter
@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MessageHeader {

    @JsonProperty("last_updated_time")
    private ZonedDateTime lastUpdatedTime;

    @JsonProperty("http_status_code")
    private HttpStatus httpStatusCode;

    private String uuid;

    @JsonProperty("origin_system")
    private String originSystem;

    @JsonProperty("detailed_message")
    private DetailedMessage detailedMessage;
}


