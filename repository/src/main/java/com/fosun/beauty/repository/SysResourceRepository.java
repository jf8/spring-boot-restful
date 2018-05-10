package com.fosun.beauty.repository;

import com.fosun.beauty.domain.SysResource;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Spring Data JPA repository for the SysResource entity.
 */
@SuppressWarnings("unused")
@CacheConfig(cacheNames = "sysResource")
public interface SysResourceRepository extends JpaRepository<SysResource,Long> {

    @Cacheable
    SysResource getOne(Long id);

    @Cacheable
    List<SysResource> findByPidGreaterThan(Long pid);

    List<SysResource> findByPid(Long pid);

    void deleteByPid(Long pid);
}
