package com.rodrigolorandi.sistemamostrapoa.service;

import com.rodrigolorandi.sistemamostrapoa.dto.TematicaAvaliadorCreateDTO;
import com.rodrigolorandi.sistemamostrapoa.dto.TematicasAvaliadorDTO;
import com.rodrigolorandi.sistemamostrapoa.entity.TematicaAvaliador;
import com.rodrigolorandi.sistemamostrapoa.helper.JsonUtils;
import com.rodrigolorandi.sistemamostrapoa.helper.MessageHelper;
import com.rodrigolorandi.sistemamostrapoa.repository.TematicaAvaliadorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static com.rodrigolorandi.sistemamostrapoa.exception.ErrorCodeEnum.ERRO_AVALIADOR_NAO_ENCONTRADO;
import static com.rodrigolorandi.sistemamostrapoa.exception.ErrorCodeEnum.ERRO_TEMATICA_AVALIADOR_NAO_ENCONTRADA;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@Service
@RequiredArgsConstructor
public class TematicaAvaliadorService {
    private final TematicaAvaliadorRepository repository;
    private final MessageHelper messageHelper;
    private final AvaliadorService avaliadorService;

    @Transactional
    public TematicasAvaliadorDTO create(final TematicaAvaliadorCreateDTO requestDTO) {
        avaliadorService.findById(requestDTO.avaliadorId());

        repository.deleteAllByAvaliadorId(requestDTO.avaliadorId());

        requestDTO.tematica().forEach(tematica -> repository.save(TematicaAvaliador.builder()
                .avaliadorId(requestDTO.avaliadorId())
                .tematica(tematica).build()));

        TematicasAvaliadorDTO ta = TematicasAvaliadorDTO.builder().avaliadorId(requestDTO.avaliadorId())
                .tematicas(requestDTO.tematica()).build();

        JsonUtils.logObject(log, "TematicasAvaliador criada", ta);
        return ta;
    }


    public TematicasAvaliadorDTO findDTOByAvaliadorId(Long id) {
        List<TematicaAvaliador> list = repository.findAllByAvaliadorId(id);

        if(list.isEmpty()) {
            log.error(messageHelper.get(ERRO_AVALIADOR_NAO_ENCONTRADO, id.toString()));
            throw new ResponseStatusException(NOT_FOUND, messageHelper.get(ERRO_AVALIADOR_NAO_ENCONTRADO, id.toString()));
        }

        return TematicasAvaliadorDTO.builder().avaliadorId(id)
                .tematicas(list.stream().map(TematicaAvaliador::getTematica).toList()).build();
    }

    public void findById(final Long id) {
        repository.findById(id).orElseThrow(() -> {
            log.error(messageHelper.get(ERRO_TEMATICA_AVALIADOR_NAO_ENCONTRADA, id.toString()));
            return new ResponseStatusException(NOT_FOUND, messageHelper.get(ERRO_TEMATICA_AVALIADOR_NAO_ENCONTRADA, id.toString()));
        });
    }

    public void deleteById (final Long id) {
        findById(id);
        repository.deleteById(id);
    }
}