/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dat3JPA.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
    
    
    em.getTransaction().begin();
    em.persist(p1);
    em.persist(p2);
    
    em.getTransaction().commit();
    
    System.out.println("p1: " + p1.getP_id()+ ", " + p1.getName());
    System.out.println("p1: " + p2.getP_id()+ ", " + p2.getName());
    }
}
