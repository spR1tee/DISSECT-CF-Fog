package hu.u_szeged.inf.fog.simulator.spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class VmInstance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int cpu;
    private long ram;
    private double coreProcessingPower;
    private int startupProcess;
    private long reqDisk;
    private double pricePerTick;
    private double cpuUsage;
    private double memoryUsage;
    private String status;
    private double networkTraffic;

    // Getters and setters


    public long getReqDisk() {
        return reqDisk;
    }

    public void setReqDisk(long reqDisk) {
        this.reqDisk = reqDisk;
    }

    public int getStartupProcess() {
        return startupProcess;
    }

    public void setStartupProcess(int startupProcess) {
        this.startupProcess = startupProcess;
    }

    public double getPricePerTick() {
        return pricePerTick;
    }

    public void setPricePerTick(double pricePerTick) {
        this.pricePerTick = pricePerTick;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCpu() {
        return cpu;
    }

    public void setCpu(int cpu) {
        this.cpu = cpu;
    }

    public long getRam() {
        return ram;
    }

    public void setRam(long ram) {
        this.ram = ram;
    }

    public double getCoreProcessingPower() {
        return coreProcessingPower;
    }

    public void setCoreProcessingPower(double coreProcessingPower) {
        this.coreProcessingPower = coreProcessingPower;
    }

    public double getCpuUsage() {
        return cpuUsage;
    }

    public void setCpuUsage(double cpuUsage) {
        this.cpuUsage = cpuUsage;
    }

    public double getMemoryUsage() {
        return memoryUsage;
    }

    public void setMemoryUsage(double memoryUsage) {
        this.memoryUsage = memoryUsage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getNetworkTraffic() {
        return networkTraffic;
    }

    public void setNetworkTraffic(double networkTraffic) {
        this.networkTraffic = networkTraffic;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

