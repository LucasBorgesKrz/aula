package br.com.techx.aula.controller;
import org.springframework.http.ResponseEntity;
import br.com.techx.aula.dto.AlunoRequest;
import br.com.techx.aula.dto.AlunoResponse;
import br.com.techx.aula.model.Aluno;
import br.com.techx.aula.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
 
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
public ResponseEntity<AlunoResponse> getById(@PathVariable Long id) {
    AlunoResponse response = alunoService.findBy(id);
    if (response != null) {
        return ResponseEntity.ok(response);
    } else {
        return ResponseEntity.notFound().build();
    }
}
 
    // @RequestParam -> pega o valor da query string, ex: /aluno/buscar?ra=022116
   @GetMapping("/buscar")
public ResponseEntity<AlunoResponse> getByRa(@RequestParam String ra) {
    AlunoResponse response = alunoService.findByRa(ra);
    if (response != null) {
        return ResponseEntity.ok(response);
    } else {
        return ResponseEntity.notFound().build();
    }
}
 
    @PostMapping
    public ResponseEntity<AlunoResponse> create(@RequestBody AlunoRequest alunoRequest) {
    AlunoResponse response = alunoService.create(alunoRequest);
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
 
   @PutMapping("/{id}")
public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody AlunoRequest alunoRequest) {
    alunoService.update(id, alunoRequest);
    return ResponseEntity.noContent().build();
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> delete(@PathVariable Long id) {
    alunoService.deleteById(id);
    return ResponseEntity.noContent().build();
}
    // Desafio prático
    @GetMapping("/desafio")
    public String desafio(){
        return "O RA do aluno Lucas Borges Krziminski é 022116";
    }
}

