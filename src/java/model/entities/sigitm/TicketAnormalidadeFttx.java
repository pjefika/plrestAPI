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

    @Column(name = "TAB_IP")
    private String ipAddress;

    @Column(name = "TAB_RACK")
    private Integer rack;

    @Column(name = "TAB_SUBRACK")
    private Integer subrack;

    @Column(name = "TAB_SLOT")
    private Integer slot;

    @Column(name = "TAB_PORTA")
    private Integer porta;

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

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Integer getRack() {
        return rack;
    }

    public void setRack(Integer rack) {
        this.rack = rack;
    }

    public Integer getSubrack() {
        return subrack;
    }

    public void setSubrack(Integer subrack) {
        this.subrack = subrack;
    }

    public Integer getSlot() {
        return slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }

    public Integer getPorta() {
        return porta;
    }

    public void setPorta(Integer porta) {
        this.porta = porta;
    }

}
