package com.bns.stock.StockExchangeApi;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
@Getter
@Setter
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StockExchangeData implements Serializable{
    private BigInteger StockInputId;

    private int Quarter;

    private String StockType;

    private String StockDate;

    private Double StockOpen;

    private Double StockHigh;

    private Double StockLow;

    private Double StockClose;


    private int Volume;


    private Double PercentChangePrice;


    private Double PercentChangeVolOverLastWeek;


    private int PreviousWeeksVol;


    private Double NextWeeksOpen;


    private Double NextWeeksClose;


    private Double PercentChangeNextWeeksPrice;


    private int DaysToNextDividend;


    private Double PercentReturnNextDividend;

}
