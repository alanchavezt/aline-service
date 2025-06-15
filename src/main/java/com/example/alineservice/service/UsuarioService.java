package com.example.alineservice.service;

import com.example.alineservice.model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class UsuarioService {

    private static final List<Usuario> usuarios = new ArrayList<>();
    private static final AtomicInteger idGenerator = new AtomicInteger();

    // Crear usuario
    public Usuario crearUsuario(Usuario usuario) {
        usuario.setId(idGenerator.incrementAndGet());
        usuario.setEstado(true); // activo por defecto
        usuarios.add(usuario);
        return usuario;
    }

    // Obtener todos los usuarios
    public List<Usuario> obtenerTodos() {
        return usuarios;
    }

    // Obtener usuario por ID
    public Usuario obtenerPorId(int id) {
        return usuarios.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Actualizar usuario
//    public Usuario actualizarUsuario(int id, Usuario usuarioActualizado) {
//        Optional<Usuario> usuarioOpt = usuarios.stream()
//                .filter(u -> u.getId() == id)
//                .findFirst();
//
//        if (usuarioOpt.isPresent()) {
//            Usuario existente = usuarioOpt.get();
//            existente.setNombre(usuarioActualizado.getNombre());
//            existente.setApellido(usuarioActualizado.getApellido());
//            existente.setNombreUsuario(usuarioActualizado.getNombreUsuario());
//            existente.setCorreo(usuarioActualizado.getCorreo());
//            existente.setContrasena(usuarioActualizado.getContrasena());
//            existente.setRutaLogo(usuarioActualizado.getRutaLogo());
//            existente.setEstado(usuarioActualizado.isEstado());
//            return existente;
//        }
//
//        return null;
//    }

    // Eliminar usuario por ID
    public boolean eliminarUsuario(int id) {
        return usuarios.removeIf(u -> u.getId() == id);
    }

}
