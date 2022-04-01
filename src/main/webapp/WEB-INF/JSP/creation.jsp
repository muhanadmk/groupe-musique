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
    <title>création</title>
  </head>
  <body>
    <%@ include file="header.jsp" %>
    <main class="text-dark mt-lg-5 mt-sm-4">
      <h1 class="d-flex justify-content-center hedaing">création</h1>
      <div class="container">
        <div class="row d-flex justify-content-center">
          <form class="col-lg-6 col-sm-12" method="post" action="">
            <div id="nomErr" class="form-input">
              <label id="labNom" for="nom">nom :</label>
              <input
                type="text"
                class="form-control nom"
                id="nom"
                name="nom"
                placeholder="almokdad"
                required
              />
            </div>
            <div id="prenomErr" class="form-input">
              <label for="prenom">prenom :</label>
              <input
                type="text"
                class="form-control"
                id="prenom"
                name="prenom"
                placeholder="muhanad"
                required
              />
            </div>
            <div class="d-flex justify-content-center mt-5 mb-5">
              <button
                type="submit"
                id="btnSubmit"
                class="btn btn-primary text-light pb-md-3 ps-md-3"
              >
                valider
              </button>
            </div>
          </form>
        </div>
      </div>
    </main>

    <%@ include file="footer.jsp" %>
  </body>
</html>
