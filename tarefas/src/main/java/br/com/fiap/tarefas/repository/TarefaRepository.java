package br.com.fiap.tarefas.repository;

import br.com.fiap.tarefas.domain.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
