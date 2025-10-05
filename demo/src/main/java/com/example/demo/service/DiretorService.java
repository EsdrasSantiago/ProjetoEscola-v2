package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Diretor;
import com.example.demo.repository.DiretorRepository;

@Service
public class DiretorService {

    @Autowired
    private DiretorRepository repository;

    public Diretor cadastrar(Diretor diretor) {
        return repository.save(diretor);
    }

    // ✅ Novo método para listar todos os diretores
    public List<Diretor> listarTodos() {
        return repository.findAll();
    }
}
