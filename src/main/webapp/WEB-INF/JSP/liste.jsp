<%@ include file="taglibs.jsp" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="stylesheet"
      href="${pageContext.request.contextPath}/node_modules/bootstrap/dist/css/bootstrap.min.css"
    />
    <link
      rel="stylesheet"
      href="${pageContext.request.contextPath}/css/style.css"
    />
    <title>liste</title>
  </head>

  <body>
    <%@ include file="header.jsp" %>
    <div class="container">
      <h1 class="mt-4">Hello list De Musiciens !!!!!!!</h1>
      <h2>la numéro des adhérents : ${msgOrNumberDePersonne}</h2>
      <table class="table table-striped mt-4">
        <c:if test="${personnes == null}">
          <h2>on a pas de personnes</h2>
        </c:if>
        <c:if test="${personnes != null}">
          <thead>
            <tr>
              <th scope="col">ID</th>
              <th scope="col">nom</th>
              <th scope="col">prenom</th>
            </tr>
          </thead>
        </c:if>
        <c:forEach
          var="personne"
          begin="0"
          items="${personnes}"
          varStatus="status"
        >
          <c:if test="${personnes != null}">
            <tbody>
              <tr>
                <c:if test="${personne.identifiant != null}">
                  <th scope="row">${personne.identifiant}</th>
                </c:if>
                <c:if test="${personne.nom != null}">
                  <td>${personne.nom}</td>
                </c:if>
                <c:if test="${personne.prenom != null}">
                  <td>${personne.prenom}</td>
                </c:if>
              </tr>
            </tbody>
          </c:if>
        </c:forEach>
      </table>
    </div>
    <%@ include file="footer.jsp" %>
  </body>
</html>
