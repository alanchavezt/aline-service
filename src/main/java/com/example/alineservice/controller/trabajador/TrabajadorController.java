package com.example.alineservice.controller.trabajador;

import com.example.alineservice.dao.TrabajadorDAO;
import com.example.alineservice.model.Trabajador;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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

    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") int id) {
        boolean exito = dao.eliminar(id);
        if (exito) {
            return Response.ok("Trabajador eliminado correctamente").build();
        } else {
            return Response.serverError().entity("Error al eliminar trabajador").build();
        }
    }
}
