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
        int idSesion = dao.registrarYRetornarId(s);
        if (idSesion > 0) {
            s.setIdSesion(idSesion);
            return Response.ok(s).build();  // Devuelve JSON con la sesión completa
        } else {
            return Response.serverError()
                    .entity("{\"error\":\"Error al registrar sesión\"}")
                    .type(MediaType.APPLICATION_JSON)
                    .build();
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
            return Response.serverError()
                    .entity("{\"error\":\"Error al actualizar sesión\"}")
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") int id) {
        boolean exito = dao.eliminar(id);
        if (exito) {
            return Response.ok("Sesión eliminada correctamente").build();
        } else {
            return Response.serverError()
                    .entity("{\"error\":\"Error al eliminar sesión\"}")
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        }
    }

    @PATCH
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response cerrarSesion(@PathParam("id") int id, Sesion sesion) {
        boolean actualizado = dao.cerrarSesion(id, sesion.getFechaCierre());
        if (actualizado) {
            return Response.ok("Sesión cerrada correctamente").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"error\":\"No se pudo cerrar sesión\"}")
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        }
    }
}
