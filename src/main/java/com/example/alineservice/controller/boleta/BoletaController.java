package com.example.alineservice.controller.boleta;

import com.example.alineservice.dao.BoletaDAO;
import com.example.alineservice.model.Boleta;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
}
