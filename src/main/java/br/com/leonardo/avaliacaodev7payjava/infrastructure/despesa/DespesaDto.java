package br.com.leonardo.avaliacaodev7payjava.infrastructure.despesa;

import br.com.leonardo.avaliacaodev7payjava.domain.despesa.entity.Despesa;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * DTO for {@link Despesa}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record DespesaDto(
        @JsonProperty("id")
        Integer id,

        @JsonProperty("ano_movimentacao")
        Integer anoMovimentacao,

        @JsonProperty("mes_movimentacao")
        Integer mesMovimentacao,

        @JsonProperty("orgao_codigo")
        Integer orgaoCodigo,

        @JsonProperty("orgao_nome")
        String orgaoNome,

        @JsonProperty("unidade_codigo")
        Integer unidadeCodigo,

        @JsonProperty("unidade_nome")
        String unidadeNome,

        @JsonProperty("categoria_economica_codigo")
        Integer categoriaEconomicaCodigo,

        @JsonProperty("categoria_economica_nome")
        String categoriaEconomicaNome,

        @JsonProperty("grupo_despesa_codigo")
        Integer grupoDespesaCodigo,

        @JsonProperty("grupo_despesa_nome")
        String grupoDespesaNome,

        @JsonProperty("modalidade_aplicacao_codigo")
        Integer modalidadeAplicacaoCodigo,

        @JsonProperty("modalidade_aplicacao_nome")
        String modalidadeAplicacaoNome,

        @JsonProperty("elemento_codigo")
        Integer elementoCodigo,

        @JsonProperty("elemento_nome")
        String elementoNome,

        @JsonProperty("subelemento_codigo")
        Integer subelementoCodigo,

        @JsonProperty("subelemento_nome")
        String subelementoNome,

        @JsonProperty("funcao_codigo")
        Integer funcaoCodigo,

        @JsonProperty("funcao_nome")
        String funcaoNome,

        @JsonProperty("subfuncao_codigo")
        Integer subfuncaoCodigo,

        @JsonProperty("subfuncao_nome")
        String subfuncaoNome,

        @JsonProperty("programa_codigo")
        Integer programaCodigo,

        @JsonProperty("programa_nome")
        String programaNome,

        @JsonProperty("acao_codigo")
        Integer acaoCodigo,

        @JsonProperty("acao_nome")
        String acaoNome,

        @JsonProperty("fonte_recurso_codigo")
        Integer fonteRecursoCodigo,

        @JsonProperty("fonte_recurso_nome")
        String fonteRecursoNome,

        @JsonProperty("empenho_ano")
        Integer empenhoAno,

        @JsonProperty("empenho_modalidade_nome")
        String empenhoModalidadeNome,

        @JsonProperty("empenho_modalidade_codigo")
        Integer empenhoModalidadeCodigo,

        @JsonProperty("empenho_numero")
        Integer empenhoNumero,

        @JsonProperty("subempenho")
        Integer subempenho,

        @JsonProperty("indicador_subempenho")
        String indicadorSubempenho,

        @JsonProperty("credor_codigo")
        Integer credorCodigo,

        @JsonProperty("credor_nome")
        String credorNome,

        @JsonProperty("modalidade_licitacao_codigo")
        Integer modalidadeLicitacaoCodigo,

        @JsonProperty("modalidade_licitacao_nome")
        String modalidadeLicitacaoNome,

        @JsonProperty("valor_empenhado")
        String valorEmpenhado,

        @JsonProperty("valor_liquidado")
        String valorLiquidado,

        @JsonProperty("valor_pago")
        String valorPago
) implements Serializable {
    public Despesa toEntity() {
        return Despesa.builder()
                .anoMovimentacao(this.anoMovimentacao)
                .mesMovimentacao(this.mesMovimentacao)
                .orgaoCodigo(this.orgaoCodigo)
                .orgaoNome(this.orgaoNome)
                .unidadeCodigo(this.unidadeCodigo)
                .unidadeNome(this.unidadeNome)
                .categoriaEconomicaCodigo(this.categoriaEconomicaCodigo)
                .categoriaEconomicaNome(this.categoriaEconomicaNome)
                .grupoDespesaCodigo(this.grupoDespesaCodigo)
                .grupoDespesaNome(this.grupoDespesaNome)
                .modalidadeAplicacaoCodigo(this.modalidadeAplicacaoCodigo)
                .modalidadeAplicacaoNome(this.modalidadeAplicacaoNome)
                .elementoCodigo(this.elementoCodigo)
                .elementoNome(this.elementoNome)
                .subelementoCodigo(this.subelementoCodigo)
                .subelementoNome(this.subelementoNome)
                .funcaoCodigo(this.funcaoCodigo)
                .funcaoNome(this.funcaoNome)
                .subfuncaoCodigo(this.subfuncaoCodigo)
                .subfuncaoNome(this.subfuncaoNome)
                .programaCodigo(this.programaCodigo)
                .programaNome(this.programaNome)
                .acaoCodigo(this.acaoCodigo)
                .acaoNome(this.acaoNome)
                .fonteRecursoCodigo(this.fonteRecursoCodigo)
                .fonteRecursoNome(this.fonteRecursoNome)
                .empenhoAno(this.empenhoAno)
                .empenhoModalidadeNome(this.empenhoModalidadeNome)
                .empenhoModalidadeCodigo(this.empenhoModalidadeCodigo)
                .empenhoNumero(this.empenhoNumero)
                .subempenho(this.subempenho)
                .indicadorSubempenho(this.indicadorSubempenho)
                .credorCodigo(this.credorCodigo)
                .credorNome(this.credorNome)
                .modalidadeLicitacaoCodigo(this.modalidadeLicitacaoCodigo)
                .modalidadeLicitacaoNome(this.modalidadeLicitacaoNome)
                .valorEmpenhado(this.valorEmpenhado)
                .valorLiquidado(this.valorLiquidado)
                .valorPago(this.valorPago)
                .build();
    }
}