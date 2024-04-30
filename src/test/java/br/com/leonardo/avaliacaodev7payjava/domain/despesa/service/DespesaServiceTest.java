package br.com.leonardo.avaliacaodev7payjava.domain.despesa.service;

import br.com.leonardo.avaliacaodev7payjava.infrastructure.despesa.DespesaModel;
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
        DespesaModel model = DespesaModel
                .builder()
                .anoMovimentacao(2017)
                .mesMovimentacao(5)
                .build();

        DespesaModel created = despesaService.create(model.toDto());

        assertNotNull(created.getId());
        assertEquals(model.getAnoMovimentacao(), created.getAnoMovimentacao());
        assertEquals(model.getMesMovimentacao(), created.getMesMovimentacao());
    }

    @Test
    void findById() {
        DespesaModel model = DespesaModel.builder().build();
        DespesaModel created = despesaService.create(model.toDto());

        DespesaModel found = despesaService.findById(created.getId());

        assertEquals(created.getId(), found.getId());
    }

    @Test
    void findAll() {
        DespesaModel model = DespesaModel.builder().build();
        despesaService.create(model.toDto());
        DespesaModel model2 = DespesaModel.builder().build();
        despesaService.create(model2.toDto());
        DespesaModel model3 = DespesaModel.builder().build();
        despesaService.create(model3.toDto());

        List<DespesaModel> found = despesaService.findAll(Pageable.unpaged());

        assertEquals(3, found.size());
    }

    @Test
    void update() {
        DespesaModel model = DespesaModel.builder().anoMovimentacao(2015).mesMovimentacao(5).build();
        DespesaModel created = despesaService.create(model.toDto());

        model.setMesMovimentacao(8);
        DespesaModel updated = despesaService.update(created.getId(), model.toDto());

        assertEquals(8, updated.getMesMovimentacao());
    }

    @Test
    void delete() {
        DespesaModel model = DespesaModel.builder().anoMovimentacao(2015).mesMovimentacao(5).build();
        DespesaModel created = despesaService.create(model.toDto());

        despesaService.delete(created.getId());

        assertThrows(NoSuchElementException.class, () -> despesaService.findById(created.getId()));
    }
}