package br.com.fiap.tarefas.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@SequenceGenerator(name = "tarefa", sequenceName = "SQ_TAREFA")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tarefa")
    private long codigo;

    private LocalDate dataLimite;
    private String descricao;
    private boolean feita;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public LocalDate getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(LocalDate dataLimite) {
        this.dataLimite = dataLimite;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isFeita() {
        return feita;
    }

    public void setFeita(boolean feita) {
        this.feita = feita;
    }
}
