package com.rodrigolorandi.sistemamostrapoa.resource;

import com.rodrigolorandi.sistemamostrapoa.dto.AvaliadorCreateDTO;
import com.rodrigolorandi.sistemamostrapoa.dto.AvaliadorDTO;
import com.rodrigolorandi.sistemamostrapoa.dto.AvaliadorUpdateDTO;
import com.rodrigolorandi.sistemamostrapoa.service.AvaliadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@Slf4j
@RestController
@RequestMapping("/avaliador")
@RequiredArgsConstructor
public class AvaliadorResource {

    private final AvaliadorService service;

    @GetMapping("/{id}")
    @Operation(summary = "Search Avaliador by id",
            responses = {@ApiResponse(responseCode = "200", description = "Resource successfully retrieved",
                    content = @Content(schema = @Schema(implementation = AvaliadorDTO.class)))})
    public AvaliadorDTO findById(@Valid @PathVariable Long id) {
        return service.findDTOById(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    @Operation(summary = "Create avaliador",
            responses = {@ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = AvaliadorDTO.class)))})
    public AvaliadorDTO create(@Valid @RequestBody AvaliadorCreateDTO requestDTO) {
        return service.create(requestDTO);
    }

    @PutMapping
    @Operation(summary = "Update Avaliador by id",
            responses = {@ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = AvaliadorDTO.class)))})
    public AvaliadorDTO update(@Valid @RequestBody AvaliadorUpdateDTO updateDTO) {
        return service.update(updateDTO);
    }

    @GetMapping
    @Operation(summary = "Find all Avaliadors",
            responses = {@ApiResponse(responseCode = "200",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = AvaliadorDTO.class))))})
    public List<AvaliadorDTO> findAll(@RequestParam(required = false) Optional<String> name,
                                      @RequestParam(required = false) Optional<String> email,
                                      @RequestParam(required = false) Optional<String> cpf,
                                      @RequestParam(required = false) Optional<String> phone,
                                      @RequestParam(required = false) Optional<String> institutionalAffiliation) {
        return service.findAll(name, email, cpf, phone, institutionalAffiliation);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Avaliador by id",
            responses = {@ApiResponse(responseCode = "204", description = "Elector successfully deleted")})
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
