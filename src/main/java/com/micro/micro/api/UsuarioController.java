package com.micro.micro.api;

import com.micro.micro.dto.usuario.UsuarioDto;
import com.micro.micro.dto.usuario.UsuarioMapperImpl;
import com.micro.micro.dto.usuario.UsuarioToSaveDto;
import com.micro.micro.entities.Usuario;
import com.micro.micro.exception.usuario.UsuarioNotFoundException;
import com.micro.micro.service.usuario.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "api/v1/usuarios")
public class UsuarioController {

    private final UsuarioServiceImpl usuarioService;
    private final UsuarioMapperImpl usuarioMapper;

    public UsuarioController( UsuarioServiceImpl usuarioService, UsuarioMapperImpl usuarioMapper) {

        this.usuarioService = usuarioService;
        this.usuarioMapper = usuarioMapper;
    }

    @GetMapping("")
    public ResponseEntity<List<UsuarioDto>> getUsers(){
        return ResponseEntity.ok().body(this.usuarioService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> buscarUsuarioPorId( @PathVariable Long id) {
        try{
            UsuarioDto usuarioDto = this.usuarioService.buscarPorId(id);
            return ResponseEntity.ok().body( usuarioDto );
        }catch (UsuarioNotFoundException e){
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("")
    public ResponseEntity<UsuarioDto> guardarUsuario(@RequestBody UsuarioToSaveDto usuarioToSaveDto) {
        UsuarioDto usuarioSaved =  this.usuarioService.guardar(usuarioToSaveDto);
        return ResponseEntity.ok().body(usuarioSaved);
    }
}
