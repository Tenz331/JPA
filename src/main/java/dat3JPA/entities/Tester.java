/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dat3JPA.entities;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author melo-
 */
public class Tester {
    
    public static void main(String[] args) {
        
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    EntityManager em = emf.createEntityManager();
    
    Person p1 = new Person("jønke", 1963);
    Person p2 = new Person("Blondie",1959);
    Person p3 = new Person("Søren",1993);
    Person p4 = new Person("mathias",1996);
    
    
    Address a1 = new Address("Store Torv 1", 2323, "Nr.Snede");
    Address a2 = new Address("Langgade 34", 1212, "Valby");
    Address a3 = new Address("Fredenborgvej 10", 3434, "Frederiksund");
    Address a4 = new Address("Jyllingevej 2", 4344, "Jyllinge");
    
    p1.setAddress(a1);
    p2.setAddress(a2);
    
    Fee f1 = new Fee(100);
    Fee f2 = new Fee(200);
     Fee f3 = new Fee(300);
     Fee f4 = new Fee(400);
    
    p1.AddFees(f1);
    p1.AddFees(f3);
    p2.AddFees(f2);
    p4.AddFees(f1);
    p3.AddFees(f4);
    
    
    em.getTransaction().begin();
    em.persist(p1);
    em.persist(p2);
    em.persist(p3);
    em.persist(p4);
    em.getTransaction().commit();
    
    System.out.println("p1: " + p1.getP_id()+ ", " + p1.getName());
    System.out.println("p1: " + p2.getP_id()+ ", " + p2.getName());
    
    
    System.out.println("Jønkes gade:  " + p1.getAddress().getStreet());
        
        System.out.println("Lad os se om to-vejs virker: " + a1.getPerson().getName()); 
        
        System.out.println("Hvem har betalt f2? Det har: " + f2.getPerson().getName());
        
        System.out.println("Hvad har Jønke betalt: ");
       
        TypedQuery<Fee> q1 = em.createQuery("SELECT f FROM Fee f", Fee.class);
        List<Fee> fees = q1.getResultList();
        
        for(Fee f: fees){
            System.out.println(f.getPerson().getName() + ": " + f.getAmount() + " Kr. Den: " +f.getPayDate() +"Add: " + f.getPerson().getAddress().getCity());
        }
    
    }
}
