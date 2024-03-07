package com.micro.micro.repositories;

import com.micro.micro.AbstractIntegrationDBTest;
import com.micro.micro.entities.Mensaje;
import com.micro.micro.entities.Usuario;
import com.micro.micro.repositories.MensajeRepository;
import com.micro.micro.repositories.UsuarioRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class MensajeRepositoryTest extends AbstractIntegrationDBTest {
    MensajeRepository mensajeRepository;
    UsuarioRepository usuarioRepository;

    @Autowired
    public MensajeRepositoryTest(MensajeRepository mensajeRepository,
            UsuarioRepository usuarioRepository) {

        this.mensajeRepository = mensajeRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @BeforeEach
    void setUp() {
        mensajeRepository.deleteAll();
        usuarioRepository.deleteAll();
    }

    void initMensajes() {

        Usuario usuario = Usuario.builder()
                .nombre("José")
                .apellido("Fontalvo")
                .username("fontalvo0218")
                .password("123")
                .build();

        Usuario userSaved = usuarioRepository.save(usuario);

        usuarioRepository.flush();

        Mensaje mensaje1 = Mensaje.builder()
                .creador("José")
                .destinator("Victor")
                .created_at(LocalDateTime.now())
                .contenido("contenido génerico")
                .usuario(userSaved)
                .build();

        Mensaje mensaje2 = Mensaje.builder()
                .creador("José")
                .destinator("Victor")
                .created_at(LocalDateTime.now())
                .contenido("contenido génerico mensaje2")
                .usuario(userSaved)
                .build();

        Mensaje mensajeSaved1 = mensajeRepository.save(mensaje1);
        Mensaje mensajeSaved2 = mensajeRepository.save(mensaje2);
        mensajeRepository.flush();

    }

    @Test
    @DisplayName("Creando un mensaje para insertarlo " +
            "en la base de datos y luego verificando " +
            "que no sea null por medio de su id")
    void saveMensaje() {
        Usuario usuario = Usuario.builder()
                .nombre("José")
                .apellido("Fontalvo")
                .username("fontalvo0218")
                .password("123")
                .build();
        // when
        Usuario userSaved = usuarioRepository.save(usuario);
        // then
        assertThat(userSaved.getId()).isNotNull();

        Mensaje mensaje = Mensaje.builder()
                .creador("José")
                .destinator("victor")
                .created_at(LocalDateTime.now())
                .contenido("contenido génerico")
                .usuario(userSaved)
                .build();

        Mensaje mensajeSaved = mensajeRepository.save(mensaje);
        mensajeRepository.flush();

        assertThat(mensajeSaved.getId()).isNotNull();
    }

    @Test
    void obtenerTodosLosMensajesDeLaBaseDeDatos() {

        this.initMensajes();

        List<Mensaje> mensajes = this.mensajeRepository.findAll();

        assertThat(mensajes).hasSize(2);

    }

    @Test
    void buscarMensajePorCreadorYDestinador() {
        this.initMensajes();
        List<Mensaje> mensajes = this.mensajeRepository.findByCreadorAndDestinator("José", "Victor");

        assertThat(mensajes).isNotEmpty();

        assertThat(mensajes).first().hasFieldOrPropertyWithValue("destinator", "Victor");

    }

    @Test
    void actualizarMensaje() {

        this.initMensajes();
        Mensaje mensaje = this.mensajeRepository.findAll().get(0);
        assertThat(mensaje).isNotNull();
        mensaje.setCreador("nuevo creador");
        Mensaje mensajeSaved = this.mensajeRepository.save(mensaje);
        assertThat(mensajeSaved).isNotNull();
        assertThat(mensajeSaved).hasFieldOrPropertyWithValue("creador", "nuevo creador");

    }

    @Test
    void eliminarMensaje() {
        this.initMensajes();
        this.initMensajes();
        Mensaje mensaje = this.mensajeRepository.findAll().get(0);
        assertThat(mensaje).isNotNull();
        Long mensajeId = mensaje.getId();
        this.mensajeRepository.deleteById(mensajeId);

        // ahora intentamos buscar el mensaje que ha sido eliminado

        Optional<Mensaje> mensajePorId = this.mensajeRepository.findById(mensajeId);
        assertThat(mensajePorId.isPresent()).isFalse();

    }

}