package com.example.hello.controller.base;

import com.datastax.driver.core.LocalDate;
import com.datastax.driver.core.utils.UUIDs;
import com.example.hello.model.Customer;
import com.example.hello.request.CustomerRequest;
import com.example.hello.service.AccountService;
import com.example.hello.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "/admin")
public class BaseCustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/customer-info")
    public String getAll(Model model) {
        model.addAttribute("customerList", this.customerService.getAllCustomer());
        model.addAttribute("root", "Category");
        model.addAttribute("sub_root", "Components");
        model.addAttribute("sub_active", "Customer");
        return "customer-info";
    }

    @RequestMapping(value = "/customer-details/{id}")
    public String details(@PathVariable UUID id, Model model) {
        model.addAttribute("detailsCutomer", this.customerService.getCustomerById(id));
        model.addAttribute("root", "Category");
        model.addAttribute("sub_root", "Components");
        model.addAttribute("sub_active", "Customer");
        return "customer-details";
    }

    @RequestMapping(value = "/customer-create")
    public String createCustomer(Model model) {
        model.addAttribute("customer", new CustomerRequest());
        model.addAttribute("root", "Category");
        model.addAttribute("sub_root", "Components");
        model.addAttribute("sub_active", "Customer");
        return "customer-create";
    }

    @RequestMapping(value = "/customer-do-create")
    public String doCreateCustomer(@ModelAttribute CustomerRequest customer) {
        Customer cus = new Customer();
        java.time.LocalDate dateOfBirth = java.time.LocalDate.parse(customer.getDateOfBirth());
        cus.setId(UUIDs.timeBased());
        cus.setFullname(customer.getFullname());
        cus.setPhone(customer.getPhone());
        cus.setMail(customer.getMail());
        cus.setAddress(customer.getAddress());
        cus.setDateOfBirth(LocalDate.fromYearMonthDay(dateOfBirth.getYear(), dateOfBirth.getMonthValue(), dateOfBirth.getDayOfMonth()));
        cus.setGender(customer.getGender());
        cus.setCreatedAt(LocalDate.fromYearMonthDay(LocalDateTime.now().getYear(), LocalDateTime.now().getMonthValue(), LocalDateTime.now().getDayOfMonth()));
        this.customerService.saveCustomer(cus);
        return "redirect:/admin/customer-info";
    }

    @RequestMapping(value = "/customer-update/{id}")
    public String updateCustomer(@PathVariable UUID id, Model model) {
        model.addAttribute("updateCustomer", this.customerService.getCustomerById(id));
        model.addAttribute("root", "Category");
        model.addAttribute("sub_root", "Components");
        model.addAttribute("sub_active", "Customer");
        return "customer-update";
    }

    @RequestMapping(value = "/customer-do-update/{id}")
    public String doUpdateCustomer(@PathVariable UUID id, @ModelAttribute Customer customer) {
        customer.setId(id);
        this.customerService.saveCustomer(customer);
        return "redirect:/admin/customer-info";
    }

    @RequestMapping(value = "/customer-delete/{id}")
    public String deleteCustomer(@PathVariable UUID id) {
        Customer cs = this.customerService.getCustomerById(id);
        if (cs != null) {
            this.customerService.deleteCustomerById(id);
        }
        return "redirect:/admin/customer-info";
    }

    @RequestMapping(value = "/customer-search/{search}")
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

}
