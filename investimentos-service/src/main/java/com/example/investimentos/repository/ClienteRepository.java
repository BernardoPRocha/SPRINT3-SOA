package com.example.investimentos.repository;

import com.example.investimentos.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // consultas específicas podem ser adicionadas aqui
}
