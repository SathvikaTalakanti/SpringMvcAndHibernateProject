package com.spring.springdemo.service;

import com.spring.springdemo.dao.CustomerDAO;
import com.spring.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service // used to implement service
public class CustomerServiceImpl implements CustomerService
{
    // need to inject customer dao
    @Autowired
    private CustomerDAO customerDAO;
    @Override
    @Transactional // if we use it we dont need to begin and commit ransaction
    public List<Customer> getCustomers()
    {

        return customerDAO.getCustomers();
    }
    @Transactional
    public  void saveCustomer(Customer theCustomer)
    {
        customerDAO.saveCustomer(theCustomer);


    }

    @Override
    @Transactional
    public Customer getCustomer(int theId)
    {
        return customerDAO.getCustomer(theId);

    }

    @Override
    @Transactional
    public void deleteCustomer(int theId)
    {
           customerDAO.deleteCustomer(theId);
    }
}
