/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.net.gvt.efika.customer.EfikaCustomer;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.ws.rs.core.HttpHeaders;
import model.entities.Defeito;
import model.entities.TroubleTicket;
import model.enums.ProdutoTT;
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
    }

    public List<Defeito> getPorStatusPorTipo(StatusTT status, String produto, String falha, Integer quant) {

        try {
       
            Query query = getEm().createQuery("FROM Defeito t WHERE t.status =:param1 and t.produto =:param2 and t.falha =:param3 and t.data > current_date-1 and rownum <:param4 ORDER BY t.data DESC");
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

    public List<TroubleTicket> getTTsPorStatusPorTipo(StatusTT status, String produto, String falha, Integer quant) {
        List<Defeito> lD = getPorStatusPorTipo(status, produto, falha, quant);
        
        List<TroubleTicket> lT = new ArrayList<>();
        lD.forEach((t) -> {
            TroubleTicket tt = new TroubleTicket(t, getCustomer(t.getInstancia()));
            System.out.println(tt.getDefeito().getSs());
            System.out.println(tt.getDefeito().getInstancia());
            System.out.println(tt.getEc().getInstancia());
            lT.add(tt);
        });
        return lT;
    }
    
    public EfikaCustomer getCustomer(String instancia) {
        try {

            PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
            cm.setMaxTotal(1);
            cm.setDefaultMaxPerRoute(1);
            HttpHost ip = new HttpHost("10.40.195.81", 8080);
            cm.setMaxPerRoute(new HttpRoute(ip), 50);

            // Cookies
            RequestConfig globalConfig = RequestConfig.custom()
                    .setCookieSpec(CookieSpecs.DEFAULT)
                    .build();

            CloseableHttpClient httpclient = HttpClients.custom()
                    .setConnectionManager(cm)
                    .setDefaultRequestConfig(globalConfig)
                    .build();

            HttpGet httpget = new HttpGet("http://10.40.195.81:8080/stealerAPI/oss/" + instancia);
            httpget.setHeader(HttpHeaders.CONTENT_TYPE, "text/html");
            CloseableHttpResponse response = httpclient.execute(httpget);
            InputStream instream = response.getEntity().getContent();
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuffer result = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            instream.close();

            Gson g = new Gson();

            EfikaCustomer ec = g.fromJson(result.toString(), EfikaCustomer.class);

            return ec;
        } catch (Exception e) {
            return null;
        }
    }

}
