package br.com.fiap.tarefas.domain;

public class Tarefa {

    private String descricao;
    private boolean feita;

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
