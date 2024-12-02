package hu.u_szeged.inf.fog.simulator.spring;

import com.fasterxml.jackson.databind.ObjectMapper;
import hu.u_szeged.inf.fog.simulator.spring.model.VmData;
import hu.u_szeged.inf.fog.simulator.spring.model.VmInstance;
import hu.u_szeged.inf.fog.simulator.spring.service.VmInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SimulatorController {

    @Autowired
    private VmInstanceService vmInstanceService;

    @PostMapping("/startSimulation")
    public ResponseEntity<String> startSimulation(@RequestBody String jsonContent) {
        // A beérkező JSON adat
        //System.out.println("Received JSON: " + jsonContent);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            VmData vmData = objectMapper.readValue(jsonContent, VmData.class);
            createVm(vmData);
            return ResponseEntity.ok("VM adatok feldolgozva");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Hiba történt az adatok feldolgozása közben");
        }
    }

    @GetMapping("/simulationStatus")
    public ResponseEntity<String> simulationStatus() {
        String statusJson = "";
        return ResponseEntity.ok(statusJson);
    }

    private void createVm(VmData vmData) {
        List<VmInstance> vmInstances = vmData.getVmInstances();
        /*for (VmInstance vmInstance : vmInstances) {
            vmInstanceService.createVmInstance(vmInstance);
        }*/
        List<VmInstance> query = vmInstanceService.getAllVmInstances();
        for (VmInstance vmInstance : query) {
            System.out.println("asd");
            /*if (vmInstance.getId() != null) {
                vmInstanceService.deleteVmInstance(vmInstance.getId());
            }*/
            System.out.println(vmInstance.getId() + " " + vmInstance.getName());
        }
        // TO DO
    }
}

