/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dto;

import br.net.gvt.efika.customer.EventoMassivo;
import java.util.List;

/**
 *
 * @author G0042204
 */
public class EventosAfetaClienteOut extends AbstractDTO {

    private List<EventoMassivo> eventos;

    public EventosAfetaClienteOut() {
    }

    public EventosAfetaClienteOut(List<EventoMassivo> eventos) {
        this.eventos = eventos;
    }

    public List<EventoMassivo> getEventos() {
        return eventos;
    }

    public void setEventos(List<EventoMassivo> eventos) {
        this.eventos = eventos;
    }

}
