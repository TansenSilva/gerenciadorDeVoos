package com.desafio.gerenciadorDeVoos.repositories;

import com.desafio.gerenciadorDeVoos.models.AviaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AviaoRepository extends JpaRepository<AviaoModel, Long> {
}
