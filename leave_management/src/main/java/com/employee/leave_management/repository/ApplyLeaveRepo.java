package com.employee.leave_management.repository;

import com.employee.leave_management.entity.ApplyLeave;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplyLeaveRepo extends CrudRepository<ApplyLeave,Integer> {

}
