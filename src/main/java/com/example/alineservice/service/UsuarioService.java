package com.example.alineservice.service;

import com.example.alineservice.model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class UsuarioService {

    private static final List<Usuario> usuarios = new ArrayList<>();
    private static final AtomicInteger idGenerator = new AtomicInteger();

    // Crear usuario
    public Usuario crearUsuario(Usuario usuario) {
        usuario.setIdUsuario(idGenerator.incrementAndGet());
        usuario.setEstadoCuenta(true); // activo por defecto
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
                .filter(u -> u.getIdUsuario() == id)
                .findFirst()
                .orElse(null);
    }

    // Eliminar usuario por ID
    public boolean eliminarUsuario(int id) {
        return usuarios.removeIf(u -> u.getIdUsuario() == id);
    }
}
