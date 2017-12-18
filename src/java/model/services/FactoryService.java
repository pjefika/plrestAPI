/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.services;

import model.services.massiva.EventosAfetaClienteService;
import model.services.massiva.EventosAfetaClienteServiceImpl;

/**
 *
 * @author G0042204
 */
public class FactoryService {

    public static EventosAfetaClienteService createEventosAfetaCliente() {
        return new EventosAfetaClienteServiceImpl();
    }

}
