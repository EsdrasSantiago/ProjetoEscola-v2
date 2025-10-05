package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Diretor;
import com.example.demo.service.DiretorService;

import java.util.List;

@Controller
@RequestMapping("/diretores")
public class DiretorController {

    @Autowired
    private DiretorService service;

    @PostMapping("/cadastrar")
    @ResponseBody // continua retornando JSON para a API
    public ResponseEntity<Diretor> cadastrarDiretor(@RequestBody Diretor diretor) {
        Diretor novoDiretor = service.cadastrar(diretor);
        return ResponseEntity.ok(novoDiretor);
    }

    @GetMapping("/cadastrar-via-get")
    @ResponseBody // mantém o retorno JSON
    public ResponseEntity<Diretor> cadastrarDiretorViaGet(
            @RequestParam String nome,
            @RequestParam String email,
            @RequestParam String telefone,
            @RequestParam String senha) {

        Diretor diretor = new Diretor();
        diretor.setNome(nome);
        diretor.setEmail(email);
        diretor.setTelefone(telefone);
        diretor.setSenha(senha);

        Diretor salvo = service.cadastrar(diretor);
        return ResponseEntity.ok(salvo);
    }

    // ✅ Novo método para listar e exibir na página HTML
    @GetMapping("/listar")
    public String listarDiretores(Model model) {
        List<Diretor> diretores = service.listarTodos();
        model.addAttribute("diretores", diretores);
        return "listar-diretores"; // nome do arquivo HTML (sem .html)
    }

@PostMapping("/salvar")
public String cadastrarDiretorFormulario(
        @RequestParam String nome,
        @RequestParam String email,
        @RequestParam String telefone,
        @RequestParam String senha) {

    Diretor diretor = new Diretor();
    diretor.setNome(nome);
    diretor.setEmail(email);
    diretor.setTelefone(telefone);
    diretor.setSenha(senha);

    service.cadastrar(diretor);

    return "redirect:/diretores/listar"; // vai para a lista
}


}
