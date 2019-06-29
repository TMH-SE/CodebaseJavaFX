/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.lang.reflect.Field;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Query;

/**
 *
 * @author minhh
 * @param <T>
 */
public abstract class GeneralCRUD<T> {

    protected EntityManager em;

    public GeneralCRUD() {
        em = MyEntityManagerFactory.getInstance().getEntityManager();
    }

    //crud
    public boolean save(T t) {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.persist(t);
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
        }
        return false;
    }

    public boolean update(T t) {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.merge(t);
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
        }
        return false;
    }

    public boolean delete(T t) {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.remove(t);
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
        }
        return false;
    }

    public List<T> getAll(Class<T> t) {
        String sql="select t from "+ t.getName()+" t where t.trangThai = 1";
        Query q=em.createQuery(sql);
        return q.getResultList();
    }
    
    public List<T> getByCondition(Class<T> t, String nameCondition, Object condition) {
        String query = t.getName().split("\\.")[1] + ".findBy" + nameCondition;
        NamedQuery[] namedQueries = t.getAnnotation(NamedQueries.class).value();
        for (NamedQuery namedQuery : namedQueries) {
            if (query.equalsIgnoreCase(namedQuery.name())) {
                String parameter = "";
                for(Field field : t.getDeclaredFields()){
                    if (nameCondition.equalsIgnoreCase(field.getName())) {
                        parameter = field.getName();
                    }
                }
                return em.createNamedQuery(namedQuery.name()).setParameter(parameter, condition).getResultList();
            }
        }
        return null;
    }

}
