package academy.devdojo.springboot2.controller;


import academy.devdojo.springboot2.domain.Coletores;
import academy.devdojo.springboot2.requests.ColetoresPostRequestBody;
import academy.devdojo.springboot2.requests.ColetoresPutRequestBody;
import academy.devdojo.springboot2.service.ColetoresService;
import academy.devdojo.springboot2.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("Coletores")
@Log4j2
@RequiredArgsConstructor
public class ColetoresController {
    private final DateUtil dateUtil;
    private final ColetoresService coletoresService;

    @GetMapping
    public ResponseEntity<List<Coletores>> list() {
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(coletoresService.listAll());
    }

    @GetMapping(path = "/{name}")
    public ResponseEntity<Coletores> findById(@PathVariable String name) {
        return ResponseEntity.ok(coletoresService.findByIdOrThrowBadRequestException(name));
    }

    @PostMapping
    public ResponseEntity<Coletores> save(@RequestBody ColetoresPostRequestBody coletoresPostRequestBody) {
        return new ResponseEntity<>(coletoresService.save(coletoresPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{name}")
    public ResponseEntity<Void> delete(@PathVariable String name) {
        coletoresService.delete(name);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody ColetoresPutRequestBody coletoresPutRequestBody) {
        coletoresService.replace(coletoresPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
