/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities.sigitm;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author G0042204
 */
@Entity
@Table(name = "tbl_ta_multimidia_fttx", schema = "sigitm3")
public class TicketAnormalidadeFttx implements Serializable {

    @Id
    @Column(name = "TQA_CODIGO")
    private Long id;

    @OneToOne
    private TicketAnormalidade ticket;

    @Column(name = "TQA_DATA_PREVISTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataPrevista;

    @Column(name = "TAB_HOSTNAME")
    private String hostName;

    public TicketAnormalidadeFttx() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TicketAnormalidade getTicket() {
        return ticket;
    }

    public void setTicket(TicketAnormalidade ticket) {
        this.ticket = ticket;
    }

    public Calendar getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(Calendar dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

}
