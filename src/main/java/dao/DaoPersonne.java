package dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.StoredProcedureParameter;
import javax.transaction.Transaction;

import exception.DaoException;
import models.Personne;
import servlet.Servlet;

public class DaoPersonne extends Personne {
  private static final Logger LOGGER = Logger.getLogger(DaoPersonne.class.getName());
  private static EntityManager entityManager = Servlet.getEntityManager();

  public DaoPersonne() {
  }

  public static Personne findPersonById(Integer id) throws Exception {
    Personne personne = null;
    try {
      personne = entityManager.find(Personne.class, id);
    } catch (Exception e) {
      LOGGER.warning("On n'a pas réussir à lire la table personne." + e.getMessage());
      throw new DaoException("On n'a pas réussir à lire la table personne.");
    }
    return personne;
  }

  public static List<Personne> findAll() throws Exception {
    List<Personne> personnes = null;
    try {
      personnes = entityManager.createQuery("select p from Personne p").getResultList();
    } catch (Exception e) {
      LOGGER.warning("On n'a pas réussir à lire la table personne." + e.getMessage());
      throw new DaoException("On n'a pas réussir à lire la table personne.");
    }
    return personnes;
  }

  public static Integer save(Personne personne) throws Exception {
    EntityTransaction entityTransaction = entityManager.getTransaction();
    try {
      entityTransaction.begin();
      entityManager.merge(personne);
      entityManager.flush();
      entityTransaction.commit();
    } catch (Exception e) {
      entityTransaction.rollback();
      LOGGER.warning("err bd " + e.getMessage());
      throw new DaoException("On n'a pas réussir à save l'objet dans la table personne.");
    }
    return null;
  }

  public static void delete(Integer idpersonne) throws Exception {
    EntityTransaction entityTransaction = entityManager.getTransaction();
    try {
      Personne personne = entityManager.find(Personne.class, idpersonne);
      entityTransaction.begin();
      entityManager.remove(personne);
      entityTransaction.commit();
    } catch (Exception e) {
      entityTransaction.rollback();
      LOGGER.warning("err bd delete" + e.getMessage());
      throw new DaoException("On n'a pas réussir à delete l'objet dans la table personne.");
    }
  }
}
