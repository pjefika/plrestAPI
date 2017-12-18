/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.dto.ConsultaEventosAfetaCliente;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.enums.RedeAcesso;
import model.enums.StatusTT;

/**
 *
 * @author G0041775
 */
@Path("/eventosMassivos")
public class EventosMassivosController extends RestJaxAbstract {

    @POST
    @Path("/afetaCliente")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response eventosAfetaCliente(ConsultaEventosAfetaCliente in) throws Exception {
        Response r = null;

        return r;
    }

}
