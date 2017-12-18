/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.services.massiva;

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

        List<EventoMassivo> eventos = new ArrayList<>();

        if (cust.getRede().getPlanta() == OrigemPlanta.VIVO1) {
            List<TicketAnormalidade> tas = FactoryDAO.createTicketAnormalidadeDAO().consultaByIpAddress(ec.getRede().getIpDslam());
            tas.forEach((t) -> {
                try {
                    eventos.add(this.parse(t));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        return eventos;
    }

    public static EventoMassivo parse(TicketAnormalidade ta) {
        EventoMassivo ev = new EventoMassivo();
        ev.setDesc(ta.getAlarme());
        ev.setTipoAfetacao(ta.getTipoAfetacao());
        ev.setTipoAlarme(ta.getTipoAlarme());
        ev.setTipoFalha(ta.getTipoFalha());
        
        return ev;
    }

}