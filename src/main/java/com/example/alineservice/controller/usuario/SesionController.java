package com.example.alineservice.controller.usuario;

import com.example.alineservice.dao.SesionDAO;
import com.example.alineservice.model.Sesion;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/sesiones")
public class SesionController {

    SesionDAO dao = new SesionDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Sesion> listar() {
        return dao.listar();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registrar(Sesion s) {
        boolean exito = dao.registrar(s);
        if (exito) {
            return Response.ok("Sesión iniciada").build();
        } else {
            return Response.serverError().entity("Error al iniciar sesión").build();
        }
    }

    @PATCH
    @Path("/{id}")
    public Response cerrar(@PathParam("id") int idSesion) {
        boolean exito = dao.cerrarSesion(idSesion);
        if (exito) {
            return Response.ok("Sesión cerrada").build();
        } else {
            return Response.serverError().entity("Error al cerrar sesión").build();
        }
    }
}
