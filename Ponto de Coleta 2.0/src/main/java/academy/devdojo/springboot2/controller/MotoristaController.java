package academy.devdojo.springboot2.controller;


import academy.devdojo.springboot2.domain.Motorista;
import academy.devdojo.springboot2.requests.MotoristaPostRequestBody;
import academy.devdojo.springboot2.requests.MotoristaPutRequestBody;
import academy.devdojo.springboot2.service.MotoristaService;
import academy.devdojo.springboot2.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("Motorista")
@Log4j2
@RequiredArgsConstructor
public class MotoristaController {
    private final DateUtil dateUtil;
    private final MotoristaService motoristaService;

    @GetMapping
    public ResponseEntity<List<Motorista>> list() {
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(motoristaService.listAll());
    }

    @GetMapping(path = "/{name}")
    public ResponseEntity<Motorista> findById(@PathVariable String name) {
        return ResponseEntity.ok(motoristaService.findByNameOrThrowBadRequestException(name));
    }

    @PostMapping
    public ResponseEntity<Motorista> save(@RequestBody MotoristaPostRequestBody motoristaPostRequestBody) {
        return new ResponseEntity<>(motoristaService.save(motoristaPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{name}")
    public ResponseEntity<Void> delete(@PathVariable String name) {
        motoristaService.delete(name);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody MotoristaPutRequestBody motoristaPutRequestBody) {
        motoristaService.replace(motoristaPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
