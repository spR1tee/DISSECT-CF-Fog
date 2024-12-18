package hu.u_szeged.inf.fog.simulator.spring;

import com.fasterxml.jackson.databind.ObjectMapper;
import hu.mta.sztaki.lpds.cloud.simulator.iaas.VMManager;
import hu.mta.sztaki.lpds.cloud.simulator.io.NetworkNode;
import hu.u_szeged.inf.fog.simulator.spring.model.VmData;
import hu.u_szeged.inf.fog.simulator.spring.service.SimulatorService;
import hu.u_szeged.inf.fog.simulator.spring.service.VmInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/simulator")
public class SimulatorController {

    @Autowired
    private SimulatorService simulatorService;
    @Autowired
    private VmInstanceService vmInstanceService;

    @PostMapping("/request")
    public ResponseEntity<String> request(@RequestBody String jsonContent) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            VmData vmData = objectMapper.readValue(jsonContent, VmData.class);
            simulatorService.handleRequest(vmData);
            return ResponseEntity.ok("Data has been processed.");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error while processing data.");
        } catch (VMManager.VMManagementException | NetworkNode.NetworkException e) {
            throw new RuntimeException(e);
        }
    }
}

