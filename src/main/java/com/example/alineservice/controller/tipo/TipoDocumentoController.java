package com.example.alineservice.controller.tipo;

import com.example.alineservice.dao.TipoDocumentoDAO;
import com.example.alineservice.model.TipoDocumento;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/tipos-documento")
public class TipoDocumentoController {

    TipoDocumentoDAO dao = new TipoDocumentoDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TipoDocumento> listar() {
        return dao.listar();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registrar(TipoDocumento td) {
        boolean exito = dao.registrar(td);
        if (exito) {
            return Response.ok("Tipo de documento registrado correctamente").build();
        } else {
            return Response.serverError().entity("Error al registrar tipo de documento").build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizar(TipoDocumento td) {
        boolean exito = dao.actualizar(td);
        if (exito) {
            return Response.ok("Tipo de documento actualizado correctamente").build();
        } else {
            return Response.serverError().entity("Error al actualizar tipo de documento").build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") int id) {
        boolean exito = dao.eliminar(id);
        if (exito) {
            return Response.ok("Tipo de documento eliminado correctamente").build();
        } else {
            return Response.serverError().entity("Error al eliminar tipo de documento").build();
        }
    }
}
