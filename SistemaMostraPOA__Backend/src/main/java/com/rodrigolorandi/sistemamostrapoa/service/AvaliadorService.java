package com.rodrigolorandi.sistemamostrapoa.service;

import com.rodrigolorandi.sistemamostrapoa.dto.AvaliadorCreateDTO;
import com.rodrigolorandi.sistemamostrapoa.dto.AvaliadorDTO;
import com.rodrigolorandi.sistemamostrapoa.dto.AvaliadorUpdateDTO;
import com.rodrigolorandi.sistemamostrapoa.entity.Avaliador;
import com.rodrigolorandi.sistemamostrapoa.helper.JsonUtils;
import com.rodrigolorandi.sistemamostrapoa.helper.MessageHelper;
import com.rodrigolorandi.sistemamostrapoa.repository.AvaliadorRepository;
import com.rodrigolorandi.sistemamostrapoa.repository.spec.AvaliadorSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.rodrigolorandi.sistemamostrapoa.exception.ErrorCodeEnum.ERRO_AVALIADOR_NAO_ENCONTRADO;
import static com.rodrigolorandi.sistemamostrapoa.util.mapper.MapperConstants.avaliadorMapper;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@Service
@RequiredArgsConstructor
public class AvaliadorService {
    private final AvaliadorRepository repository;
    private final MessageHelper messageHelper;

    public AvaliadorDTO create(final AvaliadorCreateDTO requestDTO) {
        Avaliador avaliador = repository.save(avaliadorMapper.buildEntity(requestDTO));
        JsonUtils.logObject(log, "Avaliador criado", avaliador);
        return avaliadorMapper.buildDTO(avaliador);
    }


    public AvaliadorDTO findDTOById(Long id) {
        Avaliador avaliador = findById(id);
        return avaliadorMapper.buildDTO(avaliador);
    }

    public Avaliador findById(final Long id) {
        return repository.findById(id).orElseThrow(() -> {
            log.error(messageHelper.get(ERRO_AVALIADOR_NAO_ENCONTRADO, id.toString()));
            return new ResponseStatusException(NOT_FOUND, messageHelper.get(ERRO_AVALIADOR_NAO_ENCONTRADO, id.toString()));
        });
    }

    public AvaliadorDTO update(final AvaliadorUpdateDTO updateDTO) {
        Avaliador avaliador = findById(updateDTO.id());
        AvaliadorDTO avaliadorDTO = avaliadorMapper.buildDTO(repository.save(avaliador
                .withName(updateDTO.name())
                .withEmail(updateDTO.email())
                .withPhone(updateDTO.phone())
                .withCpf(updateDTO.cpf())
                .withInstitutionalAffiliation(updateDTO.institutionalAffiliation())
                .withLattes(updateDTO.lattes())));
        JsonUtils.logObject(log, "Avaliador updated", avaliadorDTO);
        return avaliadorDTO;
    }

    public List<AvaliadorDTO> findAll(final Optional<String> name,
                                      Optional<String> email,
                                      Optional<String> cpf,
                                      Optional<String> phone,
                                      Optional<String> institutionalAffiliation) {
        return repository.findAll(AvaliadorSpecification.builder().name(name).email(email).cpf(cpf).phone(phone)
                        .institutionalAffiliation(institutionalAffiliation).build()).stream().map(avaliadorMapper::buildDTO)
                .sorted(Comparator.comparing(AvaliadorDTO::id))
                .collect(Collectors.toList());
    }

    public void delete(final Long id) {
        Avaliador avaliador = findById(id);
        repository.delete(avaliador);
        JsonUtils.logObject(log, "Avaliador deleted:", avaliador);
    }
}