package br.com.banco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.entity.Conta;
import br.com.banco.service.ContaService;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaService contaService;
  
    @GetMapping
	public List<Conta> findAll(){
		return contaService.findAll();
	}

    @GetMapping("/{idConta}")
    public ResponseEntity<Conta> obterContaPorId(@PathVariable("idConta") Long idConta) {
        Conta conta = contaService.obterContaPorId(idConta);
		return ResponseEntity.ok(conta);
    }
}