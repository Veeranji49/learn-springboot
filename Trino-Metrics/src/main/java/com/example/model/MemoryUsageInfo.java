package com.example.model;

import java.io.Serializable;

public class MemoryUsageInfo implements Serializable {


    private static final long serialVersionUID = 1L;
    private double usedMemoryGB;
    private double totalMemoryGB;
    private double memoryUsagePercentage;


    public MemoryUsageInfo(){}

    public double getUsedMemoryGB() {
        return usedMemoryGB;
    }

    public void setUsedMemoryGB(double usedMemoryGB) {
        this.usedMemoryGB = usedMemoryGB;
    }

    public double getTotalMemoryGB() {
        return totalMemoryGB;
    }

    public void setTotalMemoryGB(double totalMemoryGB) {
        this.totalMemoryGB = totalMemoryGB;
    }

    public double getMemoryUsagePercentage() {
        return memoryUsagePercentage;
    }

    public void setMemoryUsagePercentage(double memoryUsagePercentage) {
        this.memoryUsagePercentage = memoryUsagePercentage;
    }

    public MemoryUsageInfo(double usedMemoryGB, double totalMemoryGB, double memoryUsagePercentage) {
        this.usedMemoryGB = usedMemoryGB;
        this.totalMemoryGB = totalMemoryGB;
        this.memoryUsagePercentage = memoryUsagePercentage;
    }
}
