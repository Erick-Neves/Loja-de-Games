package com.SlimeInc.games.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SlimeInc.games.model.Jogos;
import com.SlimeInc.games.repository.JogosRepository;

@RestController
@RequestMapping("/jogos")
@CrossOrigin("*")
public class JogosController {
	
	@Autowired
	private JogosRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Jogos>> findAllPostagem()
	{
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Jogos> findByIdPostagem(@PathVariable long id)
	{
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Jogos>> getByTitulo(@PathVariable String nome)
	{
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<Jogos> post(@RequestBody Jogos jogo)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(jogo));
	}
	
	@PutMapping
	public ResponseEntity<Jogos> put(@RequestBody Jogos jogo)
	{
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(jogo));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id)
	{
		repository.deleteById(id);
	}
}
