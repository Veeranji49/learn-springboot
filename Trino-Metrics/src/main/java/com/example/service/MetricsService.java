package com.example.service;

import com.example.dto.MetricsDTO;
import com.example.model.MemoryInfo;
import com.example.model.MemoryPoolInfo;
import com.sun.management.OperatingSystemMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.RuntimeMXBean;
import java.net.InetAddress;
import java.util.HashMap;

public class MetricsService {

    private final OperatingSystemMXBean osBean;
    private final MemoryMXBean memoryMXBean;
    private final RuntimeMXBean runtimeMXBean;


    public MetricsService() {
        this.osBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        this.memoryMXBean = ManagementFactory.getMemoryMXBean();
        this.runtimeMXBean = ManagementFactory.getRuntimeMXBean();
    }

    public MetricsDTO collectMetrics() {
        String externalAddress;
        String internalAddress;
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            externalAddress = localHost.getHostAddress();
            internalAddress = localHost.getHostAddress();
        } catch (Exception e) {
            externalAddress = "Unknown";
            internalAddress = "Unknown";
        }

        long maxMemory = Runtime.getRuntime().maxMemory();
        long freeMemory = Runtime.getRuntime().freeMemory();

        MemoryPoolInfo poolInfo = new MemoryPoolInfo(
                maxMemory,
                maxMemory - freeMemory,
                0,
                new HashMap<>(),
                new HashMap<>(),
                new HashMap<>(),
                new HashMap<>(),
                new HashMap<>(),
                freeMemory
        );

        MemoryInfo memoryInfo = new MemoryInfo(
                osBean.getAvailableProcessors(),
                poolInfo
        );

        return new MetricsDTO(
                externalAddress,
                internalAddress,
                memoryInfo,
                osBean.getAvailableProcessors(),
                osBean.getProcessCpuLoad(),
                osBean.getSystemCpuLoad(),
                memoryMXBean.getHeapMemoryUsage().getUsed(),
                memoryMXBean.getHeapMemoryUsage().getMax(),
                memoryMXBean.getNonHeapMemoryUsage().getUsed()
        );
    }

  /*  private String formatUptime(long uptimeMillis) {
        long hours = TimeUnit.MILLISECONDS.toHours(uptimeMillis);
        return String.format("%.2fh", hours + (uptimeMillis % TimeUnit.HOURS.toMillis(1)) / 3600000.0);
    }*/
}