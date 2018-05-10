package com.fosun.beauty.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.fosun.beauty.common.util.HeaderUtil;
import com.fosun.beauty.common.web.util.ResponseUtil;
import com.fosun.beauty.domain.SysResource;
import com.fosun.beauty.service.SysResourceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;


/**
 * REST controller for managing SysResource.
 */
@RestController
@RequestMapping("/api")
@Api(tags = "系统资源")
public class SysResourceResource {

    private final Logger log = LoggerFactory.getLogger(SysResourceResource.class);

    private static final String ENTITY_NAME = "sysResource";

    private final SysResourceService sysResourceService;

    public SysResourceResource(SysResourceService sysResourceService) {
        this.sysResourceService = sysResourceService;
    }

    /**
     * POST  /sys-resources : Create a new sysResource.
     *
     * @param sysResource the sysResource to create
     * @return the ResponseEntity with status 201 (Created) and with body the new sysResource, or with status 400 (Bad Request) if the sysResource has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/sys-resources")
    @Timed
    @ApiOperation("创建资源")
    public ResponseEntity<SysResource> createSysResource(@RequestBody SysResource sysResource) throws URISyntaxException {
        log.debug("REST request to save SysResource : {}", sysResource);
        if (sysResource.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new sysResource cannot already have an ID")).body(null);
        }
        SysResource result = sysResourceService.save(sysResource);
        return ResponseEntity.created(new URI("/api/sys-resources/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }




    /**
     * PUT  /sys-resources : Updates an existing sysResource.
     *
     * @param sysResource the sysResource to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated sysResource,
     * or with status 400 (Bad Request) if the sysResource is not valid,
     * or with status 500 (Internal Server Error) if the sysResource couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/sys-resources")
    @Timed
    @ApiOperation("修改资源")
    public ResponseEntity<SysResource> updateSysResource(@RequestBody SysResource sysResource) throws URISyntaxException {
        log.debug("REST request to update SysResource : {}", sysResource);
        if (sysResource.getId() == null) {
            return createSysResource(sysResource);
        }
        SysResource result = sysResourceService.save(sysResource);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, sysResource.getId().toString()))
            .body(result);
    }

    /**
     * GET  /sys-resources : get all the sysResources.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of sysResources in body
     */
    @GetMapping("/sys-resources")
    @Timed
    @ApiOperation("获取全部资源")
    public List<SysResource> getAllSysResources() {
        log.debug("REST request to get all SysResources");
        return sysResourceService.findAll();
    }




    /**
     * GET  /sys-resources/:id : get the "id" sysResource.
     *
     * @param id the id of the sysResource to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the sysResource, or with status 404 (Not Found)
     */
    @GetMapping("/sys-resources/{id}")
    @Timed
    @ApiOperation("获取指定ID资源")
    public ResponseEntity<SysResource> getSysResource(@PathVariable Long id) {
        log.debug("REST request to get SysResource : {}", id);
        SysResource sysResource = sysResourceService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(sysResource));
    }

    /**
     * DELETE  /sys-resources/:id : delete the "id" sysResource.
     *
     * @param id the id of the sysResource to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/sys-resources/{id}")
    @Timed
    @ApiOperation("删除资源")
    public ResponseEntity<Void> deleteSysResource(@PathVariable Long id) {
        log.debug("REST request to delete SysResource : {}", id);
        sysResourceService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }




}
