package com.employee.leave_management.repository;

import com.employee.leave_management.entity.LeaveInfoEmployees;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveEmployeeRepo extends CrudRepository<LeaveInfoEmployees,Integer> {

}
