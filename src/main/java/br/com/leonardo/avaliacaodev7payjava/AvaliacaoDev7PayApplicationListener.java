package br.com.leonardo.avaliacaodev7payjava;

import br.com.leonardo.avaliacaodev7payjava.domain.recife.service.RecifeService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.function.Predicate;

@Component
@Order(0)
public class AvaliacaoDev7PayApplicationListener implements ApplicationListener<ApplicationReadyEvent> {
    private final RecifeService recifeService;

    public AvaliacaoDev7PayApplicationListener(RecifeService recifeService) {
        this.recifeService = recifeService;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Environment env = event.getApplicationContext().getEnvironment();

        if (isTest(env)) {
            return;
        }

        System.out.println("Carregando lista de Despesas Orçamentárias de Recife...");
        Integer saved = recifeService.listaESalvaDespesaOrcamentaria(100);
        System.out.println("Lista carregada. " + saved.toString() + " despesas salvas.");
    }

    private static boolean isTest(Environment env) {
        return Arrays.stream(env.getActiveProfiles()).anyMatch(Predicate.isEqual("test"));
    }
}
