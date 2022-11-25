package com.desafio.gerenciadorDeVoos.repositories;

import com.desafio.gerenciadorDeVoos.models.PilotoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PilotoRepository extends JpaRepository<PilotoModel, Long> {
}
