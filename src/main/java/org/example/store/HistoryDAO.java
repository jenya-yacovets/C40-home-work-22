package org.example.store;

import org.example.entity.Operation;

import java.util.List;

public interface HistoryDAO {
    void add(Operation operation);
    List<Operation> getAll();
}
