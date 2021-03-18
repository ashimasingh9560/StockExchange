package com.bns.stock.StockExchangeApi;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Table(name = "stock_exchange", schema = "stk")
@SequenceGenerator(name="STOCK_EXCHANGE_SEQ", schema ="stk", initialValue=1, allocationSize=1)
@Data
public class StockExchangeEntity implements Serializable {

    @Id
    @Column(name = "StockInputId")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="STOCK_EXCHANGE_SEQ")
    private BigInteger StockInputId;


    @Column(name = "quarter", length = 1)
    private int Quarter;

    @Column(name = "stock_type", length = 1)
    private String StockType;

    @Column(name = "stock_date", length = 1)
    private String StockDate;

    @Column(name = "stock_open", length = 1)
    private Double StockOpen;

    @Column(name = "stock_high", length = 1)
    private Double StockHigh;

    @Column(name = "stock_low", length = 1)
    private Double StockLow;

    @Column(name = "stock_close", length = 1)
    private Double StockClose;

    @Column(name = "volume", length = 1)
    private int Volume;

    @Column(name = "percent_change_price", length = 1)
    private Double PercentChangePrice;

    @Column(name = "percent_change_vol_over_last_week", length = 1)
    private Double PercentChangeVolOverLastWeek;

    @Column(name = "previous_weeks_vol", length = 1)
    private int PreviousWeeksVol;

    @Column(name = "next_weeks_open", length = 1)
    private Double NextWeeksOpen;

    @Column(name = "next_weeks_close", length = 1)
    private Double NextWeeksClose;

    @Column(name = "percent_change_next_weeks_price", length = 1)
    private Double PercentChangeNextWeeksPrice;

    @Column(name = "days_to_next_dividend", length = 1)
    private int DaysToNextDividend;

    @Column(name = "percent_return_next_dividend", length = 1)
    private Double PercentReturnNextDividend;

    public void populateStockExchangeEntity(final StockExchangeVO stockVO) {
            setQuarter(stockVO.getQuarter());
            setStockType(stockVO.getStockType());
            setStockDate(stockVO.getStockDate());
            setStockOpen(stockVO.getStockOpen());
            setStockHigh(stockVO.getStockHigh());
            setStockLow(stockVO.getStockLow());
            setStockClose(stockVO.getStockClose());
            setVolume(stockVO.getVolume());
            setPercentChangePrice(stockVO.getPercentChangePrice());
            setPercentChangeVolOverLastWeek(stockVO.getPercentChangeVolOverLastWeek());
            setPreviousWeeksVol(stockVO.getPreviousWeeksVol());
            setNextWeeksOpen(stockVO.getNextWeeksOpen());
            setNextWeeksClose(stockVO.getNextWeeksClose());
            setPercentChangeNextWeeksPrice(stockVO.getPercentChangeNextWeeksPrice());
            setDaysToNextDividend(stockVO.getDaysToNextDividend());
            setPercentReturnNextDividend(stockVO.getPercentReturnNextDividend());
    }
}


