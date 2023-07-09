package academy.devdojo.springboot2.repository;

import academy.devdojo.springboot2.domain.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotoristaRepository extends JpaRepository<Motorista, Long> {

    Motorista findByName(String name);

}
