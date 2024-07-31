package com.rodrigolorandi.sistemamostrapoa.resource;

import com.rodrigolorandi.sistemamostrapoa.dto.*;
import com.rodrigolorandi.sistemamostrapoa.service.TematicaAvaliadorService;
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
@RequestMapping("/tematica-avaliador")
@RequiredArgsConstructor
public class TematicaAvaliadorResource {

    private final TematicaAvaliadorService service;

    @GetMapping("/{avaliadorId}")
    @Operation(summary = "Search by AvaliadorId",
            responses = {@ApiResponse(responseCode = "200", description = "Resource successfully retrieved",
                    content = @Content(schema = @Schema(implementation = TematicasAvaliadorDTO.class)))})
    public TematicasAvaliadorDTO findById(@Valid @PathVariable Long avaliadorId) {
        return service.findDTOByAvaliadorId(avaliadorId);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    @Operation(summary = "Create avaliador",
            responses = {@ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = TematicasAvaliadorDTO.class)))})
    public TematicasAvaliadorDTO create(@Valid @RequestBody TematicaAvaliadorCreateDTO requestDTO) {
        return service.create(requestDTO);
    }


}
