package com.fosun.beauty.repository;

import com.fosun.beauty.domain.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Spring Data JPA repository for the SysRole entity.
 */
@SuppressWarnings("unused")
public interface SysRoleRepository extends JpaRepository<SysRole,Long> {

    @Query("select distinct sysRole from SysRole sysRole left join fetch sysRole.sysResources")
    List<SysRole> findAllWithEagerRelationships();

    @Query("select sysRole from SysRole sysRole left join fetch sysRole.sysResources where sysRole.id =:id")
    SysRole findOneWithEagerRelationships(@Param("id") Long id);

    Optional<SysRole> getFirstByName(String name);

}
