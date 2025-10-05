package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Diretor;
import com.example.demo.service.DiretorService;

@RestController
@RequestMapping({"/diretores"})
public class DiretorController {
   @Autowired
   private DiretorService service;

   public DiretorController() {
   }

   @PostMapping({"/cadastrar"})
   public ResponseEntity<Diretor> cadastrarDiretor(@RequestBody Diretor diretor) {
      Diretor novoDiretor = this.service.cadastrar(diretor);
      return ResponseEntity.ok(novoDiretor);
   }

   @GetMapping({"/cadastrar-via-get"})
   public ResponseEntity<Diretor> cadastrarDiretorViaGet(@RequestParam String nome, @RequestParam String email, @RequestParam String telefone, @RequestParam String senha) {
      Diretor diretor = new Diretor();
      diretor.setNome(nome);
      diretor.setEmail(email);
      diretor.setTelefone(telefone);
      diretor.setSenha(senha);
      Diretor salvo = this.service.cadastrar(diretor);
      return ResponseEntity.ok(salvo);
   }
}
