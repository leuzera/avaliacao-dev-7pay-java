package br.com.leonardo.avaliacaodev7payjava.infrastructure.despesa;

import jakarta.persistence.*;
import lombok.*;

@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class DespesaModel {
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    Integer anoMovimentacao;

    @Column
    Integer mesMovimentacao;

    @Column
    Integer orgaoCodigo;

    @Column
    String orgaoNome;

    @Column
    Integer unidadeCodigo;

    @Column
    String unidadeNome;

    @Column
    Integer categoriaEconomicaCodigo;

    @Column
    String categoriaEconomicaNome;

    @Column
    Integer grupoDespesaCodigo;

    @Column
    String grupoDespesaNome;

    @Column
    Integer modalidadeAplicacaoCodigo;

    @Column
    String modalidadeAplicacaoNome;

    @Column
    Integer elementoCodigo;

    @Column
    String elementoNome;

    @Column
    Integer subelementoCodigo;

    @Column
    String subelementoNome;

    @Column
    Integer funcaoCodigo;

    @Column
    String funcaoNome;

    @Column
    Integer subfuncaoCodigo;

    @Column
    String subfuncaoNome;

    @Column
    Integer programaCodigo;

    @Column
    String programaNome;

    @Column
    Integer acaoCodigo;

    @Column
    String acaoNome;

    @Column
    Integer fonteRecursoCodigo;

    @Column
    String fonteRecursoNome;

    @Column
    Integer empenhoAno;

    @Column
    String empenhoModalidadeNome;

    @Column
    Integer empenhoModalidadeCodigo;

    @Column
    Integer empenhoNumero;

    @Column
    Integer subempenho;

    @Column
    String indicadorSubempenho;

    @Column
    Integer credorCodigo;

    @Column
    String credorNome;

    @Column
    Integer modalidadeLicitacaoCodigo;

    @Column
    String modalidadeLicitacaoNome;

    @Column
    String valorEmpenhado;

    @Column
    String valorLiquidado;

    @Column
    String valorPago;

    public DespesaDto toDto() {
        return new DespesaDto(
                id,
                anoMovimentacao,
                mesMovimentacao,
                orgaoCodigo,
                orgaoNome,
                unidadeCodigo,
                unidadeNome,
                categoriaEconomicaCodigo,
                categoriaEconomicaNome,
                grupoDespesaCodigo,
                grupoDespesaNome,
                modalidadeAplicacaoCodigo,
                modalidadeAplicacaoNome,
                elementoCodigo,
                elementoNome,
                subelementoCodigo,
                subelementoNome,
                funcaoCodigo,
                funcaoNome,
                subfuncaoCodigo,
                subfuncaoNome,
                programaCodigo,
                programaNome,
                acaoCodigo,
                acaoNome,
                fonteRecursoCodigo,
                fonteRecursoNome,
                empenhoAno,
                empenhoModalidadeNome,
                empenhoModalidadeCodigo,
                empenhoNumero,
                subempenho,
                indicadorSubempenho,
                credorCodigo,
                credorNome,
                modalidadeLicitacaoCodigo,
                modalidadeLicitacaoNome,
                valorEmpenhado,
                valorLiquidado,
                valorPago
        );
    }
}
