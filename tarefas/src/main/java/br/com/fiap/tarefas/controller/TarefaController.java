package br.com.fiap.tarefas.controller;

import br.com.fiap.tarefas.domain.Tarefa;
import br.com.fiap.tarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLOutput;
import java.util.List;

@Controller
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    @GetMapping("/cadastrar")
    public String index(Model model) {
    List<Tarefa> tarefas = tarefaRepository.findAll();
    model.addAttribute("tarefas", tarefas);
        return "tarefas/form";
    }

    @PostMapping("/cadastrar")
    public String create(Tarefa tarefa, Model model) {
        tarefaRepository.save(tarefa);
        model.addAttribute("tarefa", tarefa);
        return "tarefas/sucesso";
    }

}
