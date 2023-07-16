package br.com.banco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.entity.Transferencia;
import br.com.banco.repository.TransferenciaRepository;

import java.time.LocalDateTime;
import java.util.List;

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
    
    public List<Transferencia> obterTransacoesPorId(LocalDateTime dataInicial, LocalDateTime dataFinal, String nomeOperadorTransacao, Long contaId){
    	return transferenciaRepository.obterTransacoesPorId(dataInicial, dataFinal, nomeOperadorTransacao, contaId);
    }
}
