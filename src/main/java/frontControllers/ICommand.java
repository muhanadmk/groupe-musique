/**
 * packge front contrôler qui contient tout les classes
 * qui contrôle les parties front-end de l'application.
 */
package frontControllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ICommand {

  /**
   * @param request  request objet de classe HttpServletRequest
   * @param response response objet de classe HttpServletResponse
   * @return parm de url qui nous ramane vers la page
   * @throws Exception objet de classe Exception
   */
  String execute(HttpServletRequest request,
   HttpServletResponse response) throws Exception;
}
