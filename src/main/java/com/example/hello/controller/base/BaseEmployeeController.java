package com.example.hello.controller.base;

import com.datastax.driver.core.LocalDate;
import com.datastax.driver.core.utils.UUIDs;
import com.example.hello.model.Employee;
import com.example.hello.request.EmployeeRequest;
import com.example.hello.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping(value = "/admin")
public class BaseEmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employee-info")
    public String getAll(Model model) {
        model.addAttribute("employeeList", this.employeeService.getAllEmployee());
        model.addAttribute("root", "Category");
        model.addAttribute("sub_root", "Components");
        model.addAttribute("sub_active", "Employee");
        return "employee-info";
    }

    @RequestMapping(value = "/employee-details/{i}")
    public String detailEmplyee() {
        return "employee-details";
    }

    @RequestMapping(value = "/employee-create")
    public String createEmplyee(Model model) {
        model.addAttribute("employee", new EmployeeRequest());
//        LocalDate ld = LocalDate.fromYearMonthDay(LocalDateTime.now().getYear(), LocalDateTime.now().getMonthValue(), LocalDateTime.now().getDayOfMonth());
//        System.out.println("# " + ld);
        model.addAttribute("root", "Category");
        model.addAttribute("sub_root", "Components");
        model.addAttribute("sub_active", "Employee");
        return "employee-create";
    }

    @RequestMapping(value = "/employee-do-create")
    public String doCreateEmplyee(@ModelAttribute EmployeeRequest employee) {
        Employee emp = new Employee();
        java.time.LocalDate dateOfBirth = java.time.LocalDate.parse(employee.getDateOfBirth());
        java.time.LocalDate dayAtWork = java.time.LocalDate.parse(employee.getWorkDate());
        emp.setId(UUIDs.timeBased());
        emp.setDateOfBirth(LocalDate.fromYearMonthDay(dateOfBirth.getYear(), dateOfBirth.getMonthValue(), dateOfBirth.getDayOfMonth()));
        emp.setWorkDate(LocalDate.fromYearMonthDay(dayAtWork.getYear(), dayAtWork.getMonthValue(), dayAtWork.getDayOfMonth()));
        emp.setCreatedAt(LocalDate.fromYearMonthDay(LocalDateTime.now().getYear(), LocalDateTime.now().getMonthValue(), LocalDateTime.now().getDayOfMonth()));
        emp.setFullname(employee.getFullname());
        emp.setAddress(employee.getAddress());
        emp.setGender(employee.getGender());
        emp.setMail(employee.getMail());
        emp.setPhone(employee.getPhone());
        this.employeeService.saveEmployee(emp);
        return "redirect:/admin/employee-info";
    }

    @RequestMapping(value = "/employee-update/{id}")
    public String updateEmplyee() {
        return "employee-update";
    }

    @RequestMapping(value = "/employee-do-update/{id}")
    public String doUpdateSupplier() {
        return "redirect:/admin/employee-info";
    }

    @RequestMapping(value = "/employee-delete/{id}")
    public String deleteEmplyee() {
        return "redirect:/admin/employee-info";
    }

 /*   @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/customer")
    public String getAll(Model model) {
        model.addAttribute("listCustomer", this.customerService.getAllCustomer());
        return "customer-info";
    }

    @RequestMapping(value = "/customer/details/{id}")
    public String details(@PathVariable UUID id, Model model) {
        model.addAttribute("detailsCutomer", this.customerService.getCustomerById(id));
        return "customer-details";
    }

    @RequestMapping(value = "/customer/create")
    public String createCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-create";
    }

    @RequestMapping(value = "/customer/do-create")
    public String doCreateCustomer(@ModelAttribute Customer customer) {
        customer.setId(UUIDs.timeBased());
        this.customerService.saveCustomer(customer);
        return "redirect:/customer";
    }

    @RequestMapping(value = "/customer/update/{id}")
    public String updateCustomer(@PathVariable UUID id, Model model) {
        model.addAttribute("updateCustomer", this.customerService.getCustomerById(id));
        return "customer-update";
    }

    @RequestMapping(value = "/customer/do-update/{id}")
    public String doUpdateCustomer(@PathVariable UUID id, @ModelAttribute Customer customer) {
        customer.setId(id);
        this.customerService.saveCustomer(customer);
        return "redirect:/customer";
    }

    @RequestMapping(value = "/customer/delete/{id}")
    public String deleteCustomer(@PathVariable UUID id) {
        Customer cs = this.customerService.getCustomerById(id);
        if (cs != null) {
            this.customerService.deleteCustomerById(id);
        }
        return "redirect:/customer";
    }

    @RequestMapping(value = "/customer/search/{search}")
    public String searchCustomer(@PathVariable String search, Model model) {
//        if (search != null || search != "") {
//            List<Customer> list = this.customerService.searchCustomer(search, search);
//            model.addAttribute("listCustomer", list);
//        } else {
//            model.addAttribute("listCustomer", this.customerService.getAllCustomer());
//        }
        Customer customer1 = this.customerService.getCustomerByFullname(search);
        Customer customer2 = this.customerService.getCustomerByPhone(search);
//        Customer customer3 = this.customerService.getCustomerById(UUID.fromString(search));
       if (customer1 != null) {
            model.addAttribute("listCustomer", customer1);
        } else if (customer2 != null) {
            model.addAttribute("listCustomer", customer2);
        } else {
            model.addAttribute("listCustomer", this.customerService.getAllCustomer());
        }
        return "customer-info";
    }
*/
}
