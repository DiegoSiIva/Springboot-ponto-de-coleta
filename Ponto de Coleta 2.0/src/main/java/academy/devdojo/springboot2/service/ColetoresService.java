package academy.devdojo.springboot2.service;

import academy.devdojo.springboot2.domain.Coletores;
import academy.devdojo.springboot2.repository.ColetoresRepository;
import academy.devdojo.springboot2.requests.ColetoresPostRequestBody;
import academy.devdojo.springboot2.requests.ColetoresPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class ColetoresService {

    private final ColetoresRepository coletoresRepository;

    public List<Coletores> listAll() {
        return coletoresRepository.findAll();
    }

    public Coletores findByIdOrThrowBadRequestException(String name) {
        return coletoresRepository.findByName(name)
                ;
    }

    public Coletores save(ColetoresPostRequestBody coletoresPostRequestBody) {
        return coletoresRepository.save(Coletores.builder()
        .name(coletoresPostRequestBody.getName())
        .idade(coletoresPostRequestBody.getIdade())
        .cpf(coletoresPostRequestBody.getCpf())
        .build());
    }

    public void delete(String name) {
        coletoresRepository.delete(findByIdOrThrowBadRequestException(name));
    }

    public void replace(ColetoresPutRequestBody coletoresPutRequestBody) {
        Coletores savedcoletores = findByIdOrThrowBadRequestException(coletoresPutRequestBody.getName());
        Coletores coletores = Coletores.builder()
                .id(savedcoletores.getId())
                .name(coletoresPutRequestBody.getName())
                .idade(coletoresPutRequestBody.getIdade())
                .cpf(coletoresPutRequestBody.getCpf())
                .build();

        coletoresRepository.save(coletores);
    }
}
