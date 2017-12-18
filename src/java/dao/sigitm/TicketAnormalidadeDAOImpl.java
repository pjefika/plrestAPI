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

    public TicketAnormalidadeDAOImpl() {
        super("sigitmPU");
    }

    @Override
    public List<TicketAnormalidade> consultaByIpAddress(String ipAddress) throws Exception {

        try {
            return (List<TicketAnormalidade>) getEm()
                    .createQuery("SELECT t FROM TicketAnormalidade t LEFT OUTER JOIN t.fttx f "
                            + "WHERE 1=1 "
                            + "AND f.ipAddress =:param1 "
                            + "AND f.massiva =:param2 "
                            + "AND t.dataEncerramento IS NULL")
                    .setParameter("param1", ipAddress)
                    .setParameter("param2", true)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }

    }

}
