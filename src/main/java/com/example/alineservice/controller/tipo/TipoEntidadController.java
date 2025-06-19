package com.example.alineservice.controller.tipo;

import com.example.alineservice.dao.TipoEntidadDAO;
import com.example.alineservice.model.TipoEntidad;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/tipos-entidad")
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
    public Response registrar(TipoEntidad te) {
        boolean exito = dao.registrar(te);
        if (exito) {
            return Response.ok("Tipo de entidad registrado correctamente").build();
        } else {
            return Response.serverError().entity("Error al registrar tipo de entidad").build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizar(TipoEntidad te) {
        boolean exito = dao.actualizar(te);
        if (exito) {
            return Response.ok("Tipo de entidad actualizado correctamente").build();
        } else {
            return Response.serverError().entity("Error al actualizar tipo de entidad").build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") int id) {
        boolean exito = dao.eliminar(id);
        if (exito) {
            return Response.ok("Tipo de entidad eliminado correctamente").build();
        } else {
            return Response.serverError().entity("Error al eliminar tipo de entidad").build();
        }
    }
}
