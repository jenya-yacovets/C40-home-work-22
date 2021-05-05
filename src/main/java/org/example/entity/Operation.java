package org.example.entity;

import org.example.entity.operationType.OperationType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Operation {
    private List<Double> numbers = new ArrayList<>();
    private OperationType operationType;

    public Operation(List<Double> numbers, OperationType operationType) {
        this.numbers = numbers;
        this.operationType = operationType;
    }

    public Operation() {
    }

    public List<Double> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Double> numbers) {
        this.numbers = numbers;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public Double getResult() {
        return operationType.result(numbers);
    }

    public void addNumber(Double number) {
        numbers.add(number);
    }

    @Override
    public String toString() {
        return "Operation{" +
                "numbers=" + numbers +
                ", operationType=" + operationType +
                '}';
    }
}
