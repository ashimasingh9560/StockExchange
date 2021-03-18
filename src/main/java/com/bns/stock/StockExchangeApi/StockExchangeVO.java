package com.bns.stock.StockExchangeApi;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Date;

//This is the Value Object class for xml mapping
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement
@XmlType(propOrder = {
        "StockInputId",
        "quarter",
        "stock_type",
        "stock_date",
        "stock_open",
        "stock_high",
        "stock_low",
        "stock_close",
        "volume",
        "percent_change_price",
        "percent_change_vol_over_last_week",
        "previous_weeks_vol",
        "next_weeks_open",
        "next_weeks_close",
        "percent_change_next_weeks_price",
        "days_to_next_dividend",
        "percent_return_next_dividend"
})
public class StockExchangeVO {

    private BigInteger StockInputId;

    private int Quarter;

    private String StockType;

    private String StockDate;

    private double StockOpen;

    private double StockHigh;

    private double StockLow;

    private double StockClose;

    private int Volume;

    private double PercentChangePrice;

    private double PercentChangeVolOverLastWeek;

    private int PreviousWeeksVol;

    private double NextWeeksOpen;

    private double NextWeeksClose;

    private double PercentChangeNextWeeksPrice;

    private int DaysToNextDividend;

    private double PercentReturnNextDividend;


    @XmlElement(name = "StockInputId")
    public void setStockInputId(BigInteger Input){
        StockInputId = Input;
    }

    public BigInteger getStockInputId(){
        return StockInputId;
    }

    @XmlElement(name="quarter")
    public void setQuarter(int quat){
        this.Quarter = quat;
    }

    public int getQuarter(){
        return Quarter;
    }

    @XmlElement(name="stock_type")
    public void setStockType(String sType){
        this.StockType = sType;
    }

    public String getStockType(){
        return StockType;
    }

    @XmlElement(name="stock_date")
    public void setStockDate(String sDate){
        this.StockDate = sDate;
    }

    public String getStockDate(){
        return StockDate;
    }

    @XmlElement(name="stock_open")
    public void setStockOpen(double so){
        this.StockOpen = so;
    }

    public double getStockOpen(){
        return StockOpen;
    }

    @XmlElement(name="stock_high")
    public void setStockHigh(double sh){
        this.StockHigh = sh;
    }

    public double getStockHigh(){
        return StockHigh;
    }

    @XmlElement(name="stock_low")
    public void setStockLow(double sl){
        this.StockLow = sl;
    }

    public double getStockLow(){
        return StockLow;
    }

    @XmlElement(name="stock_close")
    public void setStockClose(double sl){
        this.StockClose = sl;
    }

    public double getStockClose(){
        return StockClose;
    }

    @XmlElement(name="volume")
    public void setVolume(int vol){
        this.Volume = vol;
    }

    public int getVolume(){
        return Volume;
    }


    @XmlElement(name="percent_change_price")
    public void setPercentChangePrice(double pl){
        this.PercentChangePrice = pl;
    }

    public double getPercentChangePrice(){
        return PercentChangePrice;
    }

    @XmlElement(name="percent_change_vol_over_last_week")
    public void setPercentChangeVolOverLastWeek(double pl){
        this.PercentChangeVolOverLastWeek = pl;
    }

    public double getPercentChangeVolOverLastWeek(){
        return PercentChangeVolOverLastWeek;
    }


    @XmlElement(name="previous_weeks_vol")
    public void setPreviousWeeksVol(int vol){
        this.PreviousWeeksVol = vol;
    }

    public int getPreviousWeeksVol(){
        return PreviousWeeksVol;
    }

    @XmlElement(name="next_weeks_open")
    public void setNextWeeksOpen(double pl){
        this.NextWeeksOpen = pl;
    }

    public double getNextWeeksOpen(){
        return NextWeeksOpen;
    }

    @XmlElement(name="next_weeks_close")
    public void setNextWeeksClose(double pl){
        this.NextWeeksClose = pl;
    }

    public double getNextWeeksClose(){
        return NextWeeksClose;
    }

    @XmlElement(name="percent_change_next_weeks_price")
    public void setPercentChangeNextWeeksPrice(double pl){
        this.PercentChangeNextWeeksPrice = pl;
    }

    public double getPercentChangeNextWeeksPrice(){
        return PercentChangeNextWeeksPrice;
    }


    @XmlElement(name="days_to_next_dividend")
    public void setDaysToNextDividend(int div){
        this.DaysToNextDividend = div;
    }

    public int getDaysToNextDividend(){
        return DaysToNextDividend;
    }


    @XmlElement(name="percent_return_next_dividend")
    public void setPercentReturnNextDividend(double pl){
        this.PercentReturnNextDividend = pl;
    }

    public double getPercentReturnNextDividend(){
        return PercentReturnNextDividend;
    }
    //rest XML Element could be created below

}


