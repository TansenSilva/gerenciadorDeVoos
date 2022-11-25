package com.desafio.gerenciadorDeVoos.repositories;

import com.desafio.gerenciadorDeVoos.enums.StatusVoo;
import com.desafio.gerenciadorDeVoos.models.VooModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VooRepository extends JpaRepository<VooModel,Long> {

    List<VooModel> findByStatus(StatusVoo status);
}
