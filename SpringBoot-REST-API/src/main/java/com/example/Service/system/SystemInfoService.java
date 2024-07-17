package com.example.Service.system;

import com.example.Entity.system.DiskInfo;
import com.example.Entity.system.JvmInfo;
import com.example.Entity.system.MemoryInfo;
import com.example.Entity.system.SystemInfo;
import org.springframework.stereotype.Service;

import java.io.File;
import java.lang.management.*;
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

@Service
public class SystemInfoService {

    public SystemInfo getSystemInfo() {
        return populateSystemInfo();
    }

    private SystemInfo populateSystemInfo() {
        SystemInfo systemInfo = new SystemInfo();

        try {

            // CPU usage percentage
            com.sun.management.OperatingSystemMXBean osBean = (com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
            double cpuUsagePercentage = osBean.getProcessCpuLoad() * 100;
            systemInfo.setCpuUsagePercentage(cpuUsagePercentage);

            // Get IP Address and Hostname
            InetAddress localHost = InetAddress.getLocalHost();
            systemInfo.setIpAddress(localHost.getHostAddress());
            systemInfo.setHostname(localHost.getHostName());

            // Get Memory Information
            long totalMemoryBytes = osBean.getTotalPhysicalMemorySize();
            double totalMemoryGB = bytesToGB(totalMemoryBytes);  // Convert bytes to GB

            MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
            MemoryUsage heapMemoryUsage = memoryBean.getHeapMemoryUsage();
            double usedMemoryGB = bytesToGB(heapMemoryUsage.getUsed());
            double memoryUsagePercentage = (usedMemoryGB / totalMemoryGB) * 100;
            String operatingSystem = null;
            MemoryInfo memoryInfo = new MemoryInfo(totalMemoryGB, memoryUsagePercentage,operatingSystem);
            systemInfo.setMemoryInfo(memoryInfo);

            // Get Disk Information
            // Disk usage calculation remains unchanged
            File root = new File("/");
            long totalDiskSpace = root.getTotalSpace();
            double totalDiskSpaceGB = bytesToGB(totalDiskSpace);

            long freeDiskSpace = root.getFreeSpace();
            double diskUsagePercentage = ((double) (totalDiskSpace - freeDiskSpace) / totalDiskSpace) * 100;
            DiskInfo diskInfo = new DiskInfo(totalDiskSpaceGB, bytesToGB(freeDiskSpace), diskUsagePercentage);
            systemInfo.setDiskInfo(diskInfo);

            // Get JVM Information
            RuntimeMXBean runtimeMxBean = ManagementFactory.getRuntimeMXBean();
            JvmInfo jvmInfo = new JvmInfo();
            jvmInfo.setJvmName(runtimeMxBean.getVmName());
            jvmInfo.setJvmVendor(runtimeMxBean.getVmVendor());
            jvmInfo.setJvmVersion(runtimeMxBean.getVmVersion());
            systemInfo.setJvmInfo(jvmInfo);

            // Get Additional Information
            systemInfo.setProcessors(Runtime.getRuntime().availableProcessors());
            systemInfo.setArchitecture(System.getProperty("os.arch"));
            systemInfo.setCurrentTime(LocalDateTime.now(ZoneId.systemDefault()));

            // Operating System details
            String osInfo = System.getProperty("os.name") + " " + System.getProperty("os.version");
            systemInfo.getMemoryInfo().setOperatingSystem(osInfo);

            // classLoader details
            ClassLoader classLoader = SystemInfo.class.getClassLoader();
            String classLoaderDetails = classLoader.toString();
            systemInfo.setClassLoaderDetails(classLoaderDetails);

            // System Threads information
            ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
            ThreadInfo[] threadInfos = threadMXBean.getThreadInfo(threadMXBean.getAllThreadIds());

            Map<Thread.State, Integer> threadDetails = new HashMap<>();
            for (ThreadInfo threadInfo : threadInfos) {
                Thread.State state = threadInfo.getThreadState();
                threadDetails.put(state, threadDetails.getOrDefault(state, 0) + 1);
            }

            systemInfo.setThreadDetails(threadDetails);

            Map<String, String> envVariables = new HashMap<>(System.getenv());
            systemInfo.setEnvironmentVariables(envVariables);

            // Populate System Properties
            Map<String, String> systemProps = new HashMap<String,String>();
            systemInfo.setSystemProperties(systemProps);

            // Populate System Environment Details
            systemInfo.setOperatingSystem(System.getProperty("os.name"));
            systemInfo.setUserHomeDirectory(System.getProperty("user.home"));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return systemInfo;
    }
    private double bytesToGB(long bytes) {
        return bytes / (1024.0 * 1024.0 * 1024.0);
    }
}
