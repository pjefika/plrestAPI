/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.services;

import br.net.gvt.efika.customer.EfikaCustomer;
import br.net.gvt.efika.customer.EventoMassivo;
import br.net.gvt.efika.customer.OrigemPlanta;
import dao.FactoryDAO;
import java.util.ArrayList;
import java.util.List;
import model.entities.sigitm.TicketAnormalidade;

public class EventosAfetaClienteServiceImpl implements EventosAfetaClienteService {

    private EfikaCustomer cust;

    @Override
    public List<EventoMassivo> consultar(EfikaCustomer ec) throws Exception {
        this.cust = ec;

        if (cust.getRede().getPlanta() == OrigemPlanta.VIVO1) {
            FactoryDAO.createTicketAnormalidadeDAO().consultaByIpAddress(ec.getRede().getIpDslam());

        }

        return new ArrayList<>();
    }

    public EventoMassivo parse(TicketAnormalidade ta) {
        EventoMassivo ev = new EventoMassivo();
        return ev;
    }

}
