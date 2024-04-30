package br.com.leonardo.avaliacaodev7payjava.infrastructure.recife;

import io.netty.resolver.DefaultAddressResolverGroup;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@Component
public class RecifeWebClient {
    private final WebClient webClient;

    public RecifeWebClient(WebClient.Builder webClientBuilder) {
        HttpClient httpClient = HttpClient.create().resolver(DefaultAddressResolverGroup.INSTANCE);
        this.webClient = webClientBuilder
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .baseUrl("http://dados.recife.pe.gov.br")
                .build();
    }

    public RecifeApiDto getDespesaDtosFromRecife(Integer size) {
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
