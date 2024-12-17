package hu.u_szeged.inf.fog.simulator.spring.service;

import hu.mta.sztaki.lpds.cloud.simulator.iaas.constraints.AlterableResourceConstraints;
import hu.mta.sztaki.lpds.cloud.simulator.io.VirtualAppliance;
import hu.u_szeged.inf.fog.simulator.provider.Instance;
import hu.u_szeged.inf.fog.simulator.spring.model.VmData;
import hu.u_szeged.inf.fog.simulator.spring.model.VmInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class SimulatorService {

    @Autowired
    private VmInstanceService vmInstanceService;

    private final List<VirtualAppliance> virtualAppliances = new ArrayList<>();
    private final List<Instance> instances = new ArrayList<>();
    private final RestTemplate restTemplate = new RestTemplate();
    private final HttpHeaders headers = new HttpHeaders();
    private int counter = 0;

    public String sendData(String data, String url) {

        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(data, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        return response.getBody();
    }

    public void handleRequest(VmData vmData) {
        String request_type = vmData.getRequestType().toUpperCase();
        if (request_type.equals("UPDATE")) {
            if (Instance.allInstances.isEmpty()) {
                for (VmInstance vmInstance : vmData.getVmInstances()) {
                    virtualAppliances.add(new VirtualAppliance("va" + counter, vmInstance.getStartupProcess(),0, false, vmInstance.getReqDisk()));
                    AlterableResourceConstraints arc = new AlterableResourceConstraints(vmInstance.getCpu(), vmInstance.getCoreProcessingPower(), vmInstance.getRam());
                    instances.add(new Instance("instance" + counter, virtualAppliances.get(counter), arc, vmInstance.getPricePerTick() / 60 / 60 / 1000));
                    counter++;
                }
            } else {
                // TO DO update the values of the instances if needed
                for (Instance instance : instances) {
                    System.out.println(instance);
                }
            }
        } else if (request_type.equals("REQUEST PREDICTION")) {
            // TO DO call prediction functions
        } else if (request_type.equals("REQUEST FUTURE BEHAVIOR")) {
            //TO DO
        } else {
            System.err.println("Error: Unknown Request Type");
        }
    }
}

