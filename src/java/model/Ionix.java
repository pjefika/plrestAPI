/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author G0041775
 */
public class Ionix {

    private Long ionixNumber;

    private Date dataAbertura;

    private Integer rin;

    private String motivo, armario;

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

    public Integer getRin() {
        return rin;
    }

    public void setRin(Integer rin) {
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
