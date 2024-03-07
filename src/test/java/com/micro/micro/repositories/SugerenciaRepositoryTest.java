package com.micro.micro.repositories;

import com.micro.micro.AbstractIntegrationDBTest;
import com.micro.micro.entities.Sugerencia;
import com.micro.micro.entities.Usuario;
import com.micro.micro.repositories.SugerenciaRepository;
import com.micro.micro.repositories.UsuarioRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class SugerenciaRepositoryTest extends AbstractIntegrationDBTest {

    public SugerenciaRepository sugerenciaRepository;
    public UsuarioRepository usuarioRepository;

    @Autowired
    public SugerenciaRepositoryTest(SugerenciaRepository sugerenciaRepository,
            UsuarioRepository usuarioRepository) {
        this.sugerenciaRepository = sugerenciaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    Usuario crearUsuario() {
        return Usuario.builder()
                .nombre("José")
                .apellido("Fontalvo")
                .username("fontalvo0218")
                .password("123")
                .build();
    }

    Sugerencia crearSugerencia(Usuario usuario) {
        return Sugerencia.builder()
                .usuario(usuario)
                .descripcion("esta es una nueva sugerencia")
                .create_at(LocalDateTime.now())
                .build();
    }

    Sugerencia crearSugerenciaConUsuarioPorDefecto() {
        return crearSugerencia(crearUsuario());
    }

    Sugerencia guardarSugerenciaEnBD() {
        Sugerencia sugerencia = crearSugerenciaConUsuarioPorDefecto();
        return this.sugerenciaRepository.save(sugerencia);
    }

    @BeforeEach
    void setUp() {
        this.sugerenciaRepository.deleteAll();
        this.usuarioRepository.deleteAll();
    }

    @Test
    void guardarSugerencia() {
        Sugerencia savedSugerencia = this.guardarSugerenciaEnBD();
        assertThat(savedSugerencia.getId()).isNotNull();
    }

    @Test
    void buscarSugerenciaPorId() {
        Long idGuardado = this.guardarSugerenciaEnBD().getId();
        Optional<Sugerencia> sugerenciaBuscada = this.sugerenciaRepository.findById(idGuardado);
        assertThat(sugerenciaBuscada.isPresent()).isTrue();
    }

    @Test
    void actualizarSugerencia() {
        Sugerencia sugerencia = this.guardarSugerenciaEnBD();
        sugerencia.setDescripcion("esta es una nueva descripción");
        Sugerencia sugerenciaGuardada = this.sugerenciaRepository.save(sugerencia);
        assertThat(sugerenciaGuardada)
                .hasFieldOrPropertyWithValue("descripcion", "esta es una nueva descripción");
    }

    @Test
    void eliminarSugerencia() {
        Long idSugerenciaGuardada = this.guardarSugerenciaEnBD().getId();
        this.sugerenciaRepository.deleteById(idSugerenciaGuardada);
        Optional<Sugerencia> sugerenciaBuscada = this.sugerenciaRepository.findById(idSugerenciaGuardada);
        assertThat(sugerenciaBuscada.isPresent()).isFalse();

    }

}