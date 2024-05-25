package com.employee.leave_management.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.management.relation.Role;

@Repository
public interface RoleRepo extends CrudRepository<Role,Integer> {


}
