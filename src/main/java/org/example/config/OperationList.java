package org.example.config;

import org.example.entity.operationType.Minus;
import org.example.entity.operationType.OperationType;
import org.example.entity.operationType.Plus;
import org.example.entity.operationType.Square;

import java.util.HashMap;
import java.util.Map;

public class OperationList {
    private static Map<Integer, OperationType> operationTypeMap;

    static {
        operationTypeMap = new HashMap<>();
        operationTypeMap.put(1, new Plus());
        operationTypeMap.put(2, new Minus());
        operationTypeMap.put(3, new Square());
    }

    public static Map<Integer, OperationType> getOperationTypeMap() {
        return operationTypeMap;
    }
}
