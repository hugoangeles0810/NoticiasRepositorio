/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev2012.noticiasunp.repository;

import com.dev2012.noticiasunp.util.Criterio;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Hugo
 * @param <Entity>
 * @param <KeyType>
 */
public abstract class BaseRepositoryImpl<Entity extends Serializable, KeyType extends Serializable> 
    implements BaseRepository<Entity, KeyType>{
    
    @Autowired
    private SessionFactory sessionFactory;
    
    protected Class<Entity> domainClass;

    public BaseRepositoryImpl() {
        super();
        this.domainClass = (Class<Entity>) ((ParameterizedType)getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }
    
    public Session getSession(){
       return sessionFactory.getCurrentSession();
    }

    @Override
    public Entity get(KeyType key) {
        return (Entity) getSession().get(domainClass, key);
    }

    @Override
    public void save(Entity entity) {
        getSession().save(entity);
    }

    @Override
    public void update(Entity entity) {
        getSession().saveOrUpdate(entity);
    }

    @Override
    public void delete(Entity entity) {
        getSession().delete(entity);
    }
    
    @Override
    public void bulkDelete(List<Entity> entities) {
        for (Entity entity : entities) {
          getSession().delete(entity);  
        }
    }

    @Override
    public List<Entity> getAll() {
        Criterio filter = Criterio.forClass(domainClass);
        Criteria search = filter.getExecutableCriteria(getSession());
        search.setProjection(null);
        search.setFirstResult(filter.getFirstResult());
        return (List<Entity>) search.list();
    }

    @Override
    public List<Entity> searchForCriteria(Criterio criterio) {
        Criteria search = criterio.getExecutableCriteria(getSession());
        search.setProjection(null);
        search.setFirstResult(criterio.getFirstResult());
        return (List<Entity>) search.list();
    }

    @Override
    public Long countResultForCriteria(Criterio criterio) {
        Criteria search = criterio.getExecutableCriteria(getSession());
        search.setFirstResult(criterio.getFirstResult());
        search.setProjection(Projections.rowCount());
        List<Long> result = search.list();
        return result.get(0);
    }
      
}
