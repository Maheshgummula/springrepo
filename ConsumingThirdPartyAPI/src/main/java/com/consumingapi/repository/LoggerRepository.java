package com.consumingapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.consumingapi.models.LoggerEntity;
@Repository
public interface LoggerRepository extends CrudRepository<LoggerEntity,Long>{

}
