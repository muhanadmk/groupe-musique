package dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import models.Personne;
import servlet.Servlet;

public class DaoPersonne extends Personne {
  private static final Logger LOGGER =   Logger.getLogger(DaoPersonne.class.getName());
  private static EntityManager entityManager = Servlet.getEntityManager(); 
  public DaoPersonne(){}

  public static List<Personne> findAll(){
    List personnes = null;
    try {
      personnes = entityManager.createQuery("SELECT p FROM personne p").getResultList();
    } catch (Exception e) {
      LOGGER.warning("err bd find all " + e.getMessage() + e.getCause() ); 
    }
    return personnes;
  }

  public static Integer save(Personne personne){
      try {
        EntityTransaction entityTransaction = entityManager.getTransaction();
       entityTransaction.begin();
        entityManager.merge(personne);
        entityManager.flush();
        entityTransaction.commit();
        LOGGER.info("msg ajout personne");
      } catch (Exception e) {
       LOGGER.warning("err bd " + e.getMessage() + e.fillInStackTrace() ); 
      }
      return null;
  }
}
