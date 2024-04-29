package br.com.leonardo.avaliacaodev7payjava.domain.despesa.repository;

import br.com.leonardo.avaliacaodev7payjava.infrastructure.despesa.DespesaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DespesaRepositoryInterface extends JpaRepository<DespesaModel, Integer> {
}
