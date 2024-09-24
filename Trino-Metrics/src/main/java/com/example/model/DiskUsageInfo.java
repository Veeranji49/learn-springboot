package com.example.model;

import java.io.Serializable;

public class DiskUsageInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    private double totalDiskSpaceGB;
    private double freeDiskSpaceGB;
    private double diskUsagePercentage;

    public DiskUsageInfo(){}

    public double getTotalDiskSpaceGB() {
        return totalDiskSpaceGB;
    }

    public void setTotalDiskSpaceGB(double totalDiskSpaceGB) {
        this.totalDiskSpaceGB = totalDiskSpaceGB;
    }

    public double getFreeDiskSpaceGB() {
        return freeDiskSpaceGB;
    }

    public void setFreeDiskSpaceGB(double freeDiskSpaceGB) {
        this.freeDiskSpaceGB = freeDiskSpaceGB;
    }

    public double getDiskUsagePercentage() {
        return diskUsagePercentage;
    }

    public void setDiskUsagePercentage(double diskUsagePercentage) {
        this.diskUsagePercentage = diskUsagePercentage;
    }

    public DiskUsageInfo(double totalDiskSpaceGB, double freeDiskSpaceGB, double diskUsagePercentage) {
        this.totalDiskSpaceGB = totalDiskSpaceGB;
        this.freeDiskSpaceGB = freeDiskSpaceGB;
        this.diskUsagePercentage = diskUsagePercentage;
    }
}
