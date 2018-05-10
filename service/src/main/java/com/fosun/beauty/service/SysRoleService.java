package com.fosun.beauty.service;


import com.fosun.beauty.common.config.AuthoritiesConstants;
import com.fosun.beauty.domain.SysRole;
import com.fosun.beauty.repository.SysRoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


/**
 * Service Implementation for managing SysRole.
 */
@Service
@Transactional
public class SysRoleService {

    private final Logger log = LoggerFactory.getLogger(SysRoleService.class);

    private final SysRoleRepository sysRoleRepository;


    @Autowired
    private CacheManager cacheManager;

    public SysRoleService(SysRoleRepository sysRoleRepository) {
        this.sysRoleRepository = sysRoleRepository;
    }

    /**
     * Save a sysRole.
     *
     * @param sysRole the entity to save
     * @return the persisted entity
     */
    public SysRole save(SysRole sysRole) {
        log.debug("Request to save SysRole : {}", sysRole);
        SysRole result = sysRoleRepository.save(sysRole);
       // sysRoleSearchRepository.save(result);
        Cache cache = cacheManager.getCache(AuthoritiesConstants.AUTHORITIES_KEY);
        result.getUsers().forEach(user -> {
            cache.evict(user.getMobile());
        });
        return result;
    }

    /**
     *  Get all the sysRoles.
     *
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<SysRole> findAll() {
        log.debug("Request to get all SysRoles");
        List<SysRole> result = sysRoleRepository.findAllWithEagerRelationships();
        return result;
    }

    /**
     *  Get one sysRole by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true)
    public SysRole findOne(Long id) {
        log.debug("Request to get SysRole : {}", id);
        SysRole sysRole = sysRoleRepository.findOneWithEagerRelationships(id);
        return sysRole;
    }

    /**
     *  Delete the  sysRole by id.
     *
     *  @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete SysRole : {}", id);
        sysRoleRepository.deleteById(id);
       // sysRoleSearchRepository.delete(id);
    }





    Optional<SysRole> findDefaultRole(){
        return sysRoleRepository.getFirstByName(AuthoritiesConstants.USER);
    }
}
