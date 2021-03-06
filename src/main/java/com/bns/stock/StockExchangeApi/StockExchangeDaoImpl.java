package com.bns.stock.StockExchangeApi;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

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



@Slf4j
@Component
public class StockExchangeDaoImpl implements StockExchangeDao {

    @Autowired
    private StockExchangeRepository stockExchangeRepository;

    @Override
    public List<LookupData> getReferenceDataByTickerId(final String TickerId) {
        List<StockExchangeEntity> referenceLookupEntities = stockExchangeRepository.findByStockType(TickerId);
        log.info("Calling getRefernceDataByTickerId",TickerId);
        if(referenceLookupEntities == null) {
            return null;
        }
        List<LookupData> lookupResponseDataList = new ArrayList<LookupData>(referenceLookupEntities.size());
        referenceLookupEntities.stream().forEach(s -> {lookupResponseDataList.add(copyProperties(s));}); //define copy properties
        return lookupResponseDataList;
    }

    @Override
    public void submitStockExchangeBulkData(final List<StockExchangeVO> stockExchangeVOList, final String correlationId) {
        log.info("calling submitStockExchangeBulkData",correlationId);
        try{
        EntityManager entityManager = new entityManagerFactory.createEntityManager();

        List<StockExchangeEntity> stockExchangeEntityList=convertToEntity(stockExchangeVOList);
        entityManager.getTransaction().begin();
        stockExchangeEntityList.stream().forEach(s->{
            entityManager.persists(s);
        });
        entityManager.getTransaction().commit();
        }Catach(IOException e){
            throw new RuntimeException(e);
        }
        //List<StockExchangeEntity> stockExchangeEntityList=convertToEntity(stockExchangeVOList);
        //stockExchangeRepository.saveAll(stockExchangeEntityList);
    }

    @Override
    public void addStockExchangeData(final StockExchangeVO stockExchangeVO, final String correlationId) {
        EntityManager entityManager = new entityManagerFactory.createEntityManager();
        StockExchangeEntity stockentity = new StockExchangeEntity();
        BeanUtils.copyProperties(stockentity,stockExchangeVO);
        
        try{
        entityManager.getTransaction().begin();
        entityManager.persists(stockentity);
        entityManager.getTransaction().commit();
        }catch(IOException e){
            throw new RuntimeException(e);
        }
        //StockExchangeEntity stockentity = new StockExchangeEntity();
        //BeanUtils.copyProperties(stockentity,stockExchangeVO);
        //stockExchangeRepository.save(stockentity);
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
