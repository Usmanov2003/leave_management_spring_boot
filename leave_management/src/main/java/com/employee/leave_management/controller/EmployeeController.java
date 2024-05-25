package com.employee.leave_management.controller;

import java.util.List;
import javax.management.relation.Role;
import javax.servlet.http.HttpSession;

import ch.qos.logback.core.model.Model;
import com.employee.leave_management.entity.ApplyLeave;
import com.employee.leave_management.entity.Employee;
import com.employee.leave_management.exception.EmployeeNotFoundException;
import com.employee.leave_management.service.LeaveEmployeeService;
import com.employee.leave_management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes("id")
@Controller
public class EmployeeController {

    @Autowired
    public EmployeeService service;

    @Autowired
    public LeaveEmployeeService leservice;

    // because of thymeleaf template engine you don't have to say login.html and can
    // directly say return "login"

    @GetMapping("/employees/update/{empId}")
    public String viewUpdateEmployeeDetails(Model model, @PathVariable(name = "empId") int empId, HttpSession session)
            throws EmployeeNotFoundException {

        if (session.getAttribute("id") != null) {
            Employee emp = service.findEmployeeById(empId);
            List<Role> li = service.getRoles();
            model.addAttribute("employee", emp);
            model.addAttribute("listRoles", li);
            model.addAttribute("title", "Update employee id:" + empId);
            return "employeeform";
        }
        else
            return "login";
    }


    //employee can view his details
    @GetMapping(value = "/employees/empprofile/view/{empId}")
    public String getPersonalDetails(Model model, @PathVariable(name = "empId") int empId,HttpSession session)
            throws EmployeeNotFoundException {
        if (session.getAttribute("id") != null) {
            Employee emp = service.findEmployeeById(empId);
            model.addAttribute("employee", emp);
            return "viewemployeeprofile";
        }
        else
            return "login";
    }
    //http://localhost:8080/employees/leave/applyNew/2
    @GetMapping("/employees/leave/applyNew/{empId}")
    public String applyForLeave(Model model, @PathVariable(name = "empId") int empId,HttpSession session) {

        if (session.getAttribute("id") != null) {
            ApplyLeave obj = new ApplyLeave();
            obj.setEmployeeId(empId);
            model.addAttribute("applyLeave", obj);

            return "ApplyForLeave";
        }//close if for session
        else
            return "login";
    }



}
