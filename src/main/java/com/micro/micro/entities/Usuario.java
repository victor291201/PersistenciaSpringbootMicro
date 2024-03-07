package com.micro.micro.entities;

import java.time.LocalDateTime;
import java.util.Set;

import lombok.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "usuarios")
@Builder
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private String email;

    private String nombre;

    private String apellido;

    private Integer edad;

    private String password;

    private String rep_password;

    private Boolean enabled;

    private String foto;

    private String rol;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime created_at;

    @OneToMany(mappedBy = "usuario")
    private Set<Mensaje> mensajes;

    @OneToMany(mappedBy = "usuario")
    private Set<Sugerencia> sugerencias;

    @ManyToMany
    @JoinTable(name = "usuario-partida", joinColumns = @JoinColumn(name = "idUsuario", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "idPartida", referencedColumnName = "id"))
    private Set<Partida> partidas;

}
