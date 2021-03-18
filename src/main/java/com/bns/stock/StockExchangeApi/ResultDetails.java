package com.bns.stock.StockExchangeApi;


import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ResultDetails<T> {
    @JsonProperty("total_count")
    private Long totalCount;

    @JsonProperty("stock_type")
    @ApiModelProperty(notes = "The search result category")
    private String type;

    @JsonProperty("details")
    @ApiModelProperty(notes = "The search details")
    private List<T> voList; //List of the Stock Exchange objects to be assigned



    public ResultDetails(String StockType, List<T> voList) {
        this.type = StockType;
        this.voList = voList;
    }

}

