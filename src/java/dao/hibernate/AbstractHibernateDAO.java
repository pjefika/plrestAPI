/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.hibernate;

import br.net.gvt.efika.customer.EfikaCustomer;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.HttpHeaders;
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
 * @author G0042204
 */
public class AbstractHibernateDAO {

    private EntityManagerFactory emf;

    private EntityManager em;

    public void persist(Object obj) throws Exception {
        getEm().getTransaction().begin();
        getEm().persist(obj);
        getEm().getTransaction().commit();
    }

    public EntityManager getEm() {
        if (emf == null) {
            
            emf = Persistence.createEntityManagerFactory("plrestAPIPU");
            
            em = emf.createEntityManager();
        }
        return em;
    }

    public void close() {
        if (emf.isOpen()) {
            em.close();
            emf.close();
        }
    }
    
    

}
