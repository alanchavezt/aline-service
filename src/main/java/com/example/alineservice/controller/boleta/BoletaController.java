package com.example.alineservice.controller.boleta;

import com.example.alineservice.dao.BoletaDAO;
import com.example.alineservice.model.Boleta;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/boletas")
public class BoletaController {

    BoletaDAO dao = new BoletaDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Boleta> listar() {
        return dao.listar();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registrar(Boleta b) {
        boolean exito = dao.registrar(b);
        if (exito) {
            return Response.ok("Boleta registrada correctamente").build();
        } else {
            return Response.serverError().entity("Error al registrar boleta").build();
        }
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizar(Boleta boleta) {
        boolean actualizado = dao.actualizar(boleta);
        if (actualizado) {
            return Response.ok("Boleta actualizada correctamente").build();
        } else {
            return Response.serverError().entity("Error al actualizar boleta").build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") int id) {
        boolean exito = dao.eliminar(id);
        if (exito) {
            return Response.ok("Boleta eliminada correctamente").build();
        } else {
            return Response.serverError().entity("Error al eliminar boleta").build();
        }
    }
}
