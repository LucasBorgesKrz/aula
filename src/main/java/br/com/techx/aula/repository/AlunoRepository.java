package br.com.techx.aula.repository;

import br.com.techx.aula.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno,Long> {


}
