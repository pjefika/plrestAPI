/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FactoryDAO;
import dao.pl.IonixAbertosDAO;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author G0042204
 */
@Path("/ionix")
public class IonixController extends RestJaxAbstract {

    IonixAbertosDAO dao = FactoryDAO.create();
    
    @GET
    @Path("/abertas")
    @Produces(MediaType.APPLICATION_JSON)
    public Response ionixAbertas() throws Exception {
        Response r;
        r = ok(dao.getAbertos());
        return r;
    }
    

}