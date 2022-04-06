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
      <p class="col-lg-6 col-sm-12 alert alert-primary" role="alert">
        Le numéro de page lu est :  <c:out value="${!empty sessionScope.compteurPage ? sessionScope.compteurPage :'Err in compteurPage'}"/>   
        </p>
      <c:if test="${empty personnes}">  
        <h2>la numéro des adhérents :  <c:out value="la liste des adhérents  est vide"/> </h2> 
      </c:if>
      <c:if test="${!empty personnes}">  
        <h2>la numéro des adhérents :  <c:out value="${personnesSize}"/> </h2> 
      </c:if>
      <table class="table table-striped mt-4">
        <c:if test="${!empty personnes}">
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
          <c:if test="${!empty personnes}">
            <tbody>
              <tr>
                <c:if test="${!empty personne.identifiant}">
                  <th scope="row"><c:out value="${personne.identifiant}"/> </th>
                </c:if>
                <c:if test="${!empty personne.nom}">
                  <td><c:out value="${personne.nom}"/></td>
                </c:if>
                <c:if test="${!empty personne.prenom}">
                  <td><c:out value="${personne.prenom}"/></td>
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
