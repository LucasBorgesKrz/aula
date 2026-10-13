package br.com.techx.aula.service;
import java.util.Optional;
import br.com.techx.aula.dto.AlunoRequest;
import br.com.techx.aula.dto.AlunoResponse;
import br.com.techx.aula.model.Aluno;
import br.com.techx.aula.repository.AlunoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.util.List;
 
@Service
public class AlunoService {
 
    @Autowired
    private AlunoRepository alunoRepository;
 
    public List<Aluno> buscar(){
        return alunoRepository.findAll();
    }
 
    public AlunoResponse create(AlunoRequest alunoRequest) {
    Aluno entity = new Aluno();
    entity.setNome(alunoRequest.getNome());
    entity.setIdade(alunoRequest.getIdade());
    entity.setRa(alunoRequest.getRa());

    Aluno salvo = alunoRepository.save(entity);

    return new AlunoResponse(salvo.getId(), salvo.getNome(), salvo.getIdade(), salvo.getRa());
}
 
   public AlunoResponse findBy(Long id) {
    Optional<Aluno> opt = alunoRepository.findById(id);
    if (opt.isPresent()) {
        Aluno aluno = opt.get();
        return new AlunoResponse(aluno.getId(), aluno.getNome(), aluno.getIdade(), aluno.getRa());
    } else {
        return null;
    }
}
 
    public AlunoResponse findByRa(String ra) {
    Optional<Aluno> opt = alunoRepository.findByRa(ra);
    if (opt.isPresent()) {
        Aluno aluno = opt.get();
        return new AlunoResponse(aluno.getId(), aluno.getNome(), aluno.getIdade(), aluno.getRa());
    } else {
        return null;
    }
}
 
   public void update(Long id, AlunoRequest alunoRequest) {
    Aluno entity = alunoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

    entity.setNome(alunoRequest.getNome());
    entity.setIdade(alunoRequest.getIdade());
    entity.setRa(alunoRequest.getRa());

    alunoRepository.save(entity);
}

public void deleteById(Long id) {
    boolean exists = alunoRepository.existsById(id);

    if (!exists) {
        throw new RuntimeException("Aluno não encontrado");
    }

    alunoRepository.deleteById(id);
    }
}
