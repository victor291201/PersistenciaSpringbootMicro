package com.micro.micro.repositories;

import com.micro.micro.AbstractIntegrationDBTest;
import com.micro.micro.entities.Partida;
import com.micro.micro.entities.Usuario;
import com.micro.micro.repositories.PartidaRepository;
import com.micro.micro.repositories.UsuarioRepository;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;

class PartidaRepositoryTest extends AbstractIntegrationDBTest {

    public PartidaRepository partidaRepository;
    public UsuarioRepository usuarioRepository;

    @Autowired
    public PartidaRepositoryTest(PartidaRepository partidaRepository, UsuarioRepository usuarioRepository) {
        this.partidaRepository = partidaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    Set<Usuario> crearUsuario() {
        Set<Usuario> usuarios = new HashSet<>();
        Usuario usuario = Usuario.builder()
                .nombre("José")
                .apellido("Fontalvo")
                .username("fontalvo0218")
                .password("123")
                .build();

        usuarios.add(usuario);
        return usuarios;
    }

    Partida crearPartida(Set<Usuario> usuarios) {
        return Partida.builder()
                .deporte("lol")
                .ciudad("venezuela")
                .Provincia("valencia")
                .fecha(LocalDateTime.now())
                .hora_comienzo(LocalDateTime.now())
                .hora_final(LocalDateTime.now())
                .participantes(2)
                .suplentes(2)
                .comentarios("no coment")
                .usuarios(usuarios)
                .build();
    }

    Partida crearPartidaConUsuarioPorDefecto() {
        return crearPartida(crearUsuario());
    }

    Partida guardarPartidaEnBD() {
        Partida partida = crearPartidaConUsuarioPorDefecto();
        return this.partidaRepository.save(partida);
    }

    @BeforeEach
    void setUp() {
        this.partidaRepository.deleteAll();
        this.usuarioRepository.deleteAll();
    }

    @Test
    void guardarPartida() {
        Partida savedSugerencia = this.guardarPartidaEnBD();
        assertThat(savedSugerencia.getId()).isNotNull();
    }

    @Test
    void buscarPartidaPorId() {
        Long idGuardado = this.guardarPartidaEnBD().getId();
        Optional<Partida> sugerenciaBuscada = this.partidaRepository.findById(idGuardado);
        assertThat(sugerenciaBuscada.isPresent()).isTrue();
    }

    @Test
    void actualizarPartida() {
        Partida partida = this.guardarPartidaEnBD();
        partida.setComentarios("este es el nuevo comentario");
        Partida sugerenciaGuardada = this.partidaRepository.save(partida);
        assertThat(sugerenciaGuardada)
                .hasFieldOrPropertyWithValue("comentarios", "este es el nuevo comentario");
    }

    @Test
    void eliminarPartida() {
        Long idSugerenciaGuardada = this.guardarPartidaEnBD().getId();
        this.partidaRepository.deleteById(idSugerenciaGuardada);
        Optional<Partida> sugerenciaBuscada = this.partidaRepository.findById(idSugerenciaGuardada);
        assertThat(sugerenciaBuscada.isPresent()).isFalse();

    }

}