package softway.hospital.service.implementations;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TraumatologyServiceTest {
    @Test
    void unitsReturnTraumatologyLabel() {
        TraumatologyService service = new TraumatologyService();
        assertEquals("Traumatologie", service.unit());
    }
}