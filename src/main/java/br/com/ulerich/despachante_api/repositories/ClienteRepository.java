package br.com.ulerich.despachante_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.ulerich.despachante_api.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}