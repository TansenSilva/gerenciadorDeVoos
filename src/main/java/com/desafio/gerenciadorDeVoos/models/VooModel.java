package com.desafio.gerenciadorDeVoos.models;

import com.desafio.gerenciadorDeVoos.enums.StatusVoo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Validated
@Table(name = "voos")
public class VooModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate dataPartida;

    @Column(nullable = false)
    private String horaPartida;

    @Column(nullable = false)
    private LocalDate dataChegada;

    @Column(nullable = false)
    private String horaChegada;

    @Column(nullable = false)
    private String origem;

    @Column(nullable = false)
    private String destino;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusVoo status;

    @JsonIgnore
    @Column
    private int lotacao;

}
