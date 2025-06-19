package com.example.alineservice.controller.usuario;

import com.example.alineservice.dao.UsuarioDAO;
import com.example.alineservice.model.Usuario;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/usuarios")
public class UsuarioController {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registrar(Usuario usuario) {
        UsuarioDAO dao = new UsuarioDAO();

        if (dao.existeCorreo(usuario.getCorreo())) {
            return Response.status(Response.Status.CONFLICT).entity("El correo ya está registrado").build();
        }

        if (dao.existeUsuario(usuario.getNombreUsuario())) {
            return Response.status(Response.Status.CONFLICT).entity("El nombre de usuario ya existe").build();
        }

        boolean exito = dao.registrar(usuario);
        if (exito) {
            return Response.ok("Usuario registrado exitosamente").build();
        } else {
            return Response.serverError().entity("Error al registrar usuario").build();
        }
    }
}