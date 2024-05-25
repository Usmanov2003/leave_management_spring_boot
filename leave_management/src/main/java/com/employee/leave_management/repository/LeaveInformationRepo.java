package com.employee.leave_management.repository;

import com.employee.leave_management.entity.LeaveInformation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveInformationRepo extends CrudRepository<LeaveInformation,Integer> {

}
