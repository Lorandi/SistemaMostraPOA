package com.rodrigolorandi.sistemamostrapoa.service;

import com.rodrigolorandi.sistemamostrapoa.dto.ParticipanteTrabalhoCreateDTO;
import com.rodrigolorandi.sistemamostrapoa.dto.ParticipanteTrabalhoDTO;
import com.rodrigolorandi.sistemamostrapoa.dto.ParticipanteTrabalhoUpdateDTO;
import com.rodrigolorandi.sistemamostrapoa.entity.ParticipanteTrabalho;
import com.rodrigolorandi.sistemamostrapoa.enums.TipoParticipanteTrabalhoEnum;
import com.rodrigolorandi.sistemamostrapoa.helper.JsonUtils;
import com.rodrigolorandi.sistemamostrapoa.helper.MessageHelper;
import com.rodrigolorandi.sistemamostrapoa.repository.ParticipanteTrabalhoRepository;
import com.rodrigolorandi.sistemamostrapoa.repository.spec.ParticipanteTrabalhoSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.rodrigolorandi.sistemamostrapoa.exception.ErrorCodeEnum.ERRO_PARTICIPANTE_TRABALHO_NAO_ENCONTRADO;
import static com.rodrigolorandi.sistemamostrapoa.util.mapper.MapperConstants.participanteTrabalhoMapper;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@Service
@RequiredArgsConstructor
public class ParticipanteTrabalhoService {
    private final ParticipanteTrabalhoRepository repository;
    private final MessageHelper messageHelper;
    private final TrabalhoService trabalhoService;

    public ParticipanteTrabalhoDTO create(final ParticipanteTrabalhoCreateDTO requestDTO) {
        trabalhoService.findById(requestDTO.trabalhoId());
        ParticipanteTrabalho ParticipanteTrabalho = repository.save(participanteTrabalhoMapper.buildEntity(requestDTO));
        JsonUtils.logObject(log, "ParticipanteTrabalho criado", ParticipanteTrabalho);
        return participanteTrabalhoMapper.buildDTO(ParticipanteTrabalho);
    }


    public ParticipanteTrabalhoDTO findDTOById(Long id) {
        ParticipanteTrabalho ParticipanteTrabalho = findById(id);
        return participanteTrabalhoMapper.buildDTO(ParticipanteTrabalho);
    }

    public ParticipanteTrabalho findById(final Long id) {
        return repository.findById(id).orElseThrow(() -> {
            log.error(messageHelper.get(ERRO_PARTICIPANTE_TRABALHO_NAO_ENCONTRADO, id.toString()));
            return new ResponseStatusException(NOT_FOUND, messageHelper.get(ERRO_PARTICIPANTE_TRABALHO_NAO_ENCONTRADO, id.toString()));
        });
    }

    public ParticipanteTrabalhoDTO update(final ParticipanteTrabalhoUpdateDTO updateDTO) {
        trabalhoService.findById(updateDTO.trabalhoId());
        ParticipanteTrabalho ParticipanteTrabalho = findById(updateDTO.id());
        ParticipanteTrabalhoDTO ParticipanteTrabalhoDTO = participanteTrabalhoMapper.buildDTO(repository.save(ParticipanteTrabalho
                .withTrabalhoId(updateDTO.trabalhoId())
                .withName(updateDTO.name())
                .withEmail(updateDTO.email())
                .withPhone(updateDTO.phone())
                .withCpf(updateDTO.cpf())
                .withTipoParticipante(updateDTO.tipoParticipante())));
        JsonUtils.logObject(log, "ParticipanteTrabalho updated", ParticipanteTrabalhoDTO);
        return ParticipanteTrabalhoDTO;
    }

    public List<ParticipanteTrabalhoDTO> findAll(final Optional<String> name,
                                                 Optional<String> email,
                                                 Optional<String> cpf,
                                                 Optional<String> phone,
                                                 Optional<List<TipoParticipanteTrabalhoEnum>> tipoParticipante,
                                                 Optional<List<Long>> trabalhoId) {
        return repository.findAll(ParticipanteTrabalhoSpecification.builder().name(name).email(email)
                        .cpf(cpf).phone(phone).tipoParticipante(tipoParticipante).trabalhoId(trabalhoId).build())
                .stream().map(participanteTrabalhoMapper::buildDTO)
                .sorted(Comparator.comparing(ParticipanteTrabalhoDTO::id))
                .collect(Collectors.toList());
    }

    public void delete(final Long id) {
        ParticipanteTrabalho ParticipanteTrabalho = findById(id);
        repository.delete(ParticipanteTrabalho);
        JsonUtils.logObject(log, "ParticipanteTrabalho deleted:", ParticipanteTrabalho);
    }
}