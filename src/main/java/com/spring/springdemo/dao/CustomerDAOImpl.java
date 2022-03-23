package com.spring.springdemo.dao;

import com.spring.springdemo.entity.Customer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import javax.xml.namespace.QName;
import java.util.List;
import java.util.concurrent.Callable;

@Repository
public class CustomerDAOImpl implements  CustomerDAO
{

// need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Customer> getCustomers()
    {
       // get the current hibernate session
        Session currentSession =sessionFactory.getCurrentSession();


        // create a query.. sort by last name

        Query<Customer> theQuery=
                currentSession.createQuery("from Customer order by lastName",Customer.class);


        // execute query and get result list

        List<Customer> customers=theQuery.getResultList();


        // return the results



        return customers;
    }

    @Override
    public void saveCustomer(Customer theCustomer)
    {
    // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // save/update the customer
    currentSession.saveOrUpdate(theCustomer);
    }
    public Customer getCustomer(int theId)
    {
        // get the current hibernate session
        Session currentSession=sessionFactory.getCurrentSession();


        // now retrieve from db using primary key
        Customer theCustomer=currentSession.get(Customer.class,theId);


        return theCustomer;
    }

    @Override
    public void deleteCustomer(int theId)
    {
        // get the current hibernate session
        Session currentSession=sessionFactory.getCurrentSession();
        // delete object with primary key

        Query theQuery=
                currentSession.createQuery("delete from Customer where id=:customerId");

        theQuery.setParameter("customerId",theId);
        theQuery.executeUpdate();

    }
}
