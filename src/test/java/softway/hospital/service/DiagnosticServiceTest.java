package softway.hospital.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import softway.hospital.model.Pathology;
import softway.hospital.service.implementations.CardiologyService;
import softway.hospital.service.implementations.TraumatologyService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

class DiagnosticServiceTest {
    @Test
    void detectReturnsCardiologyForMultiplesOf3() {
        DiagnosticService service = new DiagnosticService(new CardiologyService(), new TraumatologyService());
        assertEquals(List.of(Pathology.CARDIOLOGY), service.detect(33));
    }

    @Test
    void detectReturnsTraumatologyForMultiplesOf5() {
        DiagnosticService service = new DiagnosticService(new CardiologyService(), new TraumatologyService());
        assertEquals(List.of(Pathology.TRAUMATOLOGY), service.detect(55));
    }

    @Test
    void detectReturnsBothForMultiplesOf3And5() {
        DiagnosticService service = new DiagnosticService(new CardiologyService(), new TraumatologyService());
        assertEquals(List.of(Pathology.CARDIOLOGY, Pathology.TRAUMATOLOGY), service.detect(15));
    }

    @Test
    void detectReturnsEmptyWhenNoMatch() {
        DiagnosticService service = new DiagnosticService(new CardiologyService(), new TraumatologyService());
        assertEquals(List.of(), service.detect(7));
    }

    @Test
    void diagnoseInvokesTreatOnDetectedPathologies() {
        CardiologyService cardio = Mockito.mock(CardiologyService.class);
        TraumatologyService trauma = Mockito.mock(TraumatologyService.class);
        DiagnosticService service = new DiagnosticService(cardio, trauma);

        List<Pathology> treated = service.diagnose(15);
        assertEquals(List.of(Pathology.CARDIOLOGY, Pathology.TRAUMATOLOGY), treated);
        verify(cardio).treat(15);
        verify(trauma).treat(15);
    }
}