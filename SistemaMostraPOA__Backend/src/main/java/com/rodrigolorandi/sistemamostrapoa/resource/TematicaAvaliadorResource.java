package com.rodrigolorandi.sistemamostrapoa.resource;

import com.rodrigolorandi.sistemamostrapoa.dto.TematicaAvaliadorCreateDTO;
import com.rodrigolorandi.sistemamostrapoa.dto.TematicasAvaliadorDTO;
import com.rodrigolorandi.sistemamostrapoa.service.TematicaAvaliadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@Slf4j
@RestController
@RequestMapping("/tematica-avaliador")
@RequiredArgsConstructor
@Tag(name = "Tematica do Avaliador")
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
    @Operation(summary = "Create Temática do Avaliador",
            responses = {@ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = TematicasAvaliadorDTO.class)))})
    public TematicasAvaliadorDTO create(@Valid @RequestBody TematicaAvaliadorCreateDTO requestDTO) {
        return service.create(requestDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete TematicaAvaliador by id",
            responses = {@ApiResponse(responseCode = "204", description = "TematicaAvaliador successfully deleted")})
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }


}
