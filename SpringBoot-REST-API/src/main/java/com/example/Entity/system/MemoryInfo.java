package com.example.Entity.system;

import java.io.Serializable;

public class MemoryInfo implements Serializable {

    private double totalMemoryGB;
    private double usedMemoryPercentage;
    private String operatingSystem;

    //PDC
    public MemoryInfo() {}

    //PPC
    public MemoryInfo(double totalMemoryGB, double usedMemoryPercentage,String operatingSystem) {
        super();
        this.totalMemoryGB = totalMemoryGB;
        this.usedMemoryPercentage = usedMemoryPercentage;
        this.operatingSystem=operatingSystem;
    }


    //PSM & PGM
    public double getTotalMemoryGB() {
        return totalMemoryGB;
    }

    public void setTotalMemoryGB(double totalMemoryGB) {
        this.totalMemoryGB = totalMemoryGB;
    }

    public double getUsedMemoryPercentage() {
        return usedMemoryPercentage;
    }

    public void setUsedMemoryPercentage(double usedMemoryPercentage) {
        this.usedMemoryPercentage = usedMemoryPercentage;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }
}
