package com.example.model;

import java.io.Serializable;

public class SystemInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    private double cpuUsagePercentage;
    private int numberOfProcessors;
    private MemoryUsageInfo memoryInfo;
    private DiskUsageInfo diskInfo;
    private IPAddress ipAddress;
    private Hostname hostname;

    public double getCpuUsagePercentage() {
        return cpuUsagePercentage;
    }

    public void setCpuUsagePercentage(double cpuUsagePercentage) {
        this.cpuUsagePercentage = cpuUsagePercentage;
    }

    public int getNumberOfProcessors() {
        return numberOfProcessors;
    }

    public void setNumberOfProcessors(int numberOfProcessors) {
        this.numberOfProcessors = numberOfProcessors;
    }

    public MemoryUsageInfo getMemoryInfo() {
        return memoryInfo;
    }

    public void setMemoryInfo(MemoryUsageInfo memoryInfo) {
        this.memoryInfo = memoryInfo;
    }

    public DiskUsageInfo getDiskInfo() {
        return diskInfo;
    }

    public void setDiskInfo(DiskUsageInfo diskInfo) {
        this.diskInfo = diskInfo;
    }

    public IPAddress getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(IPAddress ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Hostname getHostname() {
        return hostname;
    }

    public void setHostname(Hostname hostname) {
        this.hostname = hostname;
    }

    public SystemInfo(double cpuUsagePercentage, int numberOfProcessors, MemoryUsageInfo memoryInfo, DiskUsageInfo diskInfo, IPAddress ipAddress, Hostname hostname) {
        this.cpuUsagePercentage = cpuUsagePercentage;
        this.numberOfProcessors = numberOfProcessors;
        this.memoryInfo = memoryInfo;
        this.diskInfo = diskInfo;
        this.ipAddress = ipAddress;
        this.hostname = hostname;
    }
}
