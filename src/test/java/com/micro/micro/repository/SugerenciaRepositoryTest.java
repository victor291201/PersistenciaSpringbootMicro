package com.micro.micro.repository;

import com.micro.micro.AbstractIntegrationDBTest;
import com.micro.micro.entities.Sugerencia;
import com.micro.micro.entities.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class SugerenciaRepositoryTest  extends AbstractIntegrationDBTest {

    public SugerenciaRepository sugerenciaRepository;
    public UsuarioRepository usuarioRepository;

    @Autowired
    public SugerenciaRepositoryTest(SugerenciaRepository sugerenciaRepository,
                                    UsuarioRepository usuarioRepository) {
        this.sugerenciaRepository = sugerenciaRepository;
        this.usuarioRepository  = usuarioRepository;
    }

    Usuario crearUsuario() {
        return Usuario.builder()
                .nombre("José")
                .apellido("Fontalvo")
                .username("fontalvo0218")
                .password("123")
                .build();
    }

    Sugerencia crearSugerencia(Usuario usuario ) {
        return  Sugerencia.builder()
                .usuario( usuario )
                .descripcion("esta es una nueva sugerencia")
                .create_at(LocalDateTime.now())
                .build();
    }

    Sugerencia crearSugerenciaConUsuarioPorDefecto() {
        return  crearSugerencia( crearUsuario() );
    }

    @BeforeEach
    void setUp() {
        this.sugerenciaRepository.deleteAll();
        this.usuarioRepository.deleteAll();
    }

    @Test
    void guardarSugerencia() {

        Sugerencia sugerencia  = crearSugerenciaConUsuarioPorDefecto();

        Sugerencia savedSugerencia = this.sugerenciaRepository.save( sugerencia );

        assertThat( savedSugerencia.getId() ).isNotNull();
    }

}