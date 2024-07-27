package com.rodrigolorandi.sistemamostrapoa.resource;

import com.rodrigolorandi.sistemamostrapoa.dto.OuvinteCreateDTO;
import com.rodrigolorandi.sistemamostrapoa.dto.OuvinteDTO;
import com.rodrigolorandi.sistemamostrapoa.dto.OuvinteUpdateDTO;
import com.rodrigolorandi.sistemamostrapoa.service.OuvinteService;
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
@RequestMapping("/ouvinte")
@RequiredArgsConstructor
public class OuvinteResource {

    private final OuvinteService service;

    @GetMapping("/{id}")
    @Operation(summary = "Search Ouvinte by id",
            responses = {@ApiResponse(responseCode = "200", description = "Resource successfully retrieved",
                    content = @Content(schema = @Schema(implementation = OuvinteDTO.class)))})
    public OuvinteDTO findById(@Valid @PathVariable Long id) {
        return service.findDTOById(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    @Operation(summary = "Create ouvinte",
            responses = {@ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = OuvinteDTO.class)))})
    public OuvinteDTO create(@Valid @RequestBody OuvinteCreateDTO requestDTO) {
        return service.create(requestDTO);
    }

    @PutMapping
    @Operation(summary = "Update Ouvinte by id",
            responses = {@ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = OuvinteDTO.class)))})
    public OuvinteDTO update(@Valid @RequestBody OuvinteUpdateDTO updateDTO) {
        return service.update(updateDTO);
    }

    @GetMapping
    @Operation(summary = "Find all Ouvintes",
            responses = {@ApiResponse(responseCode = "200",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = OuvinteDTO.class))))})
    public List<OuvinteDTO> findAll(@RequestParam(required = false) Optional<String> name,
                                    @RequestParam(required = false) Optional<String> email,
                                    @RequestParam(required = false) Optional<String> cpf,
                                    @RequestParam(required = false) Optional<String> phone){
        return service.findAll(name, email, cpf, phone);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Ouvinte by id",
            responses = {@ApiResponse(responseCode = "204", description = "Elector successfully deleted")})
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
