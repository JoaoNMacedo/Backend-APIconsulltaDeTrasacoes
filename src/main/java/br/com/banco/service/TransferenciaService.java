package br.com.banco.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.entity.Transferencia;
import br.com.banco.repository.TransferenciaRepository;

@Service
public class TransferenciaService {

    @Autowired
    private TransferenciaRepository transferenciaRepository;
    
    public List<Transferencia> getAll() {
        return transferenciaRepository.findAll();
    }

    public List<Transferencia> obterTransacoesPorFiltros(LocalDateTime dataInicial, LocalDateTime dataFinal, String nomeOperadorTransacao) {
        return transferenciaRepository.obterTransacoesPorDataENome(dataInicial, dataFinal, nomeOperadorTransacao);
    }
 }


