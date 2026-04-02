package br.com.ulerich.despachante_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.ulerich.despachante_api.models.Processo;

@Repository
public interface ProcessoRepository extends JpaRepository<Processo, Long> {
}