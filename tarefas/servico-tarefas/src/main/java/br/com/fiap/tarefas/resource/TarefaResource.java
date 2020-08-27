package br.com.fiap.tarefas.resource;

import br.com.fiap.tarefas.domain.Tarefa;
import br.com.fiap.tarefas.domain.dto.TarefaDTO;
import br.com.fiap.tarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("tarefas")
public class TarefaResource {

    // cria automaticamente todos os metodos para utilização referente ao tarefaRepository
    @Autowired
    TarefaRepository tarefaRepository;

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<TarefaDTO> lista(String descricao) {
        List<Tarefa> tarefas = descricao == null ?
                tarefaRepository.findAll() :
                tarefaRepository.findByDescricaoContaining(descricao); // cria metodo na interface
        return TarefaDTO.converter(tarefas);
    }

    @GetMapping("{id}")
    public ResponseEntity <TarefaDTO> detalhe(@PathVariable("id") Long codigo) { // parse da variavel id para Long codigo
        Optional <Tarefa> tarefa = tarefaRepository.findById(codigo);

        return tarefa.map(t -> ResponseEntity.ok(new TarefaDTO(t)))
                .orElse(ResponseEntity.notFound().build());

        /*if(tarefa.isPresent())
            return ResponseEntity.ok(new TarefaDTO(tarefa.get())); //get pega o objeto tarefa, caso somente tarefa pega o optional
        return ResponseEntity.notFound().build();
         */
    }

    @PostMapping
    @Transactional
    public ResponseEntity<TarefaDTO> salva(@RequestBody @Valid Tarefa tarefa,
                                           UriComponentsBuilder uribuilder
    ) {
        tarefaRepository.save(tarefa);

        URI uri = uribuilder
                .path("/tarefas/{id}")
                .buildAndExpand(tarefa.getCodigo())
                .toUri();
        return ResponseEntity
                .created(uri)
                .body(new TarefaDTO(tarefa));
    }

        @PutMapping("{id}")
        @Transactional
        public ResponseEntity<TarefaDTO> atualiza(@PathVariable Long id,
        @RequestBody @Valid Tarefa tarefaAtualizada) {

            Optional<Tarefa> tarefa = tarefaRepository.findById(id);

            return tarefa.map(t -> {
                t.setDescricao(tarefaAtualizada.getDescricao());
                t.setFeita(tarefaAtualizada.getFeita());
                t.setDataLimite(tarefaAtualizada.getDataLimite());
                t.setUltimaAtualizacao(LocalDate.now());
                tarefaRepository.save(t);
                return ResponseEntity.ok(new TarefaDTO(t));
            }).orElse(ResponseEntity.notFound().build());
        }

            @DeleteMapping("{id}")
            @Transactional
            public ResponseEntity<?> remove (@PathVariable Long id) {  // ? retorna o tipo que o metodo escolher melhor
                Optional<Tarefa> tarefa = tarefaRepository.findById(id);
                return tarefa.map(t -> {
                    tarefaRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
            }

}
