/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev2012.noticiasunp.service;

import com.dev2012.noticiasunp.repository.BaseRepository;
import com.dev2012.noticiasunp.util.Criterio;
import java.io.Serializable;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Hugo
 * @param <Entity>
 * @param <KeyType>
 */
@Transactional
public abstract class BaseServiceImpl<Entity extends Serializable, KeyType extends Serializable> 
            implements BaseService<Entity, KeyType>{
    
    private BaseRepository<Entity, KeyType> baseRepository;
    
    protected BaseServiceImpl(BaseRepository<Entity, KeyType> baseRepository){
        this.baseRepository = baseRepository;
    }

    @Override
    public Entity get(KeyType key) {
        return baseRepository.get(key);
    }

    @Override
    public void save(Entity entity) {
        baseRepository.save(entity);
    }

    @Override
    public void update(Entity entity) {
        baseRepository.update(entity);
    }

    @Override
    public void delete(Entity entity) {
        baseRepository.delete(entity);
    }
    
    @Override
    public void bulkDelete(List<Entity> entities){
        baseRepository.bulkDelete(entities);
    }

    @Override
    public List<Entity> getAll() {
        return baseRepository.getAll();
    }

    @Override
    public List<Entity> searchForCriteria(Criterio criterio) {
        return baseRepository.searchForCriteria(criterio);
    }

    @Override
    public Long countResultForCriteria(Criterio criterio) {
        return baseRepository.countResultForCriteria(criterio);
    }
    
}
