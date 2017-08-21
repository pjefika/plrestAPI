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
@Table(name = "IONIX_ABERTOS")
public class Ionix implements Serializable {

    @Id
    @Column(name = "NUMERO_IONIX")
    private Long ionixNumber;

    @Column(name = "DATA_ABERTURA")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataAbertura;

    @Column(name = "RIN")
    private String rin;

    @Column(name = "MOTIVO")
    private String motivo;

    @Column(name = "ARMARIO")
    private String armario;

    public Ionix() {
    }

    public Long getIonixNumber() {
        return ionixNumber;
    }

    public void setIonixNumber(Long ionixNumber) {
        this.ionixNumber = ionixNumber;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getRin() {
        return rin;
    }

    public void setRin(String rin) {
        this.rin = rin;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getArmario() {
        return armario;
    }

    public void setArmario(String armario) {
        this.armario = armario;
    }

}
