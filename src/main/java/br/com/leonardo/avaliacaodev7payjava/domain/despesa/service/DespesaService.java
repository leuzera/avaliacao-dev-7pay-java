package br.com.leonardo.avaliacaodev7payjava.domain.despesa.service;

import br.com.leonardo.avaliacaodev7payjava.domain.despesa.repository.DespesaRepositoryInterface;
import br.com.leonardo.avaliacaodev7payjava.infrastructure.Despesa.DespesaModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DespesaService {
    private final DespesaRepositoryInterface despesaRepository;

    public DespesaModel create(DespesaModel despesa) {
        return despesaRepository.save(despesa);
    }

    public DespesaModel update(DespesaModel despesa) {
        if (!despesaRepository.existsById(despesa.getId())) {
            throw new NoSuchElementException("Despesa não existe.");
        }

        return despesaRepository.save(despesa);
    }

    public void delete(Integer id) {
        if (!despesaRepository.existsById(id)) {
            throw new NoSuchElementException("Despesa não existe.");
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
