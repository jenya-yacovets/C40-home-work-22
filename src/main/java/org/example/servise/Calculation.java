package org.example.servise;

import org.example.config.OperationList;
import org.example.entity.Operation;
import org.example.entity.operationType.OperationType;
import org.example.store.HistoryDAO;
import org.example.store.InMemoryHistoryDAO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.example.util.Console.readIntConsole;
import static org.example.util.Console.writeConsole;

@Component
public class Calculation {
    private Map<Integer, OperationType> operationTypeMap;
    private int numGetHistoryOperation;
    private HistoryDAO store;

    public Calculation() {
        operationTypeMap = OperationList.getOperationTypeMap();
        numGetHistoryOperation = operationTypeMap.size() + 1;
        store = InMemoryHistoryDAO.getInstance();
    }

    public void run() {
        writeConsole("----- Добро пожаловать в калькулятор! -----");
        start();
        writeConsole("----- Прощай -----");
    }

    private void start() {
        while (true) {
            printMenu();
            int numOperation = readIntConsole(0, numGetHistoryOperation);

            if(numOperation == 0) {
                break;
            }
            if(numOperation == numGetHistoryOperation) {
                printHistory();
                continue;
            }

            Operation execute = operationTypeMap.get(numOperation).execute();
            writeConsole(String.format("Результат: %f", execute.getResult()));
            store.add(execute);
        }
    }

    private void printMenu() {
        writeConsole("=== Выберите операцию ===");
        writeConsole("0 - Выход");

        for(Map.Entry<Integer, OperationType> item : operationTypeMap.entrySet()) {
            writeConsole(String.format("%d - %s", item.getKey(), item.getValue().name()));
        }

        writeConsole(String.format("%d - Показать историю", numGetHistoryOperation));
    }

    private void printHistory() {
        List<Operation> all = store.getAll();

        for(Operation item : all) {
            writeConsole("--------------------");
            writeConsole(String.format("Тип операции: %s", item.getOperationType().name()));
            writeConsole(String.format("Числа: %s", item.getNumbers().stream().map(Object::toString).collect(Collectors.joining(", "))));
            writeConsole(String.format("Результат: %f", item.getResult()));
            writeConsole("--------------------");
        }
    }
}
