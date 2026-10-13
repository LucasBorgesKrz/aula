package br.com.techx.aula.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlunoResponse {
    private Long id;
    private String nome;
    private int idade;
    private String ra;
}
