package com.example.alineservice.controller.tipo;

import com.example.alineservice.dao.TipoEntidadDAO;
import com.example.alineservice.model.TipoEntidad;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/tipoentidades")
public class TipoEntidadController {

    TipoEntidadDAO dao = new TipoEntidadDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TipoEntidad> listar() {
        return dao.listar();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registrar(TipoEntidad entidad) {
        boolean exito = dao.registrar(entidad);
        if (exito) {
            return Response.ok("Tipo de entidad registrada correctamente").build();
        } else {
            return Response.serverError().entity("Error al registrar tipo de entidad").build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizar(TipoEntidad entidad) {
        boolean exito = dao.actualizar(entidad);
        if (exito) {
            return Response.ok("Tipo de entidad actualizada correctamente").build();
        } else {
            return Response.serverError().entity("Error al actualizar tipo de entidad").build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") int id) {
        boolean exito = dao.eliminar(id);
        if (exito) {
            return Response.ok("Tipo de entidad eliminada correctamente").build();
        } else {
            return Response.serverError().entity("Error al eliminar tipo de entidad").build();
        }
    }
}
