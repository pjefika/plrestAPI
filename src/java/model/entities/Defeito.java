/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author G0041775
 */
@Entity
@Table(name = "PL_TT_WO")
public class Defeito implements Serializable {

    @Id
    @Column(name = "ID")
    private String ss;

    @Column(name = "DATA_STATUS")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "TELEPHONENUMBER")
    private String instancia;

    @Column(name = "ARMARIO")
    private String armario;

    @Column(name = "SPECIFICATION_PRODUCT")
    private String produto;

    @Column(name = "DETAIL")
    private String falha;

    public Defeito() {
    }

    public String getSs() {
        return ss;
    }

    public void setSs(String ss) {
        this.ss = ss;
    }

    public Date getDataStatus() {
        return data;
    }

    public void setDataStatus(Date dataStatus) {
        this.data = dataStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInstancia() {
        return instancia;
    }

    public void setInstancia(String instancia) {
        this.instancia = instancia;
    }

    public String getArmario() {
        return armario;
    }

    public void setArmario(String armario) {
        this.armario = armario;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getFalha() {
        return falha;
    }

    public void setFalha(String falha) {
        this.falha = falha;
    }

   

}
