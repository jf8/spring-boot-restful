package com.fosun.beauty.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.fosun.beauty.common.util.HeaderUtil;
import com.fosun.beauty.common.web.util.ResponseUtil;
import com.fosun.beauty.domain.SysRole;
import com.fosun.beauty.service.SysResourceService;
import com.fosun.beauty.service.SysRoleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.Optional;


/**
 * REST controller for managing SysRole.
 */
@RestController
@RequestMapping("/api")
@Api(tags = "用户角色")
public class SysRoleResource {

    private final Logger log = LoggerFactory.getLogger(SysRoleResource.class);

    private static final String ENTITY_NAME = "sysRole";

    private final SysRoleService sysRoleService;

    public SysRoleResource(SysRoleService sysRoleService) {
        this.sysRoleService = sysRoleService;
    }

    @Autowired
    private SysResourceService sysResourceService;

    @GetMapping("/sys-roles/sys-resources/map")
    @Timed
    @ApiOperation("获取权限MAP")
    public List<Map> getAllSysResourcesMap() {
        log.debug("REST request to get all SysResources");
        return sysResourceService.findAllToResourceMap();
    }

    /**
     * POST  /sys-roles : Create a new sysRole.
     *
     * @param sysRole the sysRole to create
     * @return the ResponseEntity with status 201 (Created) and with body the new sysRole, or with status 400 (Bad Request) if the sysRole has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/sys-roles")
    @Timed
    @ApiOperation("添加角色")
    public ResponseEntity<SysRole> createSysRole(@RequestBody SysRole sysRole) throws URISyntaxException {
        log.debug("REST request to save SysRole : {}", sysRole);
        if (sysRole.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new sysRole cannot already have an ID")).body(null);
        }
        SysRole result = sysRoleService.save(sysRole);
        return ResponseEntity.created(new URI("/api/sys-roles/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /sys-roles : Updates an existing sysRole.
     *
     * @param sysRole the sysRole to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated sysRole,
     * or with status 400 (Bad Request) if the sysRole is not valid,
     * or with status 500 (Internal Server Error) if the sysRole couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/sys-roles")
    @Timed
    @ApiOperation("更新角色")
    public ResponseEntity<SysRole> updateSysRole(@RequestBody SysRole sysRole) throws URISyntaxException {
        log.debug("REST request to update SysRole : {}", sysRole);
        if (sysRole.getId() == null) {
            return createSysRole(sysRole);
        }
        SysRole result = sysRoleService.save(sysRole);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, sysRole.getId().toString()))
            .body(result);
    }

    /**
     * GET  /sys-roles : get all the sysRoles.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of sysRoles in body
     */
    @GetMapping("/sys-roles")
    @Timed
    @ApiOperation("获取全部角色")
    public List<SysRole> getAllSysRoles() {
        log.debug("REST request to get all SysRoles");
        return sysRoleService.findAll();
    }

    /**
     * GET  /sys-roles/:id : get the "id" sysRole.
     *
     * @param id the id of the sysRole to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the sysRole, or with status 404 (Not Found)
     */
    @GetMapping("/sys-roles/{id}")
    @Timed
    @ApiOperation("获取指定ID角色")
    public ResponseEntity<SysRole> getSysRole(@PathVariable Long id) {
        log.debug("REST request to get SysRole : {}", id);
        SysRole sysRole = sysRoleService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(sysRole));
    }

    /**
     * DELETE  /sys-roles/:id : delete the "id" sysRole.
     *
     * @param id the id of the sysRole to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/sys-roles/{id}")
    @Timed
    @ApiOperation("删除角色")
    public ResponseEntity<Void> deleteSysRole(@PathVariable Long id) {
        log.debug("REST request to delete SysRole : {}", id);
        sysRoleService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }



}
