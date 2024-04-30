package br.com.leonardo.avaliacaodev7payjava;

import br.com.leonardo.avaliacaodev7payjava.infrastructure.recife.RecifeApi;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(0)
public class AvaliacaoDev7PayApplicationListener implements ApplicationListener<ApplicationReadyEvent> {
    private final RecifeApi recifeApi;

    public AvaliacaoDev7PayApplicationListener(RecifeApi recifeApi) {
        this.recifeApi = recifeApi;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        System.out.println("Carregando lista de Despesas Orçamentárias de Recife...");
        Integer saved = recifeApi.listaESalvaDespesaOrcamentaria(100);
        System.out.println("Lista carregada. " + saved.toString() + " despesas salvas.");
    }
}
