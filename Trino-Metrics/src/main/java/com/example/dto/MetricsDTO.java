package com.example.dto;

import com.example.model.MemoryInfo;

public class MetricsDTO {

    private final String externalAddress;
    private final String internalAddress;
    private final MemoryInfo memoryInfo;
    private final int processors;
    private final double processCpuLoad;
    private final double systemCpuLoad;
    private final long heapUsed;
    private final long heapAvailable;
    private final long nonHeapUsed;

    public MetricsDTO(String externalAddress, String internalAddress, MemoryInfo memoryInfo,
                      int processors, double processCpuLoad, double systemCpuLoad, long heapUsed,
                      long heapAvailable, long nonHeapUsed) {
        this.externalAddress = externalAddress;
        this.internalAddress = internalAddress;
        this.memoryInfo = memoryInfo;
        this.processors = processors;
        this.processCpuLoad = processCpuLoad;
        this.systemCpuLoad = systemCpuLoad;
        this.heapUsed = heapUsed;
        this.heapAvailable = heapAvailable;
        this.nonHeapUsed = nonHeapUsed;
    }

    public String getExternalAddress() {
        return externalAddress;
    }

    public String getInternalAddress() {
        return internalAddress;
    }

    public MemoryInfo getMemoryInfo() {
        return memoryInfo;
    }

    public int getProcessors() {
        return processors;
    }

    public double getProcessCpuLoad() {
        return processCpuLoad;
    }

    public double getSystemCpuLoad() {
        return systemCpuLoad;
    }

    public long getHeapUsed() {
        return heapUsed;
    }

    public long getHeapAvailable() {
        return heapAvailable;
    }

    public long getNonHeapUsed() {
        return nonHeapUsed;
    }
}