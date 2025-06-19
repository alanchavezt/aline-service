package com.example.alineservice.controller.empresa;

import com.example.alineservice.dao.EmpresaDAO;
import com.example.alineservice.model.Empresa;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/empresas")
public class EmpresaController {

    private EmpresaDAO dao = new EmpresaDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Empresa> listar() {
        return dao.listar();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registrar(Empresa empresa) {
        boolean exito = dao.registrar(empresa);
        if (exito) {
            return Response.ok("Empresa registrada exitosamente").build();
        } else {
            return Response.serverError().entity("Error al registrar empresa").build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizar(Empresa empresa) {
        boolean exito = dao.actualizar(empresa);
        if (exito) {
            return Response.ok("Empresa actualizada exitosamente").build();
        } else {
            return Response.serverError().entity("Error al actualizar empresa").build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") int id) {
        boolean exito = dao.eliminar(id);
        if (exito) {
            return Response.ok("Empresa eliminada exitosamente").build();
        } else {
            return Response.serverError().entity("Error al eliminar empresa").build();
        }
    }
}
