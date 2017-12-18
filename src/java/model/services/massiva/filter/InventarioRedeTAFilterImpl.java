/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.services.massiva.filter;

import br.net.gvt.efika.customer.EfikaCustomer;
import java.util.ArrayList;
import java.util.List;
import model.entities.sigitm.TicketAnormalidade;

public class InventarioRedeTAFilterImpl implements Filter<TicketAnormalidade> {

    private final EfikaCustomer cust;

    private final List<TicketAnormalidade> retorno;

    public InventarioRedeTAFilterImpl(EfikaCustomer cust) {
        this.cust = cust;
        this.retorno = new ArrayList<>();
    }

    @Override
    public List<TicketAnormalidade> filter(List<TicketAnormalidade> lst) {
        for (TicketAnormalidade ta : lst) {
            if (ta.getFttx().getSlot() == null) {
                retorno.add(ta);
                break;
            } else {
                if (ta.getFttx().getSlot().intValue() == cust.getRede().getSlot().intValue()) {
                    if (ta.getFttx().getPorta() == null) {
                        retorno.add(ta);
                        break;
                    } else {
                        if (ta.getFttx().getPorta().intValue() == cust.getRede().getPorta().intValue()) {
                            retorno.add(ta);
                            break;
                        }
                    }
                }
            }
        }
        return retorno;

    }

}
