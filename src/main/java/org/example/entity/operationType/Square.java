package org.example.entity.operationType;

import org.example.entity.Operation;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.example.util.Console.readIntConsole;

@Component
public class Square implements OperationType {
    @Override
    public Operation execute() {
        Operation operation = new Operation();
        operation.addNumber((double) readIntConsole("Введите число:"));
        operation.setOperationType(new Square());
        return operation;
    }

    @Override
    public double result(List<Double> numbers) {
        return numbers.get(0) * numbers.get(0);
    }

    @Override
    public String name() {
        return "Возведение в квадрат";
    }
}
