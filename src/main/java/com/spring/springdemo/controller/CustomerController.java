package com.spring.springdemo.controller;

import com.spring.springdemo.dao.CustomerDAO;
import com.spring.springdemo.entity.Customer;
import com.spring.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController
{
   // need to inject customer service
    @Autowired
    private CustomerService customerService;
    @GetMapping("/list")
    public  String  listCustomers(Model theModel)
    {
        // get customers from the service
        List<Customer> theCustomers = customerService.getCustomers();

        // add customers to the model

        theModel.addAttribute("customers", theCustomers);


        return "list-customer";

    }
    @GetMapping("/showFormForAdd")
    public  String showFormForAdd(Model theModel)
    {
        // create model attribute to bind form data
        Customer theCustomer=new Customer();
        theModel.addAttribute("customer",theCustomer);
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer)
    {
        // save the customer using our service

      customerService.saveCustomer(theCustomer);
        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel)
    {
        // get the customer from db
        Customer theCustomer =customerService.getCustomer(theId);

        // set customer as a model attribute to display the form
        theModel.addAttribute("customer",theCustomer);

        // send over to our form
        return "customer-form";

    }
    @GetMapping("/delete")
    public  String  deleteCustomer(@RequestParam("customerId") int theId)
    {
        // delete the customer
        customerService.deleteCustomer(theId);

        return "redirect:/customer/list";
    }

}
