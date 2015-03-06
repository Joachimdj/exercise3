/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tester;

import Entity.Employee;
import Entity.Person;
import Entity.Student; 
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author JoachimDittman
 */
public class Exercise4 {

    /**
     * @param args the command line arguments
     */
       public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Exercise4PU");
        EntityManager em = emf.createEntityManager();
         
        
        Person p = new Student("Joachim","Dittman", new Date(), 27, false, 15,new Date());
        Employee p2 = new Employee("firstName","lastName",new Date(), 12, true, 324234234, 23234, "High");
         
    
        em.getTransaction().begin();
        em.persist(p);
        em.persist(p2);
        em.getTransaction().commit();
    }
    
}
