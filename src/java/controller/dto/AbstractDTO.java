/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dto;

import java.util.Calendar;

/**
 *
 * @author G0042204
 */
public abstract class AbstractDTO {

    private Calendar dateIn;

    private Calendar dateOut;

    private String executor;

    private String system;

    public Calendar getDateIn() {
        return dateIn;
    }

    public void setDateIn(Calendar dateIn) {
        this.dateIn = dateIn;
    }

    public Calendar getDateOut() {
        return dateOut;
    }

    public void setDateOut(Calendar dateOut) {
        this.dateOut = dateOut;
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

}
