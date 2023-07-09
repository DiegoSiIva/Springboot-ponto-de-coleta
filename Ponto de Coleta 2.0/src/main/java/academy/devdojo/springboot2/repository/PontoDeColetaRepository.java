package academy.devdojo.springboot2.repository;

import academy.devdojo.springboot2.domain.PontoDeColeta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PontoDeColetaRepository extends JpaRepository<PontoDeColeta, Long> {

    PontoDeColeta findByBairro(String bairro);

}
