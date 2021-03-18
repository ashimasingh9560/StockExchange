package com.bns.stock.StockExchangeApi;
import com.bns.propeller.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StockExchangeService {
    @Autowired
    private StockExchangeDao stockExchangeDao;


    public void submitStockExchangeBulkData(final List<StockExchangeVO> stockExchangeVOList, final String correlationId) {

        stockExchangeDao.submitStockExchangeBulkData(stockExchangeVOList, correlationId);
    }


    public List<LookupData> getReferenceDataByTickerId(String TickerId) {
        List<LookupData> lookupResponseDataList=  stockExchangeDao.getReferenceDataByTickerId(TickerId);
        return lookupResponseDataList;
    }

    public void addStockExchangeData(final StockExchangeVO, final String correlationId) {

        stockExchangeDao.addStockExchangeData(StockExchangeVO, correlationId);
    }






}
