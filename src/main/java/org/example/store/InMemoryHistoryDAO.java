package org.example.store;

import org.example.entity.Operation;

import java.util.ArrayList;
import java.util.List;

public class InMemoryHistoryDAO implements HistoryDAO{
    private static InMemoryHistoryDAO instance;
    private List<Operation> list;

    private InMemoryHistoryDAO() {
        list = new ArrayList<>();
    }

    public static InMemoryHistoryDAO getInstance(){
        if(instance == null) {
            instance = new InMemoryHistoryDAO();
        }
        return instance;
    }

    @Override
    public void add(Operation operation) {
        list.add(operation);
    }

    @Override
    public List<Operation> getAll() {
        return new ArrayList<>(list);
    }
}
