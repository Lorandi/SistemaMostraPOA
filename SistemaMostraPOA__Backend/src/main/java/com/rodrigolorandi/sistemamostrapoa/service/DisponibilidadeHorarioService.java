package com.rodrigolorandi.sistemamostrapoa.service;

import com.rodrigolorandi.sistemamostrapoa.dto.DisponibilidadeHorarioCreateDTO;
import com.rodrigolorandi.sistemamostrapoa.dto.DisponibilidadeHorarioDTO;
import com.rodrigolorandi.sistemamostrapoa.entity.DisponibilidadeHorario;
import com.rodrigolorandi.sistemamostrapoa.helper.JsonUtils;
import com.rodrigolorandi.sistemamostrapoa.helper.MessageHelper;
import com.rodrigolorandi.sistemamostrapoa.repository.DisponibilidadeHorarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

import static com.rodrigolorandi.sistemamostrapoa.exception.ErrorCodeEnum.ERRO_DISPONIBILIDADE_DE_HORARIO_JA_EXISTENTE;
import static com.rodrigolorandi.sistemamostrapoa.exception.ErrorCodeEnum.ERRO_DISPONIBILIDADE_DE_HORARIO_NAO_ENCONTRADA;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static com.rodrigolorandi.sistemamostrapoa.util.mapper.MapperConstants.disponibilidadeHorarioMapper;


@Slf4j
@Service
@RequiredArgsConstructor
public class DisponibilidadeHorarioService {
    private final DisponibilidadeHorarioRepository repository;
    private final MessageHelper messageHelper;

    @Transactional
    public DisponibilidadeHorarioDTO create(final DisponibilidadeHorarioCreateDTO requestDTO) {

        repository.findByDataAndTurno(requestDTO.data(), requestDTO.turno())
                .ifPresent(dh -> {
                    log.error(messageHelper.get(ERRO_DISPONIBILIDADE_DE_HORARIO_JA_EXISTENTE, requestDTO.data().toString(), requestDTO.turno()));
                    throw new ResponseStatusException(NOT_FOUND, messageHelper.get(ERRO_DISPONIBILIDADE_DE_HORARIO_JA_EXISTENTE, requestDTO.data().toString(), requestDTO.turno()));
                });

        DisponibilidadeHorario dh = DisponibilidadeHorario.builder()
                .data(requestDTO.data())
                .diaSemana(requestDTO.data().getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("pt", "BR")))
                .turno(requestDTO.turno())
                .build();

        JsonUtils.logObject(log, "Disponibilidade de Horário criada", dh);
        repository.save(dh);

        return disponibilidadeHorarioMapper.buildDTO(dh);
    }

    public List<DisponibilidadeHorarioDTO> findAll() {
        return repository.findAll().stream()
                .map(disponibilidadeHorarioMapper::buildDTO)
                .toList();
    }

    public DisponibilidadeHorarioDTO findDTOById(Long id) {
        DisponibilidadeHorario dh = findById(id);
        return disponibilidadeHorarioMapper.buildDTO(dh);
    }

    public DisponibilidadeHorario findById(final Long id) {
        return repository.findById(id).orElseThrow(() -> {
            log.error(messageHelper.get(ERRO_DISPONIBILIDADE_DE_HORARIO_NAO_ENCONTRADA, id.toString()));
            return new ResponseStatusException(NOT_FOUND, messageHelper.get(ERRO_DISPONIBILIDADE_DE_HORARIO_NAO_ENCONTRADA, id.toString()));
        });
    }

    public void deleteById(final Long id) {
        findById(id);
        repository.deleteById(id);
    }



}