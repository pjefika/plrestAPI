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
import javax.persistence.JoinColumn;
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
    @Column(name = "TQA_CRIADOPOR_GRUPO")
    private Integer criadorId;

    @Column(name = "TQA_ALARME")
    private String alarme;

    @Column(name = "TQA_ALARME_TIPO")
    private String tipoAlarme;

    @Column(name = "TQA_TIPO_AFETACAO")
    private String tipoAfetacao;

    @Column(name = "TQA_TIPO_FALHA")
    private String tipoFalha;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "ta")
    private TicketAnormalidadeFttx fttx;

    public TicketAnormalidade() {
        this.fttx = new TicketAnormalidadeFttx();
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

    public String getTipoAfetacao() {
        return tipoAfetacao;
    }

    public void setTipoAfetacao(String tipoAfetacao) {
        this.tipoAfetacao = tipoAfetacao;
    }

    public String getTipoFalha() {
        return tipoFalha;
    }

    public void setTipoFalha(String tipoFalha) {
        this.tipoFalha = tipoFalha;
    }

    public String getTipoAlarme() {
        return tipoAlarme;
    }

    public void setTipoAlarme(String tipoAlarme) {
        this.tipoAlarme = tipoAlarme;
    }

    public TicketAnormalidadeFttx getFttx() {
        return fttx;
    }

    public void setFttx(TicketAnormalidadeFttx fttx) {
        this.fttx = fttx;
    }

}
