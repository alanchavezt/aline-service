package com.example.alineservice.controller.moneda;

import com.example.alineservice.dao.MonedaDAO;
import com.example.alineservice.model.Moneda;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/monedas")
public class MonedaController {

    private MonedaDAO dao = new MonedaDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Moneda> listar() {
        return dao.listar();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registrar(Moneda moneda) {
        boolean exito = dao.registrar(moneda);
        if (exito) {
            return Response.ok("Moneda registrada correctamente").build();
        } else {
            return Response.serverError().entity("Error al registrar moneda").build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizar(Moneda moneda) {
        boolean exito = dao.actualizar(moneda);
        if (exito) {
            return Response.ok("Moneda actualizada correctamente").build();
        } else {
            return Response.serverError().entity("Error al actualizar moneda").build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminar(@PathParam("id") int id) {
        boolean exito = dao.eliminar(id);
        if (exito) {
            return Response.ok("Moneda eliminada correctamente").build();
        } else {
            return Response.serverError().entity("Error al eliminar moneda").build();
        }
    }
}
