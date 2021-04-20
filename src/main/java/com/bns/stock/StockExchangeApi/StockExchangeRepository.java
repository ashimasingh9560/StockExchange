package com.bns.stock.StockExchangeApi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Repository
public interface StockExchangeRepository extends JpaRepository<StockExchangeEntity, String> { {

    @Query(value="select * from stock_exchange stk where stk.stock_type like %?1", nativeQuery=true);
    List<StockExchangeEntity> findByStockType(String StockType);
    //List<StockExchangeEntity> findByStockType(String StockType);
}

