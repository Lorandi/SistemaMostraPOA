package com.rodrigolorandi.sistemamostrapoa.service;

import com.rodrigolorandi.sistemamostrapoa.dto.TrabalhoCreateDTO;
import com.rodrigolorandi.sistemamostrapoa.dto.TrabalhoDTO;
import com.rodrigolorandi.sistemamostrapoa.dto.TrabalhoUpdateDTO;
import com.rodrigolorandi.sistemamostrapoa.entity.Trabalho;
import com.rodrigolorandi.sistemamostrapoa.enums.ApresentacaoEnum;
import com.rodrigolorandi.sistemamostrapoa.enums.TematicasEnum;
import com.rodrigolorandi.sistemamostrapoa.helper.JsonUtils;
import com.rodrigolorandi.sistemamostrapoa.helper.MessageHelper;
import com.rodrigolorandi.sistemamostrapoa.repository.TrabalhoRepository;
import com.rodrigolorandi.sistemamostrapoa.repository.spec.TrabalhoSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.rodrigolorandi.sistemamostrapoa.exception.ErrorCodeEnum.ERRO_TRABALHO_NAO_ENCONTRADO;
import static com.rodrigolorandi.sistemamostrapoa.util.mapper.MapperConstants.trabalhoMapper;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@Service
@RequiredArgsConstructor
public class TrabalhoService {
    private final TrabalhoRepository repository;
    private final MessageHelper messageHelper;

    public TrabalhoDTO create(final TrabalhoCreateDTO requestDTO) {
        Trabalho Trabalho = repository.save(trabalhoMapper.buildEntity(requestDTO));
        JsonUtils.logObject(log, "Trabalho criado", Trabalho);
        return trabalhoMapper.buildDTO(Trabalho);
    }


    public TrabalhoDTO findDTOById(Long id) {
        Trabalho trabalho = findById(id);
        return trabalhoMapper.buildDTO(trabalho);
    }

    public Trabalho findById(final Long id) {
        return repository.findById(id).orElseThrow(() -> {
            log.error(messageHelper.get(ERRO_TRABALHO_NAO_ENCONTRADO, id.toString()));
            return new ResponseStatusException(NOT_FOUND, messageHelper.get(ERRO_TRABALHO_NAO_ENCONTRADO, id.toString()));
        });
    }

    public TrabalhoDTO update(final TrabalhoUpdateDTO updateDTO) {
        Trabalho trabalho = findById(updateDTO.id());
        TrabalhoDTO trabalhoDTO = trabalhoMapper.buildDTO(repository.save(trabalho
                .withTitulo(updateDTO.titulo())
                .withApresentacao(updateDTO.apresentacao())
                .withTematica(updateDTO.tematica())
                .withObservacao(updateDTO.observacao())
                .withLinkResumo(updateDTO.linkResumo())
                .withAceite(updateDTO.aceite())));
        JsonUtils.logObject(log, "Trabalho updated", trabalhoDTO);
        return trabalhoDTO;
    }

    public List<TrabalhoDTO> findAll(final Optional<String> titulo,
                                     Optional<List<ApresentacaoEnum>> apresentacao,
                                     Optional<List<TematicasEnum>> tematica,
                                     Optional<String> observacao) {
        return repository.findAll(TrabalhoSpecification.builder().titulo(titulo).apresentacao(apresentacao)
                        .tematica(tematica).observacao(observacao).build()).stream().map(trabalhoMapper::buildDTO)
                .sorted(Comparator.comparing(TrabalhoDTO::id))
                .collect(Collectors.toList());
    }

    public void delete(final Long id) {
        Trabalho trabalho = findById(id);
        repository.delete(trabalho);
        JsonUtils.logObject(log, "Trabalho deleted:", trabalho);
    }
}