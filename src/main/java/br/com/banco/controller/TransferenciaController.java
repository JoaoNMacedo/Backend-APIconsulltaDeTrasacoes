package br.com.banco.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.entity.Transferencia;
import br.com.banco.service.TransferenciaService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("transferencias")
public class TransferenciaController {

    @Autowired
    private TransferenciaService transferenciaService;
    @GetMapping
    public ResponseEntity<?> obterTransacoesPorData(
            @RequestParam(value = "dataInicial", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam(value = "dataFinal", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal,
            @RequestParam(value = "nomeOperadorTransacao", required = false) String nomeOperadorTransacao) {
        List<Transferencia> transferencias = transferenciaService.obterTransacoesPorFiltros(dataInicial, dataFinal, nomeOperadorTransacao);
        return ResponseEntity.ok(transferencias);
    }
    
    @GetMapping("/{idConta}")
    public ResponseEntity<?> obterTransferenciaPorId(
    		@RequestParam(value = "dataInicial", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam(value = "dataFinal", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal,
            @RequestParam(value = "nomeOperadorTransacao", required = false) String nomeOperadorTransacao,
    		@PathVariable("idConta") Long idConta) {
        List<Transferencia> transferencias = transferenciaService.obterTransacoesPorId(dataInicial, dataFinal, nomeOperadorTransacao, idConta);
        return ResponseEntity.ok(transferencias);
    }
}
    

