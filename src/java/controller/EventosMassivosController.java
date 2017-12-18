/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.dto.EventosAfetaClienteIn;
import controller.dto.EventosAfetaClienteOut;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.services.FactoryService;
import model.services.massiva.EventosAfetaClienteService;

/**
 *
 * @author G0041775
 */
@Path("/eventosMassivos")
public class EventosMassivosController extends RestJaxAbstract {

    private EventosAfetaClienteService serv;

    @POST
    @Path("/afetaCliente")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response eventosAfetaCliente(EventosAfetaClienteIn in) throws Exception {
        try {
            serv = FactoryService.createEventosAfetaCliente();
            return ok(new EventosAfetaClienteOut(serv.consultar(in.getCust())));
        } catch (Exception e) {
            return serverError(e);
        }
    }

}
