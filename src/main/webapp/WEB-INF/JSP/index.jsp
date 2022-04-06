<%@ include file="taglibs.jsp" %>
<html lang="fr">
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
    <title>groupe-musique</title>
  </head>

  <body>
    <%@ include file="header.jsp" %>
    <h1>page accuile</h1>
    <p class="col-lg-6 col-sm-12 alert alert-primary" role="alert">
      Le numéro de page lu est :  <c:out value="${!empty sessionScope.compteurPage ? sessionScope.compteurPage :'Err in compteurPage'}"/>   
      </p>   
    <%@ include file="footer.jsp" %>
  </body>
</html>
