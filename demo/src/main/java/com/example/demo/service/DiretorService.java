package com.example.demo.service;

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
}
