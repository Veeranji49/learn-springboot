package com.example.Entity.system;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;

@ApiObject
public class SystemInfo implements Serializable {

    @ApiObjectField(name="Cpu Usage Percentage",description = "To Get CPU usage Percentage")
    private double cpuUsagePercentage;

    @ApiObjectField(name="Ip Address", description = "To get IP address of system")
    private String ipAddress;

    @ApiObjectField(name="Hostname", description = "To get Hostname of system")
    private String hostname;

    @ApiObjectField(name="MemoryInfo", description = "To get Memory Information of system")
    private MemoryInfo memoryInfo;

    @ApiObjectField(name="DiskInfo", description = "To get Disk Information of system")
    private DiskInfo diskInfo;

    @ApiObjectField(name = "JVM Info", description = "To get JVM Information of system")
    private JvmInfo jvmInfo;

    @ApiObjectField(name="Processors", description = "To get processors of system")
    private int processors;

    @ApiObjectField(name="Architecture", description = "To get Architecture of system")
    private String architecture;

    @ApiObjectField(name="Current Time", description = "To get Current time of system")
    private LocalDateTime currentTime;

    @ApiObjectField(name="ClassLoader Details", description = "To get Class Loader details")
    private String classLoaderDetails;

    @ApiObjectField(name="Thread Details", description = "To get Thread details of system")
    private Map<Thread.State, Integer> threadDetails;

    @ApiObjectField(name="Environmental variables", description = "To get Environmental variables of system")
    private Map<String, String> environmentVariables;

    @ApiObjectField(name="System Properties", description = "To get System Properties")
    private Map<String, String> systemProperties;

    @ApiObjectField(name="Operating System", description = "To get Operating System")
    private String operatingSystem;

    @ApiObjectField(name="User Home Directory", description = "To get User Home Directory")
    private String userHomeDirectory;

    //PDC
    public SystemInfo() {
    }

    //PPC
    public SystemInfo(double cpuUsagePercentage, String ipAddress, String hostname, MemoryInfo memoryInfo, DiskInfo diskInfo, JvmInfo jvmInfo, int processors, String architecture, LocalDateTime currentTime, String classLoaderDetails, Map<Thread.State, Integer> threadDetails, Map<String, String> environmentVariables, Map<String, String> systemProperties, String operatingSystem, String userHomeDirectory) {
        this.cpuUsagePercentage = cpuUsagePercentage;
        this.ipAddress = ipAddress;
        this.hostname = hostname;
        this.memoryInfo = memoryInfo;
        this.diskInfo = diskInfo;
        this.jvmInfo = jvmInfo;
        this.processors = processors;
        this.architecture = architecture;
        this.currentTime = currentTime;
        this.classLoaderDetails = classLoaderDetails;
        this.threadDetails = threadDetails;
        this.environmentVariables = environmentVariables;
        this.systemProperties = systemProperties;
        this.operatingSystem = operatingSystem;
        this.userHomeDirectory = userHomeDirectory;
    }

    public double getCpuUsagePercentage() {
        return cpuUsagePercentage;
    }

    public void setCpuUsagePercentage(double cpuUsagePercentage) {
        this.cpuUsagePercentage = cpuUsagePercentage;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public MemoryInfo getMemoryInfo() {
        return memoryInfo;
    }

    public void setMemoryInfo(MemoryInfo memoryInfo) {
        this.memoryInfo = memoryInfo;
    }

    public DiskInfo getDiskInfo() {
        return diskInfo;
    }

    public void setDiskInfo(DiskInfo diskInfo) {
        this.diskInfo = diskInfo;
    }

    public JvmInfo getJvmInfo() {
        return jvmInfo;
    }

    public void setJvmInfo(JvmInfo jvmInfo) {
        this.jvmInfo = jvmInfo;
    }

    public int getProcessors() {
        return processors;
    }

    public void setProcessors(int processors) {
        this.processors = processors;
    }

    public String getArchitecture() {
        return architecture;
    }

    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }

    public LocalDateTime getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(LocalDateTime currentTime) {
        this.currentTime = currentTime;
    }

    public String getClassLoaderDetails() {
        return classLoaderDetails;
    }

    public void setClassLoaderDetails(String classLoaderDetails) {
        this.classLoaderDetails = classLoaderDetails;
    }

    public Map<Thread.State, Integer> getThreadDetails() {
        return threadDetails;
    }

    public void setThreadDetails(Map<Thread.State, Integer> threadDetails) {
        this.threadDetails = threadDetails;
    }

    public Map<String, String> getEnvironmentVariables() {
        return environmentVariables;
    }

    public void setEnvironmentVariables(Map<String, String> environmentVariables) {
        this.environmentVariables = environmentVariables;
    }

    public Map<String, String> getSystemProperties() {
        return systemProperties;
    }

    public void setSystemProperties(Map<String, String> systemProperties) {
        this.systemProperties = systemProperties;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getUserHomeDirectory() {
        return userHomeDirectory;
    }

    public void setUserHomeDirectory(String userHomeDirectory) {
        this.userHomeDirectory = userHomeDirectory;
    }
}