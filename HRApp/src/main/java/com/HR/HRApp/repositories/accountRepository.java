package com.HR.HRApp.repositories;

import com.HR.HRApp.domain.account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface accountRepository extends CrudRepository<account, Long> {
}