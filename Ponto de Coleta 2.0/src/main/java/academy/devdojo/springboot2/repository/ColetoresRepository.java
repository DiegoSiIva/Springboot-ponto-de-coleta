package academy.devdojo.springboot2.repository;

import academy.devdojo.springboot2.domain.Coletores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColetoresRepository extends JpaRepository<Coletores, Long> {

    Coletores findByName(String name);

}
