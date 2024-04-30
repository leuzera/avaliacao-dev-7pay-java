package br.com.leonardo.avaliacaodev7payjava.infrastructure.recife;

import br.com.leonardo.avaliacaodev7payjava.domain.despesa.service.DespesaService;
import br.com.leonardo.avaliacaodev7payjava.domain.recife.service.RecifeService;
import br.com.leonardo.avaliacaodev7payjava.infrastructure.despesa.DespesaDto;
import br.com.leonardo.avaliacaodev7payjava.domain.despesa.entity.Despesa;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
class RecifeServiceTest {

    @Mock
    RecifeWebClient recifeWebClient;

    @InjectMocks
    RecifeService recifeService;

    @Autowired
    private DespesaService despesaService;

    @Test
    void listaDespesaOrcamentaria() {
        List<DespesaDto> dtoList = List.of(Despesa.builder().build().toDto(), Despesa.builder().build().toDto(), Despesa.builder().build().toDto());
        RecifeApiResultDto result = new RecifeApiResultDto("123", true, 3, 100, dtoList);
        RecifeApiDto recifeApiDto = new RecifeApiDto(true, result);

        when(recifeWebClient.getDespesaDtosFromRecife(3)).thenReturn(recifeApiDto);

        List<DespesaDto> despesaDtos = recifeService.listaDespesaOrcamentaria(3);

        assertEquals(dtoList.size(), despesaDtos.size());
    }
}