package br.com.techx.aula.controller;

import br.com.techx.aula.dto.AlunoRequest;
import br.com.techx.aula.model.Aluno;
import br.com.techx.aula.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;


    @GetMapping
    public List<Aluno> getAll(){
        return alunoService.buscar();
    }

    @PostMapping
    public void create(@RequestBody AlunoRequest alunoRequest){
        alunoService.create(alunoRequest);
    }

//    Aluno aluno = new Aluno(1L,"lucas", 25, "022116");
//
//    @GetMapping("/nome")
//    public String getNome(){
//        return aluno.getNome();
//    }
//
//    @GetMapping("/idade")
//    public int getIdade(){
//        return aluno.getIdade();
//    }
//
//    @GetMapping
//    public Aluno getAluno(){
//        return aluno;
//    }
//
//    @GetMapping("/frase")
//    private String sistemaFrase() {
//        return("O RA do aluno " + aluno.getNome() + " é " + aluno.getRa());
//    }
}

