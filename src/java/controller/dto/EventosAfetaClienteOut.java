/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dto;

import br.net.gvt.efika.customer.EventoMassivo;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author G0042204
 */
public class EventosAfetaClienteOut {

    private List<EventoMassivo> eventos;

    private Calendar dataConsulta;

    public EventosAfetaClienteOut(List<EventoMassivo> eventos) {
        this.eventos = eventos;
        this.dataConsulta = Calendar.getInstance();
    }

    public List<EventoMassivo> getEventos() {
        return eventos;
    }

    public void setEventos(List<EventoMassivo> eventos) {
        this.eventos = eventos;
    }

    public Calendar getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Calendar dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

}
