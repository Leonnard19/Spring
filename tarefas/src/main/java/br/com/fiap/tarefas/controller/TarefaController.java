package br.com.fiap.tarefas.controller;

import br.com.fiap.tarefas.domain.Tarefa;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLOutput;

@Controller
@RequestMapping("/tarefas")
public class TarefaController {

    @GetMapping("/cadastrar")
    public String index() {

        return "tarefas/form";
    }

    @PostMapping("/cadastrar")
    public String create(Tarefa tarefa, Model model) {
        model.addAttribute("tarefa", tarefa);
        return "tarefas/sucesso";
    }

}
