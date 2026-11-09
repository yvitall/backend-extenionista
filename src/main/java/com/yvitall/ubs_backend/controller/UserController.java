package com.yvitall.ubs_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yvitall.ubs_backend.model.User;
import com.yvitall.ubs_backend.repository.UserRepository;

@RestController
@RequestMapping("/api/agendamento")
@CrossOrigin(origins = "*") // Permite o HTML acessar a API
public class UserController {

    @Autowired
    private UserRepository repository;

    @PostMapping
    public ResponseEntity<String> salvarAgendamento(@RequestBody User user) {
        try {
            repository.save(user);
            return ResponseEntity.ok("Agendamento salvo com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao salvar: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        try {
            List<User> agendamentos = repository.findAll();
            return ResponseEntity.ok(agendamentos);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}