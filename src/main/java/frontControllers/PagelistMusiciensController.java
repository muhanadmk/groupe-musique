package frontControllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Personne;

public class PagelistMusiciensController implements ICommand {
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    Personne personne = new Personne(1, "ali", "mazen");
    Personne personne2 = new Personne(2, "ahmed", "mazen");
    Personne personne3 = new Personne(3, "ali", "sham");

    ArrayList<Personne> personnes = new ArrayList<Personne>();
    personnes.add(personne);
    personnes.add(personne2);
    personnes.add(personne3);
    request.setAttribute("personnes", personnes);
    String msgOrNumberDePersonne = String.valueOf(personnes.size());
    if (personnes == null || personnes.size()==0){
      msgOrNumberDePersonne = "la liste des adhérents  est vide";
    }
    request.setAttribute("msgOrNumberDePersonne", msgOrNumberDePersonne);
    return "liste.jsp";
  }
}
