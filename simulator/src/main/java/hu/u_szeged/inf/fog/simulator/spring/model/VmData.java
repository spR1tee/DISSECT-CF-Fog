package hu.u_szeged.inf.fog.simulator.spring.model;

import java.util.List;

public class VmData {

    private List<VmInstance> vmInstances;
    private String requestType;

    // Getters and setters
    public List<VmInstance> getVmInstances() {
        return vmInstances;
    }

    public void setVmInstances(List<VmInstance> vmInstances) {
        this.vmInstances = vmInstances;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }
}

