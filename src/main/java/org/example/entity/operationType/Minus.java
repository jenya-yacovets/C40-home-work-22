package org.example.entity.operationType;

import org.example.entity.Operation;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.example.util.Console.readIntConsole;

@Component
public class Minus implements OperationType {
    @Override
    public Operation execute() {
        Operation operation = new Operation();
        operation.addNumber((double) readIntConsole("Введите первое число:"));
        operation.addNumber((double) readIntConsole("Введите второе число:"));
        operation.setOperationType(new Minus());
        return operation;
    }
    @Override
    public double result(List<Double> numbers) {
        return numbers.get(0) - numbers.get(1);
    }
    @Override
    public String name() {
        return "Разность";
    }
}
