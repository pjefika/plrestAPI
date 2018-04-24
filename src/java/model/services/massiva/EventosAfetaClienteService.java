/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.services.massiva;

import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.efika_customer.model.customer.EventoMassivo;
import java.util.List;

/**
 *
 * @author G0042204
 */
public interface EventosAfetaClienteService {

    public List<EventoMassivo> consultar(EfikaCustomer ec) throws Exception;

}
