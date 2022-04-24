<%@page import="utile.TokenHelper" %>
<%@ include file="taglibs.jsp" %>
  <!DOCTYPE html>
  <html lang="fr">

  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet"
      href="${pageContext.request.contextPath}/node_modules/bootstrap/dist/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
    <title>
      connexionUser
    </title>
  </head>
  <body>
    <%@ include file="header.jsp" %>

    <main class="form-signin container col-lg-4 col-sm-12 mt-5">
      <form method="post">
        <h1 class="h3 mb-3 fw-normal"> Please sign in</h1>
        <c:if test="${!empty errTokenCerf}">
          <div class="alert alert-danger" role="alert">
           ${errTokenCerf}
          </div>
       </c:if>
        <c:if test="${!empty msgNotAdmin}">
          <p class="alert alert-primary" role="alert">
           ${msgNotAdmin}
          </p>
        </c:if>
        <c:set var="csrfToken" value="${TokenHelper.getC_token()}" />
            <c:set var="csrfTokenSession" value="${csrfToken}" scope="session" />
            <input type="hidden" name="tokenEnvoie" value="${csrfToken}" />
        <div class="form-floating">
          <input type="text" class="form-control" id="floatingInput" name="user" placeholder="user">
          <label for="floatingInput">Email address</label>
        </div>
        <div class="form-floating mt-2">
          <input type="password" class="form-control" id="floatingPassword" name="password" placeholder="Password">
          <label for="floatingPassword">Password</label>
        </div>
        <button class="mt-2 w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
        <p class="d-flex justify-content-center mt-5 mb-3 text-muted">© 2022 ALMOKDAD</p>
      </form>
    </main>
    <%@ include file="footer.jsp" %>

  </body>