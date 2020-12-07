package com.HR.HRApp.repositories;

import com.HR.HRApp.domain.staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface staffRepository extends CrudRepository<staff, Long> {

}
