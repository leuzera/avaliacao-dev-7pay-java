package br.com.leonardo.avaliacaodev7payjava.domain.despesa.service;

import br.com.leonardo.avaliacaodev7payjava.domain.despesa.entity.Despesa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
class DespesaServiceTest {

    @Autowired
    private DespesaService despesaService;

    @BeforeEach
    void cleanDatabase() {
        despesaService.deleteAll();
    }

    @Test
    void create() {
        Despesa model = Despesa
                .builder()
                .anoMovimentacao(2017)
                .mesMovimentacao(5)
                .build();

        Despesa created = despesaService.create(model.toDto());

        assertNotNull(created.getId());
        assertEquals(model.getAnoMovimentacao(), created.getAnoMovimentacao());
        assertEquals(model.getMesMovimentacao(), created.getMesMovimentacao());
    }

    @Test
    void findById() {
        Despesa model = Despesa.builder().build();
        Despesa created = despesaService.create(model.toDto());

        Despesa found = despesaService.findById(created.getId());

        assertEquals(created.getId(), found.getId());
    }

    @Test
    void findAll() {
        Despesa model = Despesa.builder().build();
        despesaService.create(model.toDto());
        Despesa model2 = Despesa.builder().build();
        despesaService.create(model2.toDto());
        Despesa model3 = Despesa.builder().build();
        despesaService.create(model3.toDto());

        List<Despesa> found = despesaService.findAll(Pageable.unpaged());

        assertEquals(3, found.size());
    }

    @Test
    void update() {
        Despesa model = Despesa.builder().anoMovimentacao(2015).mesMovimentacao(5).build();
        Despesa created = despesaService.create(model.toDto());

        model.setMesMovimentacao(8);
        Despesa updated = despesaService.update(created.getId(), model.toDto());

        assertEquals(8, updated.getMesMovimentacao());
    }

    @Test
    void delete() {
        Despesa model = Despesa.builder().anoMovimentacao(2015).mesMovimentacao(5).build();
        Despesa created = despesaService.create(model.toDto());

        despesaService.delete(created.getId());

        assertThrows(NoSuchElementException.class, () -> despesaService.findById(created.getId()));
    }
}