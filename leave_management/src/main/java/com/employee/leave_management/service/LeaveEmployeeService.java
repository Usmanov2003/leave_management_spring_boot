package com.employee.leave_management.service;

import com.employee.leave_management.entity.LeaveInfoEmployees;
import com.employee.leave_management.repository.LeaveEmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveEmployeeService {

    @Autowired
    private LeaveEmployeeRepo repoEmpL;

    public void saveLeaveInfo(LeaveInfoEmployees obj) {
        repoEmpL.save(obj);
    }

    public List<LeaveInfoEmployees> getAllLeaves(){
        return (List<LeaveInfoEmployees>) repoEmpL.findAll();
    }


    public LeaveInfoEmployees getEmployeeLeaveDetails(int empId) {
        for(LeaveInfoEmployees obj:getAllLeaves()) {
            if(obj.getEmployeeId()==empId)
                return obj;
        }
        return null;
    }

}
