package com.desafio.gerenciadorDeVoos.models;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Validated
@Table(name = "pilotos")
public class PilotoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "Informe o número do registro")
    private String registroAnac;

    @Column(nullable = false)
    @NotBlank(message = "Informe o nome")
    private String nome;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "Colocar CPF válido")
    @CPF
    private String cpf;

    @Column
    private LocalDate dataDeNascimento;

}
