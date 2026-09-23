package br.com.techx.aula.dto;
 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AlunoRequest {
    private String nome;
    private int idade;
    private String ra; //
}


