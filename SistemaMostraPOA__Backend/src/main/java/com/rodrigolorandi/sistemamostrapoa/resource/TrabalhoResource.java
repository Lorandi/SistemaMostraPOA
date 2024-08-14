package com.rodrigolorandi.sistemamostrapoa.resource;

import com.rodrigolorandi.sistemamostrapoa.dto.TrabalhoCreateDTO;
import com.rodrigolorandi.sistemamostrapoa.dto.TrabalhoDTO;
import com.rodrigolorandi.sistemamostrapoa.dto.TrabalhoUpdateDTO;
import com.rodrigolorandi.sistemamostrapoa.enums.ApresentacaoEnum;
import com.rodrigolorandi.sistemamostrapoa.enums.TematicasEnum;
import com.rodrigolorandi.sistemamostrapoa.service.TrabalhoService;
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
@RequestMapping("/trabalho")
@RequiredArgsConstructor
@Tag(name = "Trabalho")
public class TrabalhoResource {

    private final TrabalhoService service;

    @GetMapping("/{id}")
    @Operation(summary = "Search Trabalho by id",
            responses = {@ApiResponse(responseCode = "200", description = "Resource successfully retrieved",
                    content = @Content(schema = @Schema(implementation = TrabalhoDTO.class)))})
    public TrabalhoDTO findById(@Valid @PathVariable Long id) {
        return service.findDTOById(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    @Operation(summary = "Create Trabalho",
            responses = {@ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = TrabalhoDTO.class)))})
    public TrabalhoDTO create(@Valid @RequestBody TrabalhoCreateDTO requestDTO) {
        return service.create(requestDTO);
    }

    @PutMapping
    @Operation(summary = "Update Trabalho by id",
            responses = {@ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = TrabalhoDTO.class)))})
    public TrabalhoDTO update(@Valid @RequestBody TrabalhoUpdateDTO updateDTO) {
        return service.update(updateDTO);
    }

    @GetMapping
    @Operation(summary = "Find all Trabalhos",
            responses = {@ApiResponse(responseCode = "200",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = TrabalhoDTO.class))))})
    public List<TrabalhoDTO> findAll(@RequestParam(required = false) Optional<String> titulo,
                                      @RequestParam(required = false) Optional<List<ApresentacaoEnum>> apresentacao,
                                      @RequestParam(required = false) Optional<List<TematicasEnum>> tematica,
                                      @RequestParam(required = false)  Optional<String> observacao) {
        return service.findAll(titulo, apresentacao, tematica, observacao);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Trabalho by id",
            responses = {@ApiResponse(responseCode = "204", description = "Trabalho successfully deleted")})
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
