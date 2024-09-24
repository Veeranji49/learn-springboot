package com.example.model;

import java.util.Map;

public class MemoryPoolInfo {

    private final long maxBytes;
    private final long reservedBytes;
    private final long reservedRevocableBytes;
    private final Map<String, Long> queryMemoryReservations;
    private final Map<String, Long> queryMemoryAllocations;
    private final Map<String, Long> queryMemoryRevocableReservations;
    private final Map<String, Long> taskMemoryReservations;
    private final Map<String, Long> taskMemoryRevocableReservations;
    private final long freeBytes;

    public MemoryPoolInfo(long maxBytes, long reservedBytes, long reservedRevocableBytes,
                          Map<String, Long> queryMemoryReservations, Map<String, Long> queryMemoryAllocations,
                          Map<String, Long> queryMemoryRevocableReservations, Map<String, Long> taskMemoryReservations,
                          Map<String, Long> taskMemoryRevocableReservations, long freeBytes) {
        this.maxBytes = maxBytes;
        this.reservedBytes = reservedBytes;
        this.reservedRevocableBytes = reservedRevocableBytes;
        this.queryMemoryReservations = queryMemoryReservations;
        this.queryMemoryAllocations = queryMemoryAllocations;
        this.queryMemoryRevocableReservations = queryMemoryRevocableReservations;
        this.taskMemoryReservations = taskMemoryReservations;
        this.taskMemoryRevocableReservations = taskMemoryRevocableReservations;
        this.freeBytes = freeBytes;
    }

    public long getMaxBytes() {
        return maxBytes;
    }

    public long getReservedBytes() {
        return reservedBytes;
    }

    public long getReservedRevocableBytes() {
        return reservedRevocableBytes;
    }

    public Map<String, Long> getQueryMemoryReservations() {
        return queryMemoryReservations;
    }

    public Map<String, Long> getQueryMemoryAllocations() {
        return queryMemoryAllocations;
    }

    public Map<String, Long> getQueryMemoryRevocableReservations() {
        return queryMemoryRevocableReservations;
    }

    public Map<String, Long> getTaskMemoryReservations() {
        return taskMemoryReservations;
    }

    public Map<String, Long> getTaskMemoryRevocableReservations() {
        return taskMemoryRevocableReservations;
    }

    public long getFreeBytes() {
        return freeBytes;
    }
}