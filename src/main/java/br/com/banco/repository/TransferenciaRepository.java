package br.com.banco.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.banco.entity.Transferencia;

@Repository
public interface TransferenciaRepository extends JpaRepository <Transferencia, Long>{
		
	@Query("SELECT t FROM Transferencia t WHERE t.dataTransferencia >= :dataInicial AND t.dataTransferencia <= :dataFinal")
	    List<Transferencia> obterTransacoesPorData(@Param("dataInicial") LocalDateTime dataInicial, @Param("dataFinal") LocalDateTime dataFinal);
}
