package com.bns.stock.StockExchangeApi;

import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.security.Principal;
import java.util.ArrayList;

@Validated
@Api(value = "Lookup", description = "Stock Exchange Api")
public interface StockExchangeApi {

    //To save bulk Stock data, we need an array of the StockExchangeData class and pass to the api
    @ApiOperation(value = "Save StockExchangeBulkData", nickname = "saveStockExchangeBulkData", httpMethod = "post", notes = "", response = StockExchangeResponse.class, tags = {"results",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Response created successfully", response = StockExchangeResponse.class),
            @ApiResponse(code = 400, message = "Internal server error.", response = StockExchangeResponse.class),
            @ApiResponse(code = 401, message = "Internal server error.", response = StockExchangeResponse.class),
            @ApiResponse(code = 500, message = "Internal server error.", response = StockExchangeResponse.class)})
    @PostMapping (value = "/submitStockExchangeBulkData",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    default ResponseEntity<StockExchangeResponse> submitStockExchangeBulkData(HttpServletRequest request, @NotNull @RequestBody StockExchangeData[] bulkStockExchangeData,
                                                                                    Principal principal,
                                                                                    BindingResult bindingResult
    ) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //To get the stocks data as per the TickerId, we need to get the TickerId from the request
    @ApiOperation(value = "gets list of Stocks by reference or ticker id", nickname = "referenceDataByTickerId", httpMethod = "get", notes = "", response = StockExchangeResponse.class, tags = {"Lookup",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Response created successfully", response = StockExchangeResponse.class),
            @ApiResponse(code = 400, message = "Internal server error.", response = StockExchangeResponse.class),
            @ApiResponse(code = 401, message = "Internal server error.", response = StockExchangeResponse.class),
            @ApiResponse(code = 500, message = "Internal server error.", response = StockExchangeResponse.class)})
    @RequestMapping(value = "/getStockDataByTicker/{TickerId}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    default ResponseEntity<StockExchangeResponse> getReferenceDataByTickerId(@Valid @PathVariable(value = "TickerId", required = true) String TickerId) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //To add a Stock data record, we need a StockExchange object to be saved

    @ApiOperation(value = "Save stockExcahngeData", nickname = "saveStockExchangeData", httpMethod = "post", notes = "", response = StockExchangeResponse.class, tags = {"results",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Response created successfully", response = StockExchangeResponse.class),
            @ApiResponse(code = 400, message = "Internal server error.", response = StockExchangeResponse.class),
            @ApiResponse(code = 401, message = "Internal server error.", response = StockExchangeResponse.class),
            @ApiResponse(code = 500, message = "Internal server error.", response = StockExchangeResponse.class)})
    @PostMapping (value = "/addStockExchangeData",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    default ResponseEntity<StockExchangeResponse> addStockExchangeData(HttpServletRequest request, @NotNull @RequestBody StockExchangeData stockExchangeobj,
                                                                              Principal principal,
                                                                              BindingResult bindingResult
    ) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


