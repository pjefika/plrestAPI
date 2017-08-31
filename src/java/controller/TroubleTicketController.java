/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DefeitosAbertosDAO;
import dao.FactoryDAO;
import javax.ws.rs.Encoded;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.enums.ProdutoTT;
import model.enums.RedeAcesso;
import model.enums.StatusTT;

/**
 *
 * @author G0041775
 */
@Path("/tts")
public class TroubleTicketController extends RestJaxAbstract {

    DefeitosAbertosDAO dao = FactoryDAO.createTTDAO();
    
    @GET
    @Path("/{prod}/{falha}/{rede}/{quant}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response defeitosAbertos(@PathParam("prod") String prod, @PathParam("falha") String falha, @PathParam("rede") String rede, @PathParam("quant") Integer quant) throws Exception {
        Response r;
        r = ok(dao.getTTsPorStatusPorTipo(StatusTT.PENDENTE, prod, falha, RedeAcesso.valueOf(rede.toUpperCase()), quant));
        return r;
    }
    
    @GET
    @Path("/{prod}/{falha}/{rede}/{start}-{quant}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response defeitosAbertos(@PathParam("prod") String prod, @PathParam("falha") String falha, @PathParam("rede") String rede, @PathParam("start") Integer start, @PathParam("quant") Integer quant) throws Exception {
        Response r;
        r = ok(dao.getTTsPorStatusPorTipo(StatusTT.PENDENTE, prod, falha, RedeAcesso.valueOf(rede.toUpperCase()), start, quant));
        return r;
    }
    
    @GET
    @Path("/prods")
    @Produces(MediaType.APPLICATION_JSON)
    public Response defeitosAbertos() throws Exception {
        Response r;
        r = ok(dao.getProdutos());
        return r;
    }
    
    @GET
    @Path("/{prod}/falhas")
    @Produces(MediaType.APPLICATION_JSON)
    public Response defeitosAbertos(@PathParam("prod") String prod) throws Exception {
        Response r;
        r = ok(dao.getFalhas(prod));
        return r;
    }
    
    

}