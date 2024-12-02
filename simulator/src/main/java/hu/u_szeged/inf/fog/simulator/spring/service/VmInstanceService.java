package hu.u_szeged.inf.fog.simulator.spring.service;

import hu.u_szeged.inf.fog.simulator.spring.model.VmInstance;
import hu.u_szeged.inf.fog.simulator.spring.model.VmInstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VmInstanceService {

    @Autowired
    private VmInstanceRepository vmInstanceRepository;

    public List<VmInstance> getAllVmInstances() {
        return vmInstanceRepository.findAll();
    }

    public VmInstance getVmInstanceById(Long id) {
        return vmInstanceRepository.findById(id).orElse(null);
    }

    public VmInstance createVmInstance(VmInstance vmInstance) {
        return vmInstanceRepository.save(vmInstance);
    }

    public void deleteVmInstance(Long id) {
        vmInstanceRepository.deleteById(id);
    }
}
