/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities.sigitm;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author G0042204
 */
@Entity
@Table(name = "tbl_ta_multimidia_fttx", schema = "sigitm3")
public class TicketAnormalidadeFttx implements Serializable {

    @Id
    @Column(name = "TAB_CODIGO")
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TAB_TA", columnDefinition = "TQA_CODIGO")
    private TicketAnormalidade ta;

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

    @Column(name = "TAB_MASSIVA")
    private boolean massiva;

    public TicketAnormalidadeFttx() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isMassiva() {
        return massiva;
    }

    public void setMassiva(boolean massiva) {
        this.massiva = massiva;
    }

    public TicketAnormalidade getTa() {
        return ta;
    }

    public void setTa(TicketAnormalidade ta) {
        this.ta = ta;
    }

}
