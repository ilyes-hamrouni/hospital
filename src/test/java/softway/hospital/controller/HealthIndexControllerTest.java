package softway.hospital.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import softway.hospital.exception.GlobalExceptionHandler;
import softway.hospital.service.DiagnosticService;
import softway.hospital.service.implementations.CardiologyService;
import softway.hospital.service.implementations.TraumatologyService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class HealthIndexControllerTest {
    private MockMvc buildMockMvc(DiagnosticService diagnosticService) {
        HealthIndexController controller = new HealthIndexController(diagnosticService);
        org.springframework.validation.beanvalidation.LocalValidatorFactoryBean validator = new org.springframework.validation.beanvalidation.LocalValidatorFactoryBean();
        return MockMvcBuilders.standaloneSetup(controller)
                .setControllerAdvice(new GlobalExceptionHandler())
                .setValidator(validator)
                .build();
    }

    @Test
    void returnsJsonListFromController() throws Exception {
        DiagnosticService diagnosticService = new DiagnosticService(new CardiologyService(), new TraumatologyService());
        MockMvc mockMvc = buildMockMvc(diagnosticService);
        mockMvc.perform(get("/api/v1/diagnostic").param("index", "15").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void negativeIndexReturnsOkWithoutBootValidation() throws Exception {
        DiagnosticService diagnosticService = new DiagnosticService(new CardiologyService(), new TraumatologyService());
        MockMvc mockMvc = buildMockMvc(diagnosticService);
        mockMvc.perform(get("/api/v1/diagnostic").param("index", "-1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}