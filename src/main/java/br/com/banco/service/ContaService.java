package br.com.banco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.entity.Conta;
import br.com.banco.repository.ContaRepository;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;
    
    public List<Conta> findAll(){
    	return contaRepository.findAll();
    }

    public Conta obterContaPorId(Long idConta) {
        return contaRepository.findById(idConta).orElse(null);
    }
}