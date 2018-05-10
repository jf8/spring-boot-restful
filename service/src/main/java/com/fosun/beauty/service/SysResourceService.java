package com.fosun.beauty.service;


import com.fosun.beauty.domain.SysResource;
import com.fosun.beauty.domain.User;
import com.fosun.beauty.repository.SysResourceRepository;
import com.fosun.beauty.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


/**
 * Service Implementation for managing SysResource.
 */
@Service
@Transactional
public class SysResourceService {

    private final Logger log = LoggerFactory.getLogger(SysResourceService.class);

    private final SysResourceRepository sysResourceRepository;


    @Autowired
    private UserRepository userRepository;

    public SysResourceService(SysResourceRepository sysResourceRepository) {
        this.sysResourceRepository = sysResourceRepository;
    }

    /**
     * Save a sysResource.
     *
     * @param sysResource the entity to save
     * @return the persisted entity
     */
    public SysResource save(SysResource sysResource) {
        log.debug("Request to save SysResource : {}", sysResource);
        SysResource result = sysResourceRepository.save(sysResource);
        return result;
    }

    /**
     *  Get all the sysResources.
     *
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<SysResource> findAll() {
        log.debug("Request to get all SysResources");
        List<SysResource> result = sysResourceRepository.findAll();

        return result;
    }

    /**
     *  Get one sysResource by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true)
    public SysResource findOne(Long id) {
        log.debug("Request to get SysResource : {}", id);
        SysResource sysResource = sysResourceRepository.getOne(id);
        return sysResource;
    }

    /**
     *  Delete the  sysResource by id.
     *
     *  @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete SysResource : {}", id);
        sysResourceRepository.deleteById(id);
    }


    /**
     * query all SysResources
     *
     * @return
     */
    public List<SysResource> findAllChildSysResource() {
        return sysResourceRepository.findByPidGreaterThan(0L);
    }

    /**
     * query SysResources by parent node id
     *
     * @param pid
     * @return
     */
    public List<SysResource> findByPid(Long pid) {
        return sysResourceRepository.findByPid(pid);
    }

    /**
     * query SysResource list include children SysResource list
     *
     * @return
     */
    public List findAllToResourceMap() {
        List list = new ArrayList();
        Map map;
        List<SysResource> SysResources = sysResourceRepository.findByPid(0L);
        for (SysResource SysResource : SysResources) {
            map = new HashMap();
            map.put("sysResource", SysResource);
            map.put("childSysResources", sysResourceRepository.findByPid(SysResource.getId()));
            list.add(map);
        }
        return list;
    }

    /**
     * query SysResources by user id
     *
     * @param adminUserId
     * @return
     */
    public List<SysResource> findByAdminUserId(Long adminUserId) {
        User user = userRepository.getOne(adminUserId);
        List<SysResource> SysResources = new ArrayList<>();
        if (user.getRoles().size() > 0) {
            user.getRoles().stream().filter(role -> role.getSysResources().size() > 0).forEach(role -> SysResources.addAll(role.getSysResources().stream().filter(SysResource -> SysResource.getPid() > 0).collect(Collectors.toList())));
        }
        return SysResources;
    }


    /**
     * delete SysResource
     * if parent node id not equals 0, delete all children of the parent node id
     *
     * @param id
     */
    public void deleteById(Long id) {
        SysResource SysResource = findById(id);
        if (SysResource.getPid() == 0) {
            sysResourceRepository.deleteByPid(SysResource.getId());
        }
        sysResourceRepository.delete(SysResource);
    }

    public SysResource findById(Long id) {
        return sysResourceRepository.getOne(id);
    }

    @CacheEvict("sysResources")
    public void clearCache() {}
}
