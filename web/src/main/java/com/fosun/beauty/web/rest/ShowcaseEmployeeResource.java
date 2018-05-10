package com.fosun.beauty.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.fosun.beauty.common.errors.BadRequestAlertException;
import com.fosun.beauty.common.util.HeaderUtil;
import com.fosun.beauty.common.util.PaginationUtil;
import com.fosun.beauty.domain.ShowcaseEmployee;
import com.fosun.beauty.service.ShowcaseEmployeeService;

import com.fosun.beauty.common.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing ShowcaseEmployee.
 */
@RestController
@RequestMapping("/api")
public class ShowcaseEmployeeResource {

    private final Logger log = LoggerFactory.getLogger(ShowcaseEmployeeResource.class);

    private static final String ENTITY_NAME = "showcaseEmployee";

    private final ShowcaseEmployeeService showcaseEmployeeService;

    public ShowcaseEmployeeResource(ShowcaseEmployeeService showcaseEmployeeService) {
        this.showcaseEmployeeService = showcaseEmployeeService;
    }

    /**
     * POST  /showcase-employees : Create a new showcaseEmployee.
     *
     * @param showcaseEmployee the showcaseEmployee to create
     * @return the ResponseEntity with status 201 (Created) and with body the new showcaseEmployee, or with status 400 (Bad Request) if the showcaseEmployee has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/showcase-employees")
    @Timed
    public ResponseEntity<ShowcaseEmployee> createShowcaseEmployee(@RequestBody ShowcaseEmployee showcaseEmployee) throws URISyntaxException {
        log.debug("REST request to save ShowcaseEmployee : {}", showcaseEmployee);
        if (showcaseEmployee.getId() != null) {
            throw new BadRequestAlertException("A new showcaseEmployee cannot already have an ID", ENTITY_NAME, "idexists");
        }        
        ShowcaseEmployee result = showcaseEmployeeService.save(showcaseEmployee);
        return ResponseEntity.created(new URI("/api/showcase-employees/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /showcase-employees : Updates an existing showcaseEmployee.
     *
     * @param showcaseEmployee the showcaseEmployee to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated showcaseEmployee,
     * or with status 400 (Bad Request) if the showcaseEmployee is not valid,
     * or with status 500 (Internal Server Error) if the showcaseEmployee couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/showcase-employees")
    @Timed
    public ResponseEntity<ShowcaseEmployee> updateShowcaseEmployee(@RequestBody ShowcaseEmployee showcaseEmployee) throws URISyntaxException {
        log.debug("REST request to update ShowcaseEmployee : {}", showcaseEmployee);
        if (showcaseEmployee.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }        
        ShowcaseEmployee result = showcaseEmployeeService.save(showcaseEmployee);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, showcaseEmployee.getId().toString()))
            .body(result);
    }

    /**
     * GET  /showcase-employees : get all the showcaseEmployees.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of showcaseEmployees in body
     */
    @GetMapping("/showcase-employees")
    @Timed
    public ResponseEntity<List<ShowcaseEmployee>> getAllShowcaseEmployees(Pageable pageable) {
        log.debug("REST request to get a page of ShowcaseEmployees");
        Page<ShowcaseEmployee> page = showcaseEmployeeService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/showcase-employees");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /showcase-employees/:id : get the "id" showcaseEmployee.
     *
     * @param id the id of the showcaseEmployee to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the showcaseEmployee, or with status 404 (Not Found)
     */
    @GetMapping("/showcase-employees/{id}")
    @Timed
    public ResponseEntity<ShowcaseEmployee> getShowcaseEmployee(@PathVariable Long id) {
        log.debug("REST request to get ShowcaseEmployee : {}", id);
        Optional<ShowcaseEmployee> showcaseEmployee = showcaseEmployeeService.findOne(id);
        return ResponseUtil.wrapOrNotFound(showcaseEmployee);
    }

    /**
     * DELETE  /showcase-employees/:id : delete the "id" showcaseEmployee.
     *
     * @param id the id of the showcaseEmployee to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/showcase-employees/{id}")
    @Timed
    public ResponseEntity<Void> deleteShowcaseEmployee(@PathVariable Long id) {
        log.debug("REST request to delete ShowcaseEmployee : {}", id);
        showcaseEmployeeService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
