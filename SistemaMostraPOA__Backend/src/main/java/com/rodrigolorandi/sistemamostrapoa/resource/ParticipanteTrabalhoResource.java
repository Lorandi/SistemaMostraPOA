package com.rodrigolorandi.sistemamostrapoa.resource;

import com.rodrigolorandi.sistemamostrapoa.dto.ParticipanteTrabalhoCreateDTO;
import com.rodrigolorandi.sistemamostrapoa.dto.ParticipanteTrabalhoDTO;
import com.rodrigolorandi.sistemamostrapoa.dto.ParticipanteTrabalhoUpdateDTO;
import com.rodrigolorandi.sistemamostrapoa.enums.TipoParticipanteTrabalhoEnum;
import com.rodrigolorandi.sistemamostrapoa.service.ParticipanteTrabalhoService;
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
@RequestMapping("/participanteTrabalho")
@RequiredArgsConstructor
@Tag(name = "ParticipanteTrabalho")
public class ParticipanteTrabalhoResource {

    private final ParticipanteTrabalhoService service;

    @GetMapping("/{id}")
    @Operation(summary = "Search ParticipanteTrabalho by id",
            responses = {@ApiResponse(responseCode = "200", description = "Resource successfully retrieved",
                    content = @Content(schema = @Schema(implementation = ParticipanteTrabalhoDTO.class)))})
    public ParticipanteTrabalhoDTO findById(@Valid @PathVariable Long id) {
        return service.findDTOById(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    @Operation(summary = "Create participanteTrabalho",
            responses = {@ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = ParticipanteTrabalhoDTO.class)))})
    public ParticipanteTrabalhoDTO create(@Valid @RequestBody ParticipanteTrabalhoCreateDTO requestDTO) {
        return service.create(requestDTO);
    }

    @PutMapping
    @Operation(summary = "Update ParticipanteTrabalho by id",
            responses = {@ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = ParticipanteTrabalhoDTO.class)))})
    public ParticipanteTrabalhoDTO update(@Valid @RequestBody ParticipanteTrabalhoUpdateDTO updateDTO) {
        return service.update(updateDTO);
    }

    @GetMapping
    @Operation(summary = "Find all ParticipanteTrabalhos",
            responses = {@ApiResponse(responseCode = "200",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = ParticipanteTrabalhoDTO.class))))})
    public List<ParticipanteTrabalhoDTO> findAll(@RequestParam(required = false) Optional<String> name,
                                    @RequestParam(required = false) Optional<String> email,
                                    @RequestParam(required = false) Optional<String> cpf,
                                    @RequestParam(required = false) Optional<String> phone,
                                    @RequestParam(required = false) Optional<List<TipoParticipanteTrabalhoEnum>> tipoParticipante,
                                    @RequestParam(required = false) Optional<List<Long>> trabalhoId)
    {
        return service.findAll(name, email, cpf, phone, tipoParticipante, trabalhoId);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete ParticipanteTrabalho by id",
            responses = {@ApiResponse(responseCode = "204", description = "ParticipanteTrabalho successfully deleted")})
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
