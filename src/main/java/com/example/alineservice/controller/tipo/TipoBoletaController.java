package com.example.alineservice.controller.tipo;

import com.example.alineservice.dao.TipoBoletaDAO;
import com.example.alineservice.model.TipoBoleta;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/tipoboletas")
public class TipoBoletaController {

    TipoBoletaDAO dao = new TipoBoletaDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TipoBoleta> listar() {
        return dao.listar();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registrar(TipoBoleta tb) {
        boolean exito = dao.registrar(tb);
        if (exito) {
            return Response.ok("Tipo de boleta registrado correctamente").build();
        } else {
            return Response.serverError().entity("Error al registrar tipo de boleta").build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizar(TipoBoleta tb) {
        boolean exito = dao.actualizar(tb);
        if (exito) {
            return Response.ok("Tipo de boleta actualizado correctamente").build();
        } else {
            return Response.serverError().entity("Error al actualizar tipo de boleta").build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") int id) {
        boolean exito = dao.eliminar(id);
        if (exito) {
            return Response.ok("Tipo de boleta eliminado correctamente").build();
        } else {
            return Response.serverError().entity("Error al eliminar tipo de boleta").build();
        }
    }
}
