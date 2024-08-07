package com.rodrigolorandi.sistemamostrapoa.resource;

import com.rodrigolorandi.sistemamostrapoa.dto.DisponibilidadeHorarioCreateDTO;
import com.rodrigolorandi.sistemamostrapoa.dto.DisponibilidadeHorarioDTO;
import com.rodrigolorandi.sistemamostrapoa.service.DisponibilidadeHorarioService;
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

import static org.springframework.http.HttpStatus.CREATED;

@Slf4j
@RestController
@RequestMapping("/disponibilidade_horario")
@RequiredArgsConstructor
@Tag(name = "Disponibilidade Horário")
public class DisponibilidadeHorarioResource {

    private final DisponibilidadeHorarioService service;

    @GetMapping("/{id}")
    @Operation(summary = "Search DisponibilidadeHorario by id",
            responses = {@ApiResponse(responseCode = "200", description = "Resource successfully retrieved",
                    content = @Content(schema = @Schema(implementation = DisponibilidadeHorarioDTO.class)))})
    public DisponibilidadeHorarioDTO findById(@Valid @PathVariable Long id) {
        return service.findDTOById(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    @Operation(summary = "Create disponibilidadeHorario",
            responses = {@ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = DisponibilidadeHorarioDTO.class)))})
    public DisponibilidadeHorarioDTO create(@Valid @RequestBody DisponibilidadeHorarioCreateDTO requestDTO) {
        return service.create(requestDTO);
    }

    @GetMapping
    @Operation(summary = "Find all Disponibilidade de Horários",
            responses = {@ApiResponse(responseCode = "200",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = DisponibilidadeHorarioDTO.class))))})
    public List<DisponibilidadeHorarioDTO> findAll(){
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete DisponibilidadeHorario by id",
            responses = {@ApiResponse(responseCode = "204", description = "DisponibilidadeHorario successfully deleted")})
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
