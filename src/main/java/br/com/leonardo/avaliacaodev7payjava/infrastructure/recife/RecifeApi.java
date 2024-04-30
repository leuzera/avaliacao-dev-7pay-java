package br.com.leonardo.avaliacaodev7payjava.infrastructure.recife;

import br.com.leonardo.avaliacaodev7payjava.domain.despesa.service.DespesaService;
import br.com.leonardo.avaliacaodev7payjava.infrastructure.despesa.DespesaDto;
import io.netty.resolver.DefaultAddressResolverGroup;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.util.Collections;
import java.util.List;

@Component
public class RecifeApi {

    private final DespesaService despesaService;
    private final WebClient webClient;

    public RecifeApi(DespesaService despesaService, WebClient.Builder webClientBuilder) {
        this.despesaService = despesaService;

        HttpClient httpClient = HttpClient.create().resolver(DefaultAddressResolverGroup.INSTANCE);
        this.webClient = webClientBuilder
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .baseUrl("http://dados.recife.pe.gov.br")
                .build();
    }

    public List<DespesaDto> listaDespesaOrcamentaria(Integer size) {
        RecifeApiDto recifeApiDto = getDespesaDtosFromRecife(size);

        if (recifeApiDto == null || !recifeApiDto.success() || recifeApiDto.result() == null) {
            return Collections.emptyList();
        }

        return recifeApiDto.result().records();
    }

    public Integer listaESalvaDespesaOrcamentaria(Integer limit) {
        List<DespesaDto> dtoList = listaDespesaOrcamentaria(limit);
        return despesaService.createAll(dtoList);
    }

    private RecifeApiDto getDespesaDtosFromRecife(Integer size) {
        return webClient.get().uri(uriBuilder -> uriBuilder
                        .path("/api/3/action/datastore_search")
                        .queryParam("resource_id", "d4d8a7f0-d4be-4397-b950-f0c991438111")
                        .queryParam("limit", "{limit}")
                        .build(size)
                )
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(RecifeApiDto.class)
                .block();

    }
}
