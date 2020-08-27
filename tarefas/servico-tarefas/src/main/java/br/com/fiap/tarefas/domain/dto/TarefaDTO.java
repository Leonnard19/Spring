package br.com.fiap.tarefas.domain.dto;

import br.com.fiap.tarefas.domain.Tarefa;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

//controls which atributes to be transfered and showed to final user
public class TarefaDTO {

    private Long codigo;
    private String descricao;
    private Boolean feita;
    private LocalDate dataLimite;

    public TarefaDTO(Tarefa tarefa) {
        this.codigo = tarefa.getCodigo();
        this.descricao = tarefa.getDescricao();
        this.feita = tarefa.getFeita();
        this.dataLimite = tarefa.getDataLimite();
    }

    public static  List<TarefaDTO> converter(List<Tarefa> tarefas) {

        return tarefas.stream()
                .map(TarefaDTO::new)
                .collect(Collectors.toList());    //para cada elemento do map ele vai
                                                        // gerar um construtor e retornar essa instancia
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getFeita() {
        return feita;
    }

    public void setFeita(Boolean feita) {
        this.feita = feita;
    }

    public LocalDate getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(LocalDate dataLimite) {
        this.dataLimite = dataLimite;
    }
}
