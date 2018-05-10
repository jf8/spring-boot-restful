package com.fosun.beauty.repository;

import com.fosun.beauty.domain.ShowcaseEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the ShowcaseEmployee entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ShowcaseEmployeeRepository extends JpaRepository<ShowcaseEmployee, Long>, QuerydslPredicateExecutor<ShowcaseEmployee> {

}
