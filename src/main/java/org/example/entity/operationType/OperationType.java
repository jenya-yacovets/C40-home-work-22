package org.example.entity.operationType;

import org.example.entity.Operation;

import java.util.List;

public interface OperationType {
    Operation execute();
    double result(List<Double> numbers);
    String name();
}
