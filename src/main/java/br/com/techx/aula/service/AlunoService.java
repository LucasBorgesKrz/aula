package br.com.techx.aula.service;
 
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
 
    public void create(AlunoRequest alunoRequest) {
        Aluno entity = new Aluno();
        BeanUtils.copyProperties(alunoRequest, entity);
        alunoRepository.save(entity);
    }
 
    public AlunoResponse findBy(Long id){
        Aluno aluno = alunoRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("ID NOT FOUND"));
        return new AlunoResponse(aluno.getId(), aluno.getNome(), aluno.getIdade(), aluno.getRa());
    }
 
    public AlunoResponse findByRa(String ra){
        Aluno aluno = alunoRepository
                .findByRa(ra)
                .orElseThrow(() -> new RuntimeException("RA NOT FOUND"));
        return new AlunoResponse(aluno.getId(), aluno.getNome(), aluno.getIdade(), aluno.getRa());
    }
 
    public void update(Long id, AlunoRequest alunoRequest){
        Aluno entity = alunoRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("ID NOT FOUND"));
 
        BeanUtils.copyProperties(alunoRequest, entity);
        alunoRepository.save(entity);
    }
 
    public void deleteById(Long id){
        alunoRepository.deleteById(id);
    }
}
