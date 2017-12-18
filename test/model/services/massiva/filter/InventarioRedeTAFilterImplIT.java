/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.services.massiva.filter;

import br.net.gvt.efika.customer.EfikaCustomer;
import br.net.gvt.efika.customer.InventarioRede;
import java.util.ArrayList;
import java.util.List;
import model.entities.sigitm.TicketAnormalidade;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G0042204
 */
public class InventarioRedeTAFilterImplIT {

    public InventarioRedeTAFilterImplIT() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of filter method, of class InventarioRedeTAFilterImpl.
     */
    @Test
    public void testFilterMatchSlotNull() {
        try {

            EfikaCustomer cust = new EfikaCustomer();
            InventarioRede rede = new InventarioRede();
            rede.setIpDslam("TESTE");
            rede.setSlot(10);
            cust.setRede(rede);

            System.out.println("filter");
            List<TicketAnormalidade> lst = new ArrayList<>();
            TicketAnormalidade ta = new TicketAnormalidade();
            ta.getFttx().setHostName("TESTE");
            lst.add(ta);

            InventarioRedeTAFilterImpl instance = new InventarioRedeTAFilterImpl(cust);

            List<TicketAnormalidade> result = instance.filter(lst);
            assertTrue(!result.isEmpty());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testFilterMatchSameSlot() {
        try {
            System.out.println("testFilterMatchSameSlot");

            EfikaCustomer cust = new EfikaCustomer();
            InventarioRede rede = new InventarioRede();
            rede.setIpDslam("TESTE");
            rede.setSlot(10);
            cust.setRede(rede);

            List<TicketAnormalidade> lst = new ArrayList<>();
            TicketAnormalidade ta = new TicketAnormalidade();
            ta.getFttx().setHostName("TESTE");
            ta.getFttx().setSlot(10);
            lst.add(ta);

            InventarioRedeTAFilterImpl instance = new InventarioRedeTAFilterImpl(cust);

            List<TicketAnormalidade> result = instance.filter(lst);
            assertTrue(!result.isEmpty());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFilterSlotIgualPortaDiferente() {
        try {
            System.out.println("testFilterSlotIgualPortaDiferente");
            EfikaCustomer cust = new EfikaCustomer();
            InventarioRede rede = new InventarioRede();
            rede.setIpDslam("TESTE");
            rede.setSlot(10);
            rede.setPorta(10);
            cust.setRede(rede);

            List<TicketAnormalidade> lst = new ArrayList<>();
            TicketAnormalidade ta = new TicketAnormalidade();
            ta.getFttx().setHostName("TESTE");
            ta.getFttx().setSlot(10);
            ta.getFttx().setPorta(42);
            lst.add(ta);

            InventarioRedeTAFilterImpl instance = new InventarioRedeTAFilterImpl(cust);

            List<TicketAnormalidade> result = instance.filter(lst);
            assertTrue(result.isEmpty());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFilterSlotIgualTodasAsPortas() {
        try {
            System.out.println("testFilterMatchSameSlot");

            EfikaCustomer cust = new EfikaCustomer();
            InventarioRede rede = new InventarioRede();
            rede.setIpDslam("TESTE");
            rede.setSlot(10);
            rede.setPorta(10);
            cust.setRede(rede);

            List<TicketAnormalidade> lst = new ArrayList<>();
            TicketAnormalidade ta = new TicketAnormalidade();
            ta.getFttx().setHostName("TESTE");
            ta.getFttx().setSlot(10);
            ta.getFttx().setPorta(null);
            lst.add(ta);

            InventarioRedeTAFilterImpl instance = new InventarioRedeTAFilterImpl(cust);

            List<TicketAnormalidade> result = instance.filter(lst);
            assertTrue(!result.isEmpty());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFilterSlotIgualPortaIgual() {
        try {
            System.out.println("testFilterMatchSameSlot");

            EfikaCustomer cust = new EfikaCustomer();
            InventarioRede rede = new InventarioRede();
            rede.setIpDslam("TESTE");
            rede.setSlot(10);
            rede.setPorta(10);
            cust.setRede(rede);

            List<TicketAnormalidade> lst = new ArrayList<>();
            TicketAnormalidade ta = new TicketAnormalidade();
            ta.getFttx().setHostName("TESTE");
            ta.getFttx().setSlot(10);
            ta.getFttx().setPorta(10);
            lst.add(ta);

            InventarioRedeTAFilterImpl instance = new InventarioRedeTAFilterImpl(cust);

            List<TicketAnormalidade> result = instance.filter(lst);
            assertTrue(!result.isEmpty());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
