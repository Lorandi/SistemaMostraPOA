package com.rodrigolorandi.sistemamostrapoa.service;

import com.rodrigolorandi.sistemamostrapoa.dto.*;
import com.rodrigolorandi.sistemamostrapoa.entity.Voluntario;
import com.rodrigolorandi.sistemamostrapoa.entity.VoluntarioDisponibilidade;
import com.rodrigolorandi.sistemamostrapoa.helper.JsonUtils;
import com.rodrigolorandi.sistemamostrapoa.helper.MessageHelper;
import com.rodrigolorandi.sistemamostrapoa.repository.VoluntarioDisponibilidadeRepository;
import com.rodrigolorandi.sistemamostrapoa.repository.VoluntarioRepository;
import com.rodrigolorandi.sistemamostrapoa.repository.spec.VoluntarioSpecification;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.rodrigolorandi.sistemamostrapoa.exception.ErrorCodeEnum.ERRO_VOLUNTARIO_NAO_ENCONTRADO;
import static com.rodrigolorandi.sistemamostrapoa.util.mapper.MapperConstants.voluntarioMapper;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@Service
@RequiredArgsConstructor
public class VoluntarioService {
    private final VoluntarioRepository repository;
    private final MessageHelper messageHelper;
    private final VoluntarioDisponibilidadeRepository voluntarioDisponibilidadeRepository;
    private final DisponibilidadeHorarioService disponibilidadeHorarioService;

    public VoluntarioDTO create(final VoluntarioCreateDTO requestDTO) {
        Voluntario voluntario = repository.save(voluntarioMapper.buildEntity(requestDTO));
        JsonUtils.logObject(log, "Voluntario criado", voluntario);
        return voluntarioMapper.buildDTO(voluntario);
    }


    public VoluntarioDTO findDTOById(Long id) {
        Voluntario voluntario = findById(id);
        return voluntarioMapper.buildDTO(voluntario);
    }

    public Voluntario findById(final Long id) {
        return repository.findById(id).orElseThrow(() -> {
            log.error(messageHelper.get(ERRO_VOLUNTARIO_NAO_ENCONTRADO, id.toString()));
            return new ResponseStatusException(NOT_FOUND, messageHelper.get(ERRO_VOLUNTARIO_NAO_ENCONTRADO, id.toString()));
        });
    }

    public VoluntarioDTO update(final VoluntarioUpdateDTO updateDTO) {
        Voluntario voluntario = findById(updateDTO.id());
        VoluntarioDTO voluntarioDTO = voluntarioMapper.buildDTO(repository.save(voluntario
                .withName(updateDTO.name())
                .withEmail(updateDTO.email())
                .withPhone(updateDTO.phone())
                .withCpf(updateDTO.cpf())
                .withCourse(updateDTO.course())));
        JsonUtils.logObject(log, "Voluntario updated", voluntarioDTO);
        return voluntarioDTO;
    }

    public List<VoluntarioDTO> findAll(final Optional<String> name,
                                       Optional<String> email,
                                       Optional<String> cpf,
                                       Optional<String> phone,
                                       Optional<String> course) {
        return repository.findAll(VoluntarioSpecification.builder().name(name).email(email).cpf(cpf).phone(phone)
                        .course(course).build()).stream().map(voluntarioMapper::buildDTO)
                .sorted(Comparator.comparing(VoluntarioDTO::id))
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(final Long id) {
        Voluntario voluntario = findById(id);
        voluntarioDisponibilidadeRepository.deleteAllByVoluntarioId(id);
        repository.delete(voluntario);
        JsonUtils.logObject(log, "Voluntario deleted:", voluntario);
    }

    @Transactional
    public VoluntarioDisponibilidadeDTO create(VoluntarioDisponibilidadeCreateDTO requestDTO) {
        Long voluntarioId = requestDTO.voluntarioId();
        findById(voluntarioId);
        voluntarioDisponibilidadeRepository.deleteAllByVoluntarioId(voluntarioId);

        List<DisponibilidadeHorarioDTO> disponibilidadeHorarioDTO = new ArrayList<>();
        requestDTO.disponibilidadeHorarioId().forEach(disponibilidadeId -> {
            disponibilidadeHorarioDTO.add(disponibilidadeHorarioService.findDTOById(disponibilidadeId));
            voluntarioDisponibilidadeRepository.save(VoluntarioDisponibilidade.builder()
                    .voluntarioId(voluntarioId)
                    .disponibilidadeHorarioId(disponibilidadeId)
                    .build());
        });

        return VoluntarioDisponibilidadeDTO.builder()
                .voluntarioId(voluntarioId)
                .disponibilidadeHorarios(disponibilidadeHorarioDTO)
                .build();
    }

    public VoluntarioDisponibilidadeDTO findByVoluntarioId(Long voluntarioId) {
        findById(voluntarioId);

        List<VoluntarioDisponibilidade> voluntarioDisponibilidades = voluntarioDisponibilidadeRepository.findByVoluntarioId(voluntarioId);

        return VoluntarioDisponibilidadeDTO.builder()
                .voluntarioId(voluntarioId)
                .disponibilidadeHorarios(voluntarioDisponibilidades.stream()
                        .map(voluntarioDisponibilidade -> disponibilidadeHorarioService.findDTOById(voluntarioDisponibilidade
                                .getDisponibilidadeHorarioId()))
                        .collect(Collectors.toList()))
                .build();
    }

}