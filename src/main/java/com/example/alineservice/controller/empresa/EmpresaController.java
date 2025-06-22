package com.example.alineservice.controller.empresa;

import com.example.alineservice.dao.EmpresaDAO;
import com.example.alineservice.model.Empresa;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/empresas")
public class EmpresaController {

    private EmpresaDAO dao = new EmpresaDAO();

    // GET: listar todas las empresas
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar() {
        List<Empresa> empresas = dao.listar();
        return Response.ok(empresas).build();
    }

    // GET: obtener empresa por ID
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerPorId(@PathParam("id") int id) {
        Empresa empresa = dao.obtenerPorId(id);
        if (empresa != null) {
            return Response.ok(empresa).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Empresa no encontrada").build();
        }
    }

    // POST: registrar nueva empresa
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registrar(Empresa empresa) {
        if (empresa.getNombreEmpresa() == null || empresa.getRuc() == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Faltan campos obligatorios").build();
        }

        boolean exito = dao.registrar(empresa);
        if (exito) {
            return Response.ok("Empresa registrada exitosamente").build();
        } else {
            return Response.serverError().entity("Error al registrar empresa").build();
        }
    }

    // PUT: actualizar empresa por ID
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizar(@PathParam("id") int id, Empresa empresa) {
        empresa.setIdEmpresa(id); // Asegura que se actualice la empresa correcta
        boolean exito = dao.actualizar(empresa);
        if (exito) {
            return Response.ok("Empresa actualizada exitosamente").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Empresa no encontrada").build();
        }
    }

    // DELETE: eliminar empresa por ID
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminar(@PathParam("id") int id) {
        boolean exito = dao.eliminar(id);
        if (exito) {
            return Response.ok("Empresa eliminada exitosamente").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Empresa no encontrada").build();
        }
    }
}
