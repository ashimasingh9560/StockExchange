package com.bns.stock.StockExchangeApi;

import java.util.List;

public interface StockExchangeDao {

    List<LookupData> getReferenceDataByTickerId(String TickerId);
    void addStockExchangeData(StockExchangeVO stockExchangeVO, String correlationId);
    void submitStockExchangeBulkData(List<StockExchangeVO> stockExchangeVOList, String correlationId);

}
