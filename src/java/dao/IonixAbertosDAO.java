/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import model.Ionix;

/**
 *
 * @author G0041775
 */
public class IonixAbertosDAO extends AbstractHibernateDAO {

    public IonixAbertosDAO() {
    }

    public List<Ionix> getAbertos() {

        try {
            
            Query query =  getEm().createQuery("SELECT T.NUMERO_IONIX, T.DATA_ABERTURA, C.RIN, M.MOTIVO, C.ARMARIO "
                    + "FROM PLC7_IONIX_TRATAMENTO T, PLC7_IONIX_CHECKLIST C, PLC7_IONIX_MOTIVO M, PLC7_IONIX_TECNOLOGIA TEC "
                    + "WHERE T.ID_CHECKLIST = C.ID AND C.ID_MOTIVO = M.ID_MOTIVO AND C.ID_TECNOLOGIA = TEC.ID_TECNOLOGIA AND T.ID_STATUS = 4");
            
            return (List<Ionix>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }

    }

}
