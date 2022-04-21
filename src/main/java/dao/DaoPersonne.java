package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import exception.DaoException;
import models.Personne;
import servlet.Servlet;

public class DaoPersonne extends Personne {
  /**
   * LOGGER.
   */
  private static final Logger LOGGER = Logger.getLogger(
    DaoPersonne.class.getName());
    /**
     * objet entityManager qui fait le conn à bd.
     */
  private static EntityManager entityManager = Servlet.getEntityManager();
/**
 * constructeur.
 */
  public DaoPersonne() {
  }
/**
 * findPersonById.
 * @param id de Personne.
 * @return objet Personne.
 * @throws Exception exception.
 */
  public static Personne findPersonById(final Integer id) throws Exception {
    Personne personne = null;
    try {
      personne = entityManager.find(Personne.class, id);
    } catch (Exception e) {
      LOGGER.warning(
        "On n'a pas réussir à lire la table personne." + e.getMessage());
      throw new DaoException("On n'a pas réussir à lire la table personne.");
    }
    return personne;
  }
/**
 * findAll personnes.
 * @return list personnes
 * @throws Exception exception
 */
  public static List<Personne> findAll() throws Exception {
    List<Personne> personnes = new ArrayList<Personne>();
    try {
      personnes = entityManager.createQuery(
      "select p from Personne p").getResultList();
    } catch (Exception e) {
      LOGGER.warning(
        "On n'a pas réussir à lire la table personne." + e.getMessage());
      throw new DaoException("On n'a pas réussir à lire la table personne.");
    }
    return personnes;
  }
/**
 * cree or update personne.
 * @param personne personne
 * @return null
 * @throws Exception exception
 */
  public static Integer save(final Personne personne) throws Exception {
    EntityTransaction entityTransaction = entityManager.getTransaction();
    try {
      entityTransaction.begin();
      entityManager.merge(personne);
      entityManager.flush();
      entityTransaction.commit();
    } catch (Exception e) {
      entityTransaction.rollback();
      throw new DaoException(
        "On n'a pas réussir à save l'objet dans la table personne.");
    }
    return null;
  }
/**
 * delete Personne.
 * @param idpersonne Integer idpersonne
 * @throws Exception exception
 */
  public static void delete(final Integer idpersonne) throws Exception {
    EntityTransaction entityTransaction = entityManager.getTransaction();
    try {
      Personne personne = entityManager.find(Personne.class, idpersonne);
      entityTransaction.begin();
      entityManager.remove(personne);
      entityTransaction.commit();
    } catch (Exception e) {
      entityTransaction.rollback();
      throw new DaoException(
        "On n'a pas réussir à delete l'objet dans la table personne.");
    }
  }
}
