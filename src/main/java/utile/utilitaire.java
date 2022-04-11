package utile;

import java.util.ArrayList;

import models.Personne;

public class utilitaire {
/**
 * ArrayList de personnes.
 */
  private static ArrayList<Personne> personnes = new ArrayList<Personne>();
  /**
   * get liste of  personnes.
   * @return liste of  personnes
   */
  public static ArrayList<Personne> getPersonnes() {
    return personnes;
  }
}
