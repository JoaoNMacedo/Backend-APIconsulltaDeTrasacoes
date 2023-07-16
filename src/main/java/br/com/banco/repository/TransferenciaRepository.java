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
		
		@Query("SELECT t FROM Transferencia t " +
		       "WHERE (:dataInicial IS NULL OR t.dataTransferencia >= :dataInicial) " +
		       "AND (:dataFinal IS NULL OR t.dataTransferencia <= :dataFinal) " +
		       "AND (:nomeOperadorTransacao IS NULL OR LOWER(t.nomeOperadorTransacao) LIKE LOWER(CONCAT('%', :nomeOperadorTransacao, '%')))")
		List<Transferencia> obterTransacoesPorDataENome(
		       @Param("dataInicial") LocalDateTime dataInicial,
		       @Param("dataFinal") LocalDateTime dataFinal,
		       @Param("nomeOperadorTransacao") String nomeOperadorTransacao);

}
