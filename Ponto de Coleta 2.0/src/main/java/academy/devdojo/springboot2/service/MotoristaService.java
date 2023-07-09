package academy.devdojo.springboot2.service;

import academy.devdojo.springboot2.domain.Motorista;
import academy.devdojo.springboot2.repository.MotoristaRepository;
import academy.devdojo.springboot2.requests.MotoristaPostRequestBody;
import academy.devdojo.springboot2.requests.MotoristaPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MotoristaService {

    private final MotoristaRepository motoristaRepository;

    public List<Motorista> listAll() {
        return motoristaRepository.findAll();
    }

    public Motorista findByNameOrThrowBadRequestException(String name) {
        return motoristaRepository.findByName(name);
    }

    public Motorista save(MotoristaPostRequestBody motoristaPostRequestBody) {
        return motoristaRepository.save(Motorista.builder()
        .name(motoristaPostRequestBody.getName())
        .idade(motoristaPostRequestBody.getIdade())
        .cpf(motoristaPostRequestBody.getCpf())
        .build());
    }

    public void delete(String name) {
        motoristaRepository.delete(findByNameOrThrowBadRequestException(name));
    }

    public void replace(MotoristaPutRequestBody motoristaPutRequestBody) {
        Motorista savedmotorista = findByNameOrThrowBadRequestException(motoristaPutRequestBody.getName());
        Motorista motorista = Motorista.builder()
                .id(savedmotorista.getId())
                .name(motoristaPutRequestBody.getName())
                .idade(motoristaPutRequestBody.getIdade())
                .cpf(motoristaPutRequestBody.getCpf())
                .build();

        motoristaRepository.save(motorista);
    }
}
