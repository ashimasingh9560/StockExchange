# StockExchange
Basic Stock Exchange related server application

About the Server:
1. The Stock Exchange Api consists of the three main API methods requested
for bulk data storage, adding a record and fetching the data based on a Ticker Id which I am using as a Stock Type
   
2. The StockExchangeResponse, ResultDetails, MessageHeader, LookupData are the classes for output purpose displaying the result in JSON.

3. The Api is implemented by the Controller (StockExchangeController) which further calls the Service layer (StockExchangeService).

4. StockExchangeDao is implemented by StockExchangeDaoImpl to provide the actual actions taken for the operations

5. StockExchangeData is used to get the input from the StockExchangeAPI and then it is converted to a Value Object (StockExchangeVO) for Marshalling and Unmarshalling purpose (in case to be used).

6. StockExchangeRepository is for the repository related functions.

7. StockExchangeEntity is the final entity class used for persistence.
