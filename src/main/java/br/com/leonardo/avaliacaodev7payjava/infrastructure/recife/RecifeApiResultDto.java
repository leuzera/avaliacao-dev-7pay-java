package br.com.leonardo.avaliacaodev7payjava.infrastructure.recife;

import br.com.leonardo.avaliacaodev7payjava.infrastructure.despesa.DespesaDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RecifeApiResultDto(
        @JsonProperty("resource_id")
        String resourceId,

        @JsonProperty("include_total")
        Boolean includeTotal,

        @JsonProperty("limit")
        Integer limit,

        @JsonProperty("total")
        Integer total,

        @JsonProperty("records")
        List<DespesaDto> records
) {

}
