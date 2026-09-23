package br.com.techx.aula.controller;
 
import br.com.techx.aula.dto.AlunoRequest;
import br.com.techx.aula.dto.AlunoResponse;
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
 
    // @PathVariable -> pega o {id} direto da URL, ex: /aluno/1
    @GetMapping("/{id}")
    public AlunoResponse getById(@PathVariable Long id){
        return alunoService.findBy(id);
    }
 
    // @RequestParam -> pega o valor da query string, ex: /aluno/buscar?ra=022116
    @GetMapping("/buscar")
    public AlunoResponse getByRa(@RequestParam String ra){
        return alunoService.findByRa(ra);
    }
 
    @PostMapping
    public void create(@RequestBody AlunoRequest alunoRequest){
        alunoService.create(alunoRequest);
    }
 
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody AlunoRequest alunoRequest){
        alunoService.update(id, alunoRequest);
    }
 
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        alunoService.deleteById(id);
    }
 
    // Desafio prático
    @GetMapping("/desafio")
    public String desafio(){
        return "O RA do aluno Lucas Borges Krziminski é 022116";
    }
}

