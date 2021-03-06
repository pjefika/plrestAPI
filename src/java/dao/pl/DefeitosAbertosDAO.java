/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.pl;

import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.util.dao.http.HttpDAO;
import br.net.gvt.efika.util.dao.http.Urls;
import br.net.gvt.efika.util.dao.http.factory.FactoryHttpDAOAbstract;
import com.google.gson.Gson;
import dao.hibernate.AbstractHibernateDAO;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.ws.rs.core.HttpHeaders;
import model.CustomerRequest;
import model.entities.Defeito;
import model.entities.TroubleTicket;
import model.enums.RedeAcesso;
import model.enums.StatusTT;
import org.apache.http.HttpHost;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

/**
 *
 * @author G0041775
 */
public class DefeitosAbertosDAO extends AbstractHibernateDAO {

    public DefeitosAbertosDAO() {
        super("plrestAPIPU");
    }

    public List<Defeito> getPorStatusPorTipo(StatusTT status, String produto, String falha, RedeAcesso rede, Integer quant) {

        try {

            String condRede = rede.equals(RedeAcesso.VIVO1) ? "t.armario is null" : "t.armario is not null";

            Query query = getEm().createQuery("FROM Defeito t WHERE t.status =:param1 and t.produto =:param2 and t.falha =:param3 and " + condRede + " and t.data > current_date-1 and rownum <:param4 ORDER BY t.data DESC");

            query.setParameter("param1", status.toString().toUpperCase());
            query.setParameter("param2", produto.toUpperCase());
            query.setParameter("param3", falha.toUpperCase());
            query.setParameter("param4", new Long(quant));

            return (List<Defeito>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }

    }

    public List<String> getProdutos() {
        try {
            Query query = getEm().createQuery("SELECT DISTINCT(t.produto) FROM Defeito t");
            return (List<String>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<String> getFalhas(String prod) {
        try {
            Query query = getEm().createQuery("SELECT DISTINCT(t.falha) FROM Defeito t WHERE t.produto =:param1");
            query.setParameter("param1", prod.toUpperCase());
            return (List<String>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<TroubleTicket> getTTsPorStatusPorTipo(StatusTT status, String produto, String falha, RedeAcesso rede, Integer quant) {
        List<Defeito> lD = getPorStatusPorTipo(status, produto, falha, rede, quant);

        List<TroubleTicket> lT = new ArrayList<>();
        lD.forEach((t) -> {
            TroubleTicket tt = new TroubleTicket(t, getCustomer(t.getInstancia()));
//            System.out.println(tt.getDefeito().getSs());
//            System.out.println(tt.getDefeito().getInstancia());
//            System.out.println(tt.getEc().getInstancia());
            lT.add(tt);
        });
        return lT;
    }

    public List<TroubleTicket> getTTsPorStatusPorTipo(StatusTT status, String produto, String falha, RedeAcesso rede, Integer start, Integer quant) {
        List<Defeito> lD = getPorStatusPorTipo(status, produto, falha, rede, start + quant);
        List<TroubleTicket> lT = new ArrayList<>();
        Integer leStart = lD.size() < start ? 0 : start;
        Integer leQuant = lD.size() < quant + start ? lD.size() : quant + start;

        for (int i = leStart; i < leQuant; i++) {
            TroubleTicket tt = new TroubleTicket(lD.get(i), getCustomer(lD.get(i).getInstancia()));
            lT.add(tt);
            try {
                Thread.sleep(300);
            } catch (Exception e) {
            }

        }

        return lT;
    }

    public EfikaCustomer getCustomer(String instancia) {

        try {
            FactoryHttpDAOAbstract<EfikaCustomer> fac = new FactoryHttpDAOAbstract<>(EfikaCustomer.class);
            return (EfikaCustomer) fac.createWithoutProxy().post(Urls.CADASTRO_STEALER.getUrl(),
                    new CustomerRequest(instancia, "plrestAPI"));

        } catch (Exception e) {
            return null;
        }
    }

}
