package com.example.alineservice.controller.trabajador;

import com.example.alineservice.dao.TrabajadorDAO;
import com.example.alineservice.model.Trabajador;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/trabajadores")
public class TrabajadorController {

    TrabajadorDAO dao = new TrabajadorDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Trabajador> listar() {
        return dao.listar();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registrar(Trabajador t) {
        boolean exito = dao.registrar(t);
        if (exito) {
            return Response.ok("Trabajador registrado correctamente").build();
        } else {
            return Response.serverError().entity("Error al registrar trabajador").build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizar(Trabajador t) {
        boolean exito = dao.actualizar(t);
        if (exito) {
            return Response.ok("Trabajador actualizado correctamente").build();
        } else {
            return Response.serverError().entity("Error al actualizar trabajador").build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminar(@PathParam("id") int id) {
        boolean exito = dao.eliminar(id);
        if (exito) {
            return Response.ok("Trabajador eliminado correctamente").build();
        } else {
            return Response.serverError().entity("Error al eliminar trabajador").build();
        }
    }
}
