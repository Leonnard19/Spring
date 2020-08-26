package br.com.fiap.tarefas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/tarefas")
    public String index() {
        return "index";
    }
}
