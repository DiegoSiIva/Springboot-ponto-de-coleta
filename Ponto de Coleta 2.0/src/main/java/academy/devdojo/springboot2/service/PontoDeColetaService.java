package academy.devdojo.springboot2.service;

import academy.devdojo.springboot2.domain.PontoDeColeta;
import academy.devdojo.springboot2.repository.PontoDeColetaRepository;
import academy.devdojo.springboot2.requests.PontoDeColetaPostRequestBody;
import academy.devdojo.springboot2.requests.PontoDeColetaPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PontoDeColetaService {

    private final PontoDeColetaRepository pontodecoletaRepository;

    public List<PontoDeColeta> listAll() {
        return pontodecoletaRepository.findAll();
    }

    public PontoDeColeta findByBairroOrThrowBadRequestException(String bairro) {
        return pontodecoletaRepository.findByBairro(bairro);
                
    }

    public PontoDeColeta save(PontoDeColetaPostRequestBody pontodecoletaPostRequestBody) {
        return pontodecoletaRepository.save(PontoDeColeta.builder()
        .bairro(pontodecoletaPostRequestBody.getBairro())
        .dia(pontodecoletaPostRequestBody.getDia())
        .horario(pontodecoletaPostRequestBody.getHorario())
        .build());
    }

    public void delete(String bairro) {
        pontodecoletaRepository.delete(findByBairroOrThrowBadRequestException(bairro));
    }

    public void replace(PontoDeColetaPutRequestBody pontodecoletaPutRequestBody) {
        PontoDeColeta savedPontoDeColeta = findByBairroOrThrowBadRequestException(pontodecoletaPutRequestBody.getBairro());
        PontoDeColeta pontodecoleta = PontoDeColeta.builder()
                .id(savedPontoDeColeta.getId())
                .bairro(pontodecoletaPutRequestBody.getBairro())
                .dia(pontodecoletaPutRequestBody.getDia())
                .horario(pontodecoletaPutRequestBody.getHorario())
                .build();

        pontodecoletaRepository.save(pontodecoleta);
    }
}