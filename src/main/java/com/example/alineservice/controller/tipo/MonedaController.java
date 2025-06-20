package com.example.alineservice.controller.tipo;

import com.example.alineservice.dao.MonedaDAO;
import com.example.alineservice.model.Moneda;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/monedas")
public class MonedaController {

    MonedaDAO dao = new MonedaDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Moneda> listar() {
        return dao.listar();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registrar(Moneda m) {
        boolean exito = dao.registrar(m);
        if (exito) {
            return Response.ok("Moneda registrada correctamente").build();
        } else {
            return Response.serverError().entity("Error al registrar moneda").build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizar(Moneda m) {
        boolean exito = dao.actualizar(m);
        if (exito) {
            return Response.ok("Moneda actualizada correctamente").build();
        } else {
            return Response.serverError().entity("Error al actualizar moneda").build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") int id) {
        boolean exito = dao.eliminar(id);
        if (exito) {
            return Response.ok("Moneda eliminada correctamente").build();
        } else {
            return Response.serverError().entity("Error al eliminar moneda").build();
        }
    }
}
