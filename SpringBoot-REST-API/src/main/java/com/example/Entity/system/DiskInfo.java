package com.example.Entity.system;


import java.io.Serializable;

public class DiskInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private double totalDiskSpaceGB;
    private double freeDiskSpaceGB;
    private double diskUsagePercentage;

   public DiskInfo(){

   }

    public DiskInfo(double diskUsagePercentage, double freeDiskSpaceGB, double totalDiskSpaceGB) {
        this.diskUsagePercentage = diskUsagePercentage;
        this.freeDiskSpaceGB = freeDiskSpaceGB;
        this.totalDiskSpaceGB = totalDiskSpaceGB;
    }

    public double getDiskUsagePercentage() {
        return diskUsagePercentage;
    }

    public void setDiskUsagePercentage(double diskUsagePercentage) {
        this.diskUsagePercentage = diskUsagePercentage;
    }

    public double getFreeDiskSpaceGB() {
        return freeDiskSpaceGB;
    }

    public void setFreeDiskSpaceGB(double freeDiskSpaceGB) {
        this.freeDiskSpaceGB = freeDiskSpaceGB;
    }

    public double getTotalDiskSpaceGB() {
        return totalDiskSpaceGB;
    }

    public void setTotalDiskSpaceGB(double totalDiskSpaceGB) {
        this.totalDiskSpaceGB = totalDiskSpaceGB;
    }
}