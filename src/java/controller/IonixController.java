/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.LeModel;

/**
 *
 * @author G0042204
 */
@Path("/ionix")
public class IonixController extends RestJaxAbstract {

    @GET
    @Path("/abertas")
    @Produces(MediaType.APPLICATION_JSON)
    public Response ionixAbertas() throws Exception {
        Response r;

        r = ok(new LeModel("oi"));
        return r;
    }

}
