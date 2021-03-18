package com.bns.stock.StockExchangeApi;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




@Component
public class StockExchangeDaoImpl implements StockExchangeDao {

    @Autowired
    private StockExchangeRepository stockExchangeRepository;

    @Override
    public List<LookupData> getReferenceDataByTickerId(final String TickerId) {
        List<StockExchangeEntity> referenceLookupEntities = stockExchangeRepository.findByStockType(TickerId);
        if(referenceLookupEntities == null) {
            return null;
        }
        List<LookupData> lookupResponseDataList = new ArrayList<LookupData>(referenceLookupEntities.size());
        referenceLookupEntities.stream().forEach(s -> {lookupResponseDataList.add(copyProperties(s));}); //define copy properties
        return lookupResponseDataList;
    }

    @Override
    public void submitStockExchangeBulkData(final List<StockExchangeVO> stockExchangeVOList, final String correlationId) {
        List<StockExchangeEntity> stockExchangeEntityList=convertToEntity(stockExchangeVOList);
        stockExchangeRepository.saveAll(stockExchangeEntityList);
    }

    @Override
    public void addStockExchangeData(final StockExchangeVO stockExchangeVO, final String correlationId) {
        StockExchangeEntity stockentity = new StockExchangeEntity();
        BeanUtils.copyProperties(stockentity,stockExchangeVO);
        stockExchangeRepository.save(stockentity);
    }


    public static List<StockExchangeEntity> convertToEntity(final List<StockExchangeVO> StockExchangeVOList){

        List<StockExchangeEntity> stockExchangeEntityList = new ArrayList<StockExchangeEntity>();
        StockExchangeVOList.stream().forEach(s -> {
            StockExchangeEntity stockentity = new StockExchangeEntity();
            BeanUtils.copyProperties(stockentity,s);
            stockExchangeEntityList.add(stockentity);
        });

        return stockExchangeEntityList;
    }


}
