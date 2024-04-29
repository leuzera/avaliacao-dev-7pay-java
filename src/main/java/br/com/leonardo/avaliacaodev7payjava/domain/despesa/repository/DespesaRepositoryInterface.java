package br.com.leonardo.avaliacaodev7payjava.domain.despesa.repository;

import br.com.leonardo.avaliacaodev7payjava.infrastructure.Despesa.DespesaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DespesaRepositoryInterface extends JpaRepository<DespesaModel, Integer> {
}
