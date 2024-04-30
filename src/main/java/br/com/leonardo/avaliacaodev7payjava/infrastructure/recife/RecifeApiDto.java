package br.com.leonardo.avaliacaodev7payjava.infrastructure.recife;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RecifeApiDto(
        @JsonProperty("success")
        Boolean success,

        @JsonProperty("result")
        RecifeApiResultDto result
) {
}
