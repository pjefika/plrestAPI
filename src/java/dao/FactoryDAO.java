/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.pl.DefeitosAbertosDAO;
import dao.pl.IonixAbertosDAO;
import dao.sigitm.TicketAnormalidadeDAO;
import dao.sigitm.TicketAnormalidadeDAOImpl;

/**
 *
 * @author G0042204
 */
public class FactoryDAO {

    public static IonixAbertosDAO create() {
        return new IonixAbertosDAO();
    }

    public static DefeitosAbertosDAO createTTDAO() {
        return new DefeitosAbertosDAO();
    }

    public static TicketAnormalidadeDAO createTicketAnormalidadeDAO() {
        return new TicketAnormalidadeDAOImpl();
    }

}
