package com.fosun.beauty.service;

import com.fosun.beauty.domain.QShowcaseEmployee;
import com.fosun.beauty.domain.ShowcaseEmployee;
import com.fosun.beauty.repository.ShowcaseEmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing ShowcaseEmployee.
 */
@Service
@Transactional
public class ShowcaseEmployeeService {

    private final Logger log = LoggerFactory.getLogger(ShowcaseEmployeeService.class);

    private final ShowcaseEmployeeRepository showcaseEmployeeRepository;

    public ShowcaseEmployeeService(ShowcaseEmployeeRepository showcaseEmployeeRepository) {
        this.showcaseEmployeeRepository = showcaseEmployeeRepository;
    }

    //复杂查询可以使用
    public Iterable<ShowcaseEmployee> findAllComplexQuery(){

        QShowcaseEmployee query = QShowcaseEmployee.showcaseEmployee;

        return this.showcaseEmployeeRepository.findAll(query.hireDate.before(ZonedDateTime.now().withYear(1990).toInstant()).and(query.salary.gt(10000)));


//        return this.showcaseEmployeeRepository.findAll(
//                query.email.eq("xxx@icloud.com")
//                        .and(query.hireDate.before(ZonedDateTime.now().withYear(1990).toInstant())));
    }


    /**
     * Save a showcaseEmployee.
     *
     * @param showcaseEmployee the entity to save
     * @return the persisted entity
     */
    public ShowcaseEmployee save(ShowcaseEmployee showcaseEmployee) {
        log.debug("Request to save ShowcaseEmployee : {}", showcaseEmployee);
        return showcaseEmployeeRepository.save(showcaseEmployee);
    }

    /**
     * Get all the showcaseEmployees.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<ShowcaseEmployee> findAll(Pageable pageable) {
        log.debug("Request to get all ShowcaseEmployees");
        return showcaseEmployeeRepository.findAll(pageable);
    }


    /**
     * Get one showcaseEmployee by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Optional<ShowcaseEmployee> findOne(Long id) {
        log.debug("Request to get ShowcaseEmployee : {}", id);
        return showcaseEmployeeRepository.findById(id);
    }

    /**
     * Delete the showcaseEmployee by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete ShowcaseEmployee : {}", id);
        showcaseEmployeeRepository.deleteById(id);
    }
}
