package com.example.alineservice.controller.auth;

import com.example.alineservice.dao.UsuarioDAO;
import com.example.alineservice.model.Usuario;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
