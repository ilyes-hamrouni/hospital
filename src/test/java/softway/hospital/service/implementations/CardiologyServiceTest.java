package softway.hospital.service.implementations;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CardiologyServiceTest {
    @Test
    void unitReturnsCardiologyLabel() {
        CardiologyService service = new CardiologyService();
        assertEquals("Cardiologie", service.unit());
    }
}