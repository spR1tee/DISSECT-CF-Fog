package hu.u_szeged.inf.fog.simulator.spring;

import com.fasterxml.jackson.databind.ObjectMapper;
import hu.u_szeged.inf.fog.simulator.spring.model.VmData;
import hu.u_szeged.inf.fog.simulator.spring.model.VmInstance;
import hu.u_szeged.inf.fog.simulator.spring.service.VmInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/simulator")
public class SimulatorController {

    @Autowired
    private VmInstanceService vmInstanceService;

    @PostMapping("/request")
    public ResponseEntity<String> request(@RequestBody String jsonContent) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            VmData vmData = objectMapper.readValue(jsonContent, VmData.class);
            createVm(vmData);
            return ResponseEntity.ok("Data has been processed.");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error while processing data.");
        }
    }

    private void createVm(VmData vmData) {
        List<VmInstance> vmInstances = vmData.getVmInstances();
        /*for (VmInstance vmInstance : vmInstances) {
            vmInstanceService.createVmInstance(vmInstance);
        }*/
        List<VmInstance> query = vmInstanceService.getAllVmInstances();
        for (VmInstance vmInstance : query) {
            /*if (vmInstance.getId() != null) {
                vmInstanceService.deleteVmInstance(vmInstance.getId());
            }*/
            System.out.println(vmInstance.getId() + " " + vmInstance.getName());
        }
        // TO DO
    }
}

