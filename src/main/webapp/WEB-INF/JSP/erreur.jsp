<%@ include file="taglibs.jsp" %>
<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/node_modules/bootstrap/dist/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
  <title>page Err 404</title>
</head>
<body>
  <%@ include file="header.jsp" %>
  <h1 class="d-flex justify-content-center">Désole, On ne peut pas traiter votre demande</h1>
  <div class="d-flex justify-content-center">
    <img src="${pageContext.request.contextPath}/images/page-erreur-404.jpg" alt="img">
  </div>
  <%@ include file="footer.jsp" %>
</body>
</html>
