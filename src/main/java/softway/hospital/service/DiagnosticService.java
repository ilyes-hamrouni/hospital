package softway.hospital.service;

import org.springframework.stereotype.Service;
import softway.hospital.model.Pathology;
import softway.hospital.service.implementations.CardiologyService;
import softway.hospital.service.implementations.TraumatologyService;
import java.util.ArrayList;
import java.util.List;

@Service
public class DiagnosticService {
    private final CardiologyService cardiologyService;
    private final TraumatologyService traumatologyService;

    public DiagnosticService(CardiologyService cardiologyService, TraumatologyService traumatologyService) {
        this.cardiologyService = cardiologyService;
        this.traumatologyService = traumatologyService;
    }

    public List<Pathology> detect(int index) {
        List<Pathology> result = new ArrayList<>();
        if (index % 3 == 0) {
            result.add(Pathology.CARDIOLOGY);
        }
        if (index % 5 == 0) {
            result.add(Pathology.TRAUMATOLOGY);
        }
        return result;
    }

    public List<Pathology> diagnose(int index) {
        List<Pathology> detected = detect(index);
        for (Pathology p : detected) {
            switch (p) {
                case CARDIOLOGY -> cardiologyService.treat(index);
                case TRAUMATOLOGY -> traumatologyService.treat(index);
            }
        }
        return detected;
    }
}