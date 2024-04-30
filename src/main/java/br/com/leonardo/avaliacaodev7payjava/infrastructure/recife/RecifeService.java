package br.com.leonardo.avaliacaodev7payjava.infrastructure.recife;

import br.com.leonardo.avaliacaodev7payjava.domain.despesa.service.DespesaService;
import br.com.leonardo.avaliacaodev7payjava.infrastructure.despesa.DespesaDto;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class RecifeService {

    private final DespesaService despesaService;
    private final RecifeWebClient recifeWebClient;


    public RecifeService(DespesaService despesaService, RecifeWebClient recifeWebClient) {
        this.despesaService = despesaService;
        this.recifeWebClient = recifeWebClient;
    }

    public List<DespesaDto> listaDespesaOrcamentaria(Integer size) {
        RecifeApiDto recifeApiDto = recifeWebClient.getDespesaDtosFromRecife(size);

        if (recifeApiDto == null || !recifeApiDto.success() || recifeApiDto.result() == null) {
            return Collections.emptyList();
        }

        return recifeApiDto.result().records();
    }

    public Integer listaESalvaDespesaOrcamentaria(Integer limit) {
        List<DespesaDto> dtoList = listaDespesaOrcamentaria(limit);
        return despesaService.createAll(dtoList);
    }
}
