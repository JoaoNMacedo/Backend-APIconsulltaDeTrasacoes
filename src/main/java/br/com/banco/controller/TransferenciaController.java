package br.com.banco.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.entity.Transferencia;
import br.com.banco.repository.TransferenciaRepository;
import br.com.banco.service.TransferenciaService;

@RestController
@RequestMapping("transferencias")
public class TransferenciaController {

	@Autowired
	private TransferenciaService transferenciaService;
    @Autowired
    private TransferenciaRepository repository;
    
    @GetMapping
	public List<Transferencia> getAll(){
		return repository.findAll();
	}


    @GetMapping("/por-data")
    public List<Transferencia> obterTransacoesPorData(@RequestParam("dataInicial") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
    												 @RequestParam("dataFinal") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal) {
        return transferenciaService.obterTransacoesPorData(dataInicial, dataFinal);
    }
    
   /* @GetMapping
    public List<Transferencia>
    */
}
