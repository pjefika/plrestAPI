/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import util.Command;

/**
 *
 * @author G0042204
 */
public abstract class AbstractHibernateDAO {

    private EntityManagerFactory emf;

    private EntityManager em;

    private String persistenceUnit;

    public AbstractHibernateDAO(String persistenceUnit) {
        this.persistenceUnit = persistenceUnit;
    }

    public void persist(Object obj) throws Exception {
        getEm().getTransaction().begin();
        getEm().persist(obj);
        getEm().getTransaction().commit();
    }

    public EntityManager getEm() {
        if (emf == null) {
            // plrestAPIPU
            emf = Persistence.createEntityManagerFactory(persistenceUnit);
            em = emf.createEntityManager();
        }
        return em;
    }

    public void close() {
        new Command() {
            @Override
            public void exec() {
                em.close();
            }
        }.command();
        new Command() {
            @Override
            public void exec() {
                emf.close();
            }
        }.command();
    }

}
