/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.pl;

import dao.hibernate.AbstractHibernateDAO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import model.entities.Ionix;

/**
 *
 * @author G0041775
 */
public class IonixAbertosDAO extends AbstractHibernateDAO {

    public IonixAbertosDAO() {
    }

    public List<Ionix> getAbertos() {

        try {
            
            Query query =  getEm().createQuery("FROM Ionix");
            
            return (List<Ionix>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }

    }

}
