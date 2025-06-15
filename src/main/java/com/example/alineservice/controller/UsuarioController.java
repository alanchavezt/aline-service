package com.example.alineservice.controller;

import com.example.alineservice.model.Usuario;
import com.example.alineservice.service.UsuarioService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioController {

    private UsuarioService usuarioService = new UsuarioService();

    @GET
    public List<Usuario> obtenerTodos() {
        return usuarioService.obtenerTodos();
    }

    @GET
    @Path("/{id}")
    public Usuario obtenerPorId(@PathParam("id") int id) {
        return usuarioService.obtenerPorId(id);
    }

    @POST
    public Response crearUsuario(Usuario usuario) {
        usuarioService.crearUsuario(usuario);
        return Response.status(Response.Status.CREATED).build();
    }

//    @PUT
//    @Path("/{id}")
//    public Response actualizarUsuario(@PathParam("id") int id, Usuario usuario) {
//        usuario.setId(id);
//        usuarioService.actualizarUsuario(usuario);
//        return Response.ok().build();
//    }

    @DELETE
    @Path("/{id}")
    public Response eliminarUsuario(@PathParam("id") int id) {
        usuarioService.eliminarUsuario(id);
        return Response.noContent().build();
    }
}
