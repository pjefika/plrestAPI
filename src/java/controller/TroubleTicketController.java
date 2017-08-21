/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DefeitosAbertosDAO;
import dao.FactoryDAO;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.enums.ProdutoTT;
import model.enums.StatusTT;

/**
 *
 * @author G0041775
 */
@Path("/tts")
public class TroubleTicketController extends RestJaxAbstract {

    DefeitosAbertosDAO dao = FactoryDAO.createTTDAO();
    
    @GET
    @Path("/linha/{quant}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response defeitosAbertos(@PathParam("quant") Integer quant) throws Exception {
        Response r;
        r = ok(dao.getTTsPorStatusPorTipo(StatusTT.PENDENTE, ProdutoTT.LINHA, quant));
        return r;
    }
    

}