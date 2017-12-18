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
import javax.persistence.FetchType;
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
@Table(name = "tbl_ta", schema = "sigitm3")
public class TicketAnormalidade implements Serializable {

    @Id
    @Column(name = "TQA_CODIGO")
    private Long id;

    @Column(name = "TQA_DATA_PREVISTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataPrevista;

    @Column(name = "TQA_DATA_CRIACAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataCriacao;

    @Column(name = "TQA_DATA_ENCERRAMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataEncerramento;

    /**
     * Consulta enviada com parâmetro 1219 como critério
     */
    @Column(name = "tqa_criadopor_grupo")
    private Integer criadorId;

    @Column(name = "TQA_ALARME")
    private String alarme;

    @OneToOne(mappedBy = "ticket", fetch = FetchType.EAGER)
    private TicketAnormalidadeFttx fttx;

    public TicketAnormalidade() {
        fttx = new TicketAnormalidadeFttx();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(Calendar dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    public Calendar getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Calendar dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Calendar getDataEncerramento() {
        return dataEncerramento;
    }

    public void setDataEncerramento(Calendar dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }

    public Integer getCriadorId() {
        return criadorId;
    }

    public void setCriadorId(Integer criadorId) {
        this.criadorId = criadorId;
    }

    public String getAlarme() {
        return alarme;
    }

    public void setAlarme(String alarme) {
        this.alarme = alarme;
    }

    public TicketAnormalidadeFttx getFttx() {
        return fttx;
    }

    public void setFttx(TicketAnormalidadeFttx fttx) {
        this.fttx = fttx;
    }

}
