package com.bns.stock.StockExchangeApi;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Basic;
import javax.persistence.Column;
import java.io.Serializable;

@Data
public class LookupData implements Serializable{

    @JsonProperty("id")
    private long StockInputId;

    @JsonProperty("quarter")
    private int Quarter;

    @JsonProperty("stock_type")
    private String StockType;

    @JsonProperty("stock_date")
    private String StockDate;

    @JsonProperty("stock_open")
    private double StockOpen;

    @JsonProperty("stock_high")
    private double StockHigh;

    @JsonProperty("stock_low")
    private double StockLow;

    @JsonProperty("stock_close")
    private double StockClose;

    @JsonProperty("volume")
    private int Volume;

    @JsonProperty("percent_change_price")
    private Double PercentChangePrice;

    @JsonProperty("percent_change_vol_over_last_week")
    private Double PercentChangeVolOverLastWeek;

    @JsonProperty("previous_weeks_vol")
    private int PreviousWeeksVol;

    @JsonProperty("next_weeks_open")
    private Double NextWeeksOpen;

    @JsonProperty("next_weeks_close")
    private Double NextWeeksClose;

    @JsonProperty("percent_change_next_weeks_price")
    private Double PercentChangeNextWeeksPrice;

    @JsonProperty("days_to_next_dividend")
    private int DaysToNextDividend;

    @JsonProperty("percent_return_next_dividend")
    private Double PercentReturnNextDividend;
}
