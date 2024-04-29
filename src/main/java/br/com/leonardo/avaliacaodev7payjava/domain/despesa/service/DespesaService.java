package br.com.leonardo.avaliacaodev7payjava.domain.despesa.service;

import br.com.leonardo.avaliacaodev7payjava.domain.despesa.repository.DespesaRepositoryInterface;
import br.com.leonardo.avaliacaodev7payjava.infrastructure.despesa.DespesaDto;
import br.com.leonardo.avaliacaodev7payjava.infrastructure.despesa.DespesaModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class DespesaService {
    private final DespesaRepositoryInterface despesaRepository;

    public DespesaModel create(DespesaDto despesa) {
        return despesaRepository.save(despesa.toEntity());
    }

    public DespesaModel update(Integer id, DespesaDto despesa) {
        if (!despesaRepository.existsById(id)) {
            throw new NoSuchElementException("Despesa não existe.");
        }

        return despesaRepository.save(despesa.toEntity());
    }

    public void delete(Integer id) {
        if (!despesaRepository.existsById(id)) {
            return;
        }

        Optional<DespesaModel> despesa = despesaRepository.findById(id);
        despesaRepository.delete(despesa.orElseThrow());
    }

    public List<DespesaModel> findAll() {
        return despesaRepository.findAll();
    }

    public DespesaModel findById(Integer id) {
        Optional<DespesaModel> despesa = despesaRepository.findById(id);
        return despesa.orElseThrow();
    }
}
