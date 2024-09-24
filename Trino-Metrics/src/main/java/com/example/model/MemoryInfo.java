package com.example.model;

public class MemoryInfo {

    private final int availableProcessors;
    private final MemoryPoolInfo pool;

    public MemoryInfo(int availableProcessors, MemoryPoolInfo pool) {
        this.availableProcessors = availableProcessors;
        this.pool = pool;
    }

    public int getAvailableProcessors() {
        return availableProcessors;
    }

    public MemoryPoolInfo getPool() {
        return pool;
    }
}
