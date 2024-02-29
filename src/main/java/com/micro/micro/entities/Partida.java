package com.micro.micro.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import org.hibernate.annotations.ManyToAny;
import org.springframework.cglib.core.Local;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "partidas")
public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String creador;

    private String deporte;

    private String ciudad;

    private String Provincia;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime fecha;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime hora_comienzo;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime hora_final;

    private Integer participantes;

    private Integer suplentes;

    private String comentarios;

    @ManyToMany(mappedBy = "partidas")
    private Set<Usuario> usuarios;
}
