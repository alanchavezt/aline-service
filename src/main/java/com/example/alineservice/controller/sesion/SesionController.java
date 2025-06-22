package com.example.alineservice.controller.sesion;

import com.example.alineservice.dao.SesionDAO;
import com.example.alineservice.model.Sesion;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

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
            return Response.ok("Sesión registrada correctamente").build();
        } else {
            return Response.serverError().entity("Error al registrar sesión").build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizar(Sesion s) {
        boolean exito = dao.actualizar(s);
        if (exito) {
            return Response.ok("Sesión actualizada correctamente").build();
        } else {
            return Response.serverError().entity("Error al actualizar sesión").build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") int id) {
        boolean exito = dao.eliminar(id);
        if (exito) {
            return Response.ok("Sesión eliminada correctamente").build();
        } else {
            return Response.serverError().entity("Error al eliminar sesión").build();
        }
    }
}
