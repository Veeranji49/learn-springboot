package com.example.controller;

import com.example.model.*;
import com.sun.management.OperatingSystemMXBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping(value = "/system-resource")
public class SystemResourceController {

    @GetMapping("")
    public SystemInfo getSystemInfo() {
        com.sun.management.OperatingSystemMXBean osBean =
                (com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

        double cpuUsagePercentage = getSystemCpuLoad() * 100;

        // Retrieving Processors of a system
        int numberOfProcessors = osBean.getAvailableProcessors();

        MemoryUsageInfo memoryInfo = getMemoryUsageInfo(osBean);
        DiskUsageInfo diskInfo = getDiskUsageInfo();

        IPAddress ipAddress = new IPAddress(getIPAddress());
        Hostname hostname = new Hostname(getHostname());

        return new SystemInfo(cpuUsagePercentage, numberOfProcessors, memoryInfo, diskInfo, ipAddress, hostname);
    }

    // Memory Usage
    private MemoryUsageInfo getMemoryUsageInfo(com.sun.management.OperatingSystemMXBean osBean) {

        long totalPhysicalMemoryBytes = osBean.getTotalPhysicalMemorySize();
        double totalMemoryGB = bytesToGB(totalPhysicalMemoryBytes);

        long freePhysicalMemoryBytes = osBean.getFreePhysicalMemorySize();
        double freeMemoryGB = bytesToGB(freePhysicalMemoryBytes);

        long usedPhysicalMemoryBytes = totalPhysicalMemoryBytes - freePhysicalMemoryBytes;
        double usedMemoryGB = bytesToGB(usedPhysicalMemoryBytes);

        double memoryUsagePercentage = (usedMemoryGB / totalMemoryGB) * 100;

        return new MemoryUsageInfo(usedMemoryGB, totalMemoryGB, memoryUsagePercentage);
    }

    // Disk Usage
    private DiskUsageInfo getDiskUsageInfo() {
        File[] roots = File.listRoots();
        long totalDiskSpaceBytes = 0;
        long freeDiskSpaceBytes = 0;

        for (File root : roots) {
            totalDiskSpaceBytes += root.getTotalSpace();
            freeDiskSpaceBytes += root.getFreeSpace();
        }

        double totalDiskSpaceGB = bytesToGB(totalDiskSpaceBytes);
        double freeDiskSpaceGB = bytesToGB(freeDiskSpaceBytes);

        double diskUsagePercentage = ((totalDiskSpaceGB - freeDiskSpaceGB) / totalDiskSpaceGB) * 100;

        return new DiskUsageInfo(totalDiskSpaceGB, freeDiskSpaceGB, diskUsagePercentage);
    }

    //Converting bytes to GigaBytes
    private double bytesToGB(long bytes) {
        return bytes / (1024.0 * 1024.0 * 1024.0);
    }

    // Retrieving IPAddress of a system
    private String getIPAddress() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return "Unknown";
        }
    }

    // Retrieving Hostname of a system
    private String getHostname() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return "Unknown";
        }
    }

    //Retrieving CPU usage
    public double getSystemCpuLoad() {
        OperatingSystemMXBean osBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        try {
            double cpuUsage = osBean.getCpuLoad();
//            System.out.println(osBean.getCpuLoad());
//            System.out.println(osBean.getProcessCpuLoad());
//            System.out.println(osBean.getSystemCpuLoad());
            if (cpuUsage < 0) {
                return 0;
            } else {
                return cpuUsage;
            }
        } catch (Exception e) {
            System.out.println("Error retrieving CPU usage: " + e.getMessage());
        }

        return 0; // Return a zero if CPU usage retrieval failed
    }

}
