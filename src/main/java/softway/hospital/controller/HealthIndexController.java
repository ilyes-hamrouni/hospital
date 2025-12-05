package softway.hospital.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import softway.hospital.service.DiagnosticService;
import softway.hospital.model.Pathology;
import jakarta.validation.constraints.Min;
import io.swagger.v3.oas.annotations.media.Content;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/diagnostic")
@org.springframework.validation.annotation.Validated
public class HealthIndexController {
    private final DiagnosticService diagnosticService;

    public HealthIndexController(DiagnosticService diagnosticService) {
        this.diagnosticService = diagnosticService;
    }

    @Operation(
            summary = "Calcule et traite les pathologies détectées",
            description = "Retourne la liste des pathologies traitées en fonction de l'index de santé",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "400", description = "Requête invalide", content = @Content(mediaType = "application/json"))
            }
    )
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Pathology>> diagnostic(@Parameter(description = "Index de santé du patient") @RequestParam @Min(0) int index) {
        return ResponseEntity.ok(diagnosticService.diagnose(index));
    }
}