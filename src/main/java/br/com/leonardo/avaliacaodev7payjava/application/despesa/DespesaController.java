package br.com.leonardo.avaliacaodev7payjava.application.despesa;

import br.com.leonardo.avaliacaodev7payjava.domain.despesa.service.DespesaService;
import br.com.leonardo.avaliacaodev7payjava.infrastructure.despesa.DespesaDto;
import br.com.leonardo.avaliacaodev7payjava.infrastructure.despesa.DespesaModel;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/despesas", produces = "application/json")
public class DespesaController {
    private final DespesaService despesaService;

    public DespesaController(DespesaService despesaService) {
        this.despesaService = despesaService;
    }

    @GetMapping
    ResponseEntity<List<DespesaDto>> findAll(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "20") Integer limit,
            @RequestParam(defaultValue = "DESC") Sort.Direction direction,
            @RequestParam(defaultValue = "id") String[] sortBy
    ) {
        Sort sort = Sort.by(direction, sortBy);
        Pageable paging = PageRequest.of(page, limit, sort);
        List<DespesaDto> dtoList = despesaService.findAll(paging).stream().map(DespesaModel::toDto).toList();

        return ResponseEntity.ok(dtoList);
    }

    @PostMapping
    ResponseEntity<DespesaDto> create(@RequestBody DespesaDto model) {
        try {
            DespesaModel created = despesaService.create(model);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(created.getId())
                    .toUri();

            return ResponseEntity.created(uri).body(created.toDto());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    ResponseEntity<DespesaDto> findById(@PathVariable Integer id) {
        try {
            DespesaDto dto = despesaService.findById(id).toDto();
            return ResponseEntity.ok(dto);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    ResponseEntity<DespesaDto> update(@PathVariable Integer id, @RequestBody DespesaDto model) {
        try {
            DespesaDto dto = despesaService.update(id, model).toDto();
            return ResponseEntity.ok(dto);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Object> delete(@PathVariable Integer id) {
        despesaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
