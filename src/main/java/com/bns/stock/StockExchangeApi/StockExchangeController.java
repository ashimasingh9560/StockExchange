package com.bns.stock.StockExchangeApi;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
public class StockExchangeController implements StockExchangeApi {

    @Autowired private StockExchangeService stockExchangeService;

    @Override
    public ResponseEntity<StockExchangeResponse> submitStockExchangeBulkData(HttpServletRequest request, StockExchangeData[] stockExchangeDataList,
                                                                                   Principal principal, BindingResult binding) {
        //Convert in the Value Object List
        List <StockExchangeData> stockExchangeDataList=Arrays.asList(stockExchangeDataList);
        List<StockExchangeVO> StockExchangeVOList = new ArrayList<StockExchangeVO>();
        stockExchangeDataList.stream().forEach(s -> {
            StockExchangeVO stockVO = new StockExchangeVO();
            BeanUtils.copyProperties(stockVO,s);
            StockExchangeVOList.add(stockVO);
        });
        //calling the service method
        stockExchangeService.saveStockExchangeBulkData(StockExchangeVOList, generateUniqueCorrelationId());
        return ResponseEntity.ok(body);
    }

    @Override
    public ResponseEntity<StockExchangeResponse> addStockExchangeData(HttpServletRequest request, StockExchangeData stockExchangeDataobj,
                                                                             Principal principal, BindingResult binding) {
        //Convert to the Value Object
        StockExchangeVO stockVO = new StockExchangeVO();
        BeanUtils.copyProperties(stockVO,stockExchangeDataobj);

        //calling the service method
        stockExchangeService.addStockExchangeData(stockVO, generateUniqueCorrelationId());
        return ResponseEntity.ok(body);
    }

    @Override
    public ResponseEntity<StockExchangeResponse> getReferenceDataByTickerId(String TickerId) {
        StockExchangeResponse<LookupData> body = new StockExchangeResponse<LookupData>();
        List <LookupData> lookupResponseData = stockExchangeService.getReferenceDataByTickerId(TickerId);
        body.getResultDetails().setVoList(lookupResponseData);
        return ResponseEntity.ok(body);
    }


}
