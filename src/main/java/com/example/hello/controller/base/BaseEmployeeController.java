package com.example.hello.controller.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseEmployeeController {

    @RequestMapping(value = "/employee")
    public String getAll() {
        return "employee-info";
    }

    @RequestMapping(value = "/employee/details/{i}")
    public String detailSupplier() {
        return "employee-details";
    }

    @RequestMapping(value = "/employee/do-create")
    public String doCreateSupplier() {
        return "redirect:/employee";
    }

    @RequestMapping(value = "/employee/create")
    public String createSupplier() {
        return "employee-create";
    }

    @RequestMapping(value = "/employee/update/{id}")
    public String updateSupplier() {
        return "employee-update";
    }

    @RequestMapping(value = "/employee/do-update/{id}")
    public String doUpdateSupplier() {
        return "redirect:/employee";
    }

    @RequestMapping(value = "/employee/delete/{id}")
    public String deleteSupplier() {
        return "redirect:/employee";
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
