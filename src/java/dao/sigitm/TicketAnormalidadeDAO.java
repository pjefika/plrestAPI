/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.sigitm;

import java.util.List;
import model.entities.sigitm.TicketAnormalidade;

/**
 *
 * @author G0042204
 */
public interface TicketAnormalidadeDAO {

    public List<TicketAnormalidade> consultaByIpAddress(String ipAddress) throws Exception;

}
