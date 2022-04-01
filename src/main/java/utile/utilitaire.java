package utile;

import java.util.ArrayList;

import models.Personne;

public class utilitaire {
  private static ArrayList<Personne> personnes = new ArrayList<Personne>();
  public static ArrayList<Personne> getPersonnes() {
    return personnes;
  }
}
