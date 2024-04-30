package br.com.leonardo.avaliacaodev7payjava.domain.despesa.service;

import br.com.leonardo.avaliacaodev7payjava.domain.despesa.repository.DespesaRepositoryInterface;
import br.com.leonardo.avaliacaodev7payjava.infrastructure.despesa.DespesaDto;
import br.com.leonardo.avaliacaodev7payjava.domain.despesa.entity.Despesa;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DespesaService {
    private final DespesaRepositoryInterface despesaRepository;

    public Despesa create(DespesaDto despesa) {
        return despesaRepository.save(despesa.toEntity());
    }

    public Despesa update(Integer id, DespesaDto despesa) {
        if (!despesaRepository.existsById(id)) {
            throw new NoSuchElementException("Despesa não existe.");
        }

        return despesaRepository.save(despesa.toEntity());
    }

    public void delete(Integer id) {
        if (!despesaRepository.existsById(id)) {
            return;
        }

        Optional<Despesa> despesa = despesaRepository.findById(id);
        despesaRepository.delete(despesa.orElseThrow());
    }

    public List<Despesa> findAll(Pageable paging) {
        return despesaRepository.findAll(paging).toList();
    }

    public Despesa findById(Integer id) {
        Optional<Despesa> despesa = despesaRepository.findById(id);
        return despesa.orElseThrow();
    }

    public Integer createAll(List<DespesaDto> dtoList) {
        List<Despesa> despesaModelStream = dtoList.stream().map(DespesaDto::toEntity).toList();
        return despesaRepository.saveAll(despesaModelStream).size();
    }

    public void deleteAll() {
        despesaRepository.deleteAll();
    }
}
