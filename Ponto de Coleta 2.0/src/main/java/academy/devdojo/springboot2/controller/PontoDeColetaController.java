package academy.devdojo.springboot2.controller;

import academy.devdojo.springboot2.domain.PontoDeColeta;
import academy.devdojo.springboot2.requests.PontoDeColetaPostRequestBody;
import academy.devdojo.springboot2.requests.PontoDeColetaPutRequestBody;
import academy.devdojo.springboot2.service.PontoDeColetaService;
import academy.devdojo.springboot2.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("PontoDeColeta")
@Log4j2
@RequiredArgsConstructor
public class PontoDeColetaController {
    private final DateUtil dateUtil;
    private final PontoDeColetaService pontodecoletaService;

    @GetMapping
    public ResponseEntity<List<PontoDeColeta>> list() {
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(pontodecoletaService.listAll());
    }

    @GetMapping(path = "/{bairro}")
    public ResponseEntity<PontoDeColeta> findByBairro(@PathVariable String bairro) {
        return ResponseEntity.ok(pontodecoletaService.findByBairroOrThrowBadRequestException(bairro));
    }

    @PostMapping
    public ResponseEntity<PontoDeColeta> save(@RequestBody PontoDeColetaPostRequestBody pontodecoletaPostRequestBody) {
        return new ResponseEntity<>(pontodecoletaService.save(pontodecoletaPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{bairro}")
    public ResponseEntity<Void> delete(@PathVariable String bairro) {
        pontodecoletaService.delete(bairro);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody PontoDeColetaPutRequestBody pontodecoletaPutRequestBody) {
        pontodecoletaService.replace(pontodecoletaPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
