package com.example.springcrud.Controller;

import com.example.springcrud.Model.Employee;
import com.example.springcrud.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //display all employees
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listEmployees",employeeService.getAllEmployees());
        return "index";
    };

    @GetMapping("/addEmployeeForm")
    public String addEmployee(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "addEmployee";
    };

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/";
    };

    @GetMapping("/updateEmployee/{id}")
    public String showUpdateForm(@PathVariable (value = "id") long id,Model model){
        //get employee from service
        Employee employee = employeeService.getEmployeeById(id);
        //set employee as a model attribute to pre-populate the form
        model.addAttribute("employee",employee);
        return "updateEmployee";
    }
}
