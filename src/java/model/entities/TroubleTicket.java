/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import java.io.Serializable;

/**
 *
 * @author G0041775
 */
public class TroubleTicket implements Serializable {

    private Defeito defeito;
    
    private EfikaCustomer ec;

    public TroubleTicket() {
    }

    public TroubleTicket(Defeito defeito, EfikaCustomer ec) {
        this.defeito = defeito;
        this.ec = ec;
    }
    
    

    public Defeito getDefeito() {
        return defeito;
    }

    public void setDefeito(Defeito defeito) {
        this.defeito = defeito;
    }

    public EfikaCustomer getEc() {
        return ec;
    }

    public void setEc(EfikaCustomer ec) {
        this.ec = ec;
    }
    
    
   

}
