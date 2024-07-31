package com.rodrigolorandi.sistemamostrapoa.service;

import com.rodrigolorandi.sistemamostrapoa.dto.OuvinteCreateDTO;
import com.rodrigolorandi.sistemamostrapoa.dto.OuvinteDTO;
import com.rodrigolorandi.sistemamostrapoa.dto.OuvinteUpdateDTO;
import com.rodrigolorandi.sistemamostrapoa.entity.Ouvinte;
import com.rodrigolorandi.sistemamostrapoa.exception.ErrorCodeEnum;
import com.rodrigolorandi.sistemamostrapoa.helper.JsonUtils;
import com.rodrigolorandi.sistemamostrapoa.helper.MessageHelper;
import com.rodrigolorandi.sistemamostrapoa.repository.OuvinteRepository;
import com.rodrigolorandi.sistemamostrapoa.repository.spec.OuvinteSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.rodrigolorandi.sistemamostrapoa.exception.ErrorCodeEnum.ERRO_OUVINTE_NAO_ENCONTRADO;
import static com.rodrigolorandi.sistemamostrapoa.util.mapper.MapperConstants.ouvinteMapper;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@Service
@RequiredArgsConstructor
public class OuvinteService {
    private final OuvinteRepository repository;
    private final MessageHelper messageHelper;

    public OuvinteDTO create(final OuvinteCreateDTO requestDTO) {
        Ouvinte ouvinte = repository.save(ouvinteMapper.buildEntity(requestDTO));
        JsonUtils.logObject(log,"Ouvinte criado", ouvinte);
        return ouvinteMapper.buildDTO(ouvinte);
    }


    public OuvinteDTO findDTOById(Long id) {
        Ouvinte ouvinte = findById(id);
        return ouvinteMapper.buildDTO(ouvinte);
    }

    public Ouvinte findById(final Long id) {
        return repository.findById(id).orElseThrow(() -> {
            log.error(messageHelper.get(ERRO_OUVINTE_NAO_ENCONTRADO, id.toString()));
            return new ResponseStatusException(NOT_FOUND, messageHelper.get(ERRO_OUVINTE_NAO_ENCONTRADO, id.toString()));
        });
    }

    public OuvinteDTO update(final OuvinteUpdateDTO updateDTO) {
        Ouvinte ouvinte = findById(updateDTO.id());
        OuvinteDTO ouvinteDTO = ouvinteMapper.buildDTO(repository.save(ouvinte
                .withName(updateDTO.name())
                .withEmail(updateDTO.email())
                .withPhone(updateDTO.phone())
                .withCpf(updateDTO.cpf())
                .withAccessibility(updateDTO.accessibility())));
        JsonUtils.logObject(log,"Ouvinte updated",  ouvinteDTO);
        return ouvinteDTO;
    }

    public List<OuvinteDTO> findAll(final Optional<String> name,
                                         Optional<String> email,
                                         Optional<String> cpf,
                                         Optional<String> phone) {
        return repository.findAll(OuvinteSpecification.builder().name(name).email(email)
                        .cpf(cpf).phone(phone).build()).stream().map(ouvinteMapper::buildDTO)
                .sorted(Comparator.comparing(OuvinteDTO::id))
                .collect(Collectors.toList());
    }

    public void delete(final Long id) {
        Ouvinte ouvinte = findById(id);
        repository.delete(ouvinte);
        JsonUtils.logObject(log,"Ouvinte deleted:", ouvinte);
    }
}