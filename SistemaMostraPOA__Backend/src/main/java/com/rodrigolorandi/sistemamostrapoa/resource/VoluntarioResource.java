package com.rodrigolorandi.sistemamostrapoa.resource;

import com.rodrigolorandi.sistemamostrapoa.dto.*;
import com.rodrigolorandi.sistemamostrapoa.service.VoluntarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@Slf4j
@RestController
@RequestMapping("/voluntario")
@RequiredArgsConstructor
@Tag(name = "Voluntario")
public class VoluntarioResource {

    private final VoluntarioService service;

    @GetMapping("/{id}")
    @Operation(summary = "Search Voluntario by id",
            responses = {@ApiResponse(responseCode = "200", description = "Resource successfully retrieved",
                    content = @Content(schema = @Schema(implementation = VoluntarioDTO.class)))})
    public VoluntarioDTO findById(@Valid @PathVariable Long id) {
        return service.findDTOById(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    @Operation(summary = "Create voluntario",
            responses = {@ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = VoluntarioDTO.class)))})
    public VoluntarioDTO create(@Valid @RequestBody VoluntarioCreateDTO requestDTO) {
        return service.create(requestDTO);
    }

    @PutMapping
    @Operation(summary = "Update Voluntario by id",
            responses = {@ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = VoluntarioDTO.class)))})
    public VoluntarioDTO update(@Valid @RequestBody VoluntarioUpdateDTO updateDTO) {
        return service.update(updateDTO);
    }

    @GetMapping
    @Operation(summary = "Find all Voluntarios",
            responses = {@ApiResponse(responseCode = "200",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = VoluntarioDTO.class))))})
    public List<VoluntarioDTO> findAll(@RequestParam(required = false) Optional<String> name,
                                      @RequestParam(required = false) Optional<String> email,
                                      @RequestParam(required = false) Optional<String> cpf,
                                      @RequestParam(required = false) Optional<String> phone,
                                      @RequestParam(required = false) Optional<String> course) {
        return service.findAll(name, email, cpf, phone, course);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Voluntario by id",
            responses = {@ApiResponse(responseCode = "204", description = "Voluntario successfully deleted")})
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PostMapping("/disponibilidade")
    @ResponseStatus(CREATED)
    @Operation(summary = "Create voluntario",
            responses = {@ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = VoluntarioDisponibilidadeDTO.class)))})
    public VoluntarioDisponibilidadeDTO create(@Valid @RequestBody VoluntarioDisponibilidadeCreateDTO requestDTO) {
        return service.create(requestDTO);
    }

    @GetMapping("disponibilidade/{voluntarioId}")
    @Operation(summary = "Search Voluntario Disponibilidade by voluntarioId",
            responses = {@ApiResponse(responseCode = "200", description = "Resource successfully retrieved",
                    content = @Content(schema = @Schema(implementation = VoluntarioDisponibilidadeDTO.class)))})
    public VoluntarioDisponibilidadeDTO findDisponibilidadeByVoluntarioId(@Valid @PathVariable Long voluntarioId) {
        return service.findByVoluntarioId(voluntarioId);
    }
}
