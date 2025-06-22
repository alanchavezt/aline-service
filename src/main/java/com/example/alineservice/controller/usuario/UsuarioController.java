package com.example.alineservice.controller.usuario;

import com.example.alineservice.dao.UsuarioDAO;
import com.example.alineservice.model.Usuario;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/usuarios")
public class UsuarioController {

    UsuarioDAO dao = new UsuarioDAO();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registrar(Usuario usuario) {
        // Validación previa de campos
        if (usuario.getNombreUsuario() == null || usuario.getCorreo() == null || usuario.getContrasenaHash() == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Faltan campos obligatorios").build();
        }

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

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(Usuario user) {
        if (user.getCorreo() == null || user.getContrasenaHash() == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Faltan datos para login").build();
        }

        Usuario u = dao.login(user.getCorreo(), user.getContrasenaHash());
        if (u != null) {
            return Response.ok(u).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("Credenciales incorrectas")
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarUsuarios() {
        List<Usuario> usuarios = dao.getAll();
        return Response.ok(usuarios).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerPorId(@PathParam("id") int id) {
        Usuario usuario = dao.obtenerPorId(id);
        if (usuario != null) {
            return Response.ok(usuario).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Usuario con ID " + id + " no encontrado").build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizar(@PathParam("id") int id, Usuario usuarioActualizado) {
        boolean actualizado = dao.actualizar(id, usuarioActualizado);
        if (actualizado) {
            return Response.ok("Usuario actualizado correctamente").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Usuario con ID " + id + " no encontrado").build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminar(@PathParam("id") int id) {
        boolean eliminado = dao.eliminar(id);
        if (eliminado) {
            return Response.ok("Usuario eliminado correctamente").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Usuario con ID " + id + " no encontrado").build();
        }
    }
}