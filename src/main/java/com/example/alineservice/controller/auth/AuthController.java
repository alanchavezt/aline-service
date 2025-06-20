package com.example.alineservice.controller.auth;

import com.example.alineservice.dao.UsuarioDAO;
import com.example.alineservice.model.Usuario;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/login")
public class AuthController {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(Usuario usuarioInput) {
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = dao.login(usuarioInput.getCorreo(), usuarioInput.getContrasenaHash());

        if (usuario != null) {
            return Response.ok(usuario).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Credenciales incorrectas").build();
        }
    }
}
