package core.basesyntax;

import core.basesyntax.model.Operations;

public class Main {
    public static void main(String[] args) {
        Map<Operations, OperationStrategy> operationStrategyMap = new HashMap<>();
        OperationsDao dao = new OperationsDao();
        operationStrategyMap.put(Operations.BALANCE, new BalanceStrategy(dao));
        operationStrategyMap.put(Operations.SUPPLY, new SupplyStrategy(dao));
        operationStrategyMap.put(Operations.PURCHASE, new PurchaseStrategy(dao));
        operationStrategyMap.put(Operations.RETURN, new ReturnStrategy(dao));
        FileReader fileReaderService = new CsvFileReader();
        List<String> linesFromFile =
                fileReaderService.getAllLines("src/main/resources/FileReaderTest.csv");
        CsvParser<TransactionDto> parser = new CsvToTransactionDtoParser();
        List<TransactionDto> parsed = parser.parse(linesFromFile);
        ShopItemService shopService = new ShopItemServiceImpl(operationStrategyMap);
        shopService.applyOperationOnShopItem(parsed);
        String report = shopService.getStringReport();
        FileWriter fileWriter = new CsvFileWriter();
        fileWriter.write(report,"src/main/resources/result.csv");

    }
}
