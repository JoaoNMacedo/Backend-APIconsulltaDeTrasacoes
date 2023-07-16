package br.com.banco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.entity.Conta;
import br.com.banco.repository.ContaRepository;

@RestController
@RequestMapping("conta")
public class ContaController {
	@Autowired
	private ContaRepository contaRepository;

	@GetMapping
	public List<Conta>findAll(){
		return contaRepository.findAll();
	}
	
}
