/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.sigitm;

import dao.hibernate.AbstractHibernateDAO;
import java.util.ArrayList;
import java.util.List;
import model.entities.sigitm.TicketAnormalidade;

public class TicketAnormalidadeDAOImpl extends AbstractHibernateDAO implements TicketAnormalidadeDAO {

    @Override
    public List<TicketAnormalidade> consultaByIpAddress(String ipAddress) throws Exception {

        try {
            return (List<TicketAnormalidade>) getEm()
                    .createQuery("FROM TicketAnormalidade t WHERE 1=1 "
                            + "AND t.fttx.ipAddress =:param1 "
                            // + "AND t.criadorId = 1219 "
                            + "AND t.dataEncerramento IS NULL ")
                    .setParameter("param1", ipAddress)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }

    }

}
