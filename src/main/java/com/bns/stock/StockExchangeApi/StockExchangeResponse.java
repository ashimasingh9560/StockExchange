package com.bns.stock.StockExchangeApi;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

//@ApiModel(description = "Contains the reponse to Lookup inquiry")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class StockExchangeResponse<T> { //This class will hold the response and show the result output

    //    @JsonProperty("data")
//    List<T> data;
    @JsonProperty("header")
    @ApiModelProperty(notes = "Response header", required = true)
    private MessageHeader header;

    @JsonProperty("result")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @ApiModelProperty(notes = "Response result(s)", required = true)
    private ResultDetails<T> resultDetails;
}


