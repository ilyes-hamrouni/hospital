package softway.hospital.service.implementations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import softway.hospital.model.Pathology;
import softway.hospital.service.PathologyService;

@Service
public class TraumatologyService implements PathologyService {
    private static final Logger log = LoggerFactory.getLogger(TraumatologyService.class);

    public String unit() {
        return Pathology.TRAUMATOLOGY.getLabel();
    }

    @Override
    public void treat(int index) {
        log.info("Treating traumatology for index {}", index);
    }
}