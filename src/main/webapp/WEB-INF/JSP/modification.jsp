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
    <title>modification</title>
  </head>

  <body>
    <%@ include file="header.jsp" %>
      <main class="text-black container mt-lg-5 mt-sm-4">
        <h1 class="d-flex justify-content-center mb-4">modification</h1>
        <c:if test="${!empty personnes}">
          <div class="container">
            <div class="row d-flex justify-content-center">
              <form class="col-lg-6 col-sm-12" method="post">
                <div class="form-input mt-4">
                  <label for="form-select">choisir personne :</label>
                  <select class="form-select" name="choisirPersonne" required>
                    <c:forEach var="personne" begin="0" items="${personnes}">
                      <option value="<c:out value="${personne.identifiant}"/>">
                        <c:out value="${personne.nom}" />
                      </option>
                    </c:forEach>
                  </select>
                </div>
                <div class="d-flex justify-content-center mt-5 mb-5">
                  <button type="submit" id="btnSubmit" class="btn btn-primary p-md-4 p-sm-3">
                    valider
                  </button>
                </div>
              </form>
            </div>
          </div>
        </c:if>
        <c:if test="${!empty personneselectionne}">
          <div class="container">
            <div class="row d-flex justify-content-center">
              <form class="col-lg-6 col-sm-12" method="post" action="">
                <div id="nomErr" class="form-input">
                  <label id="labNom" for="nom">nom :</label>
                  <input type="text" class="form-control nom" id="nom" name="nom" value=" <c:out value=" ${personneselectionne.nom}" />"
                    placeholder="almokdad" required />
                </div>
                <div id="prenomErr" class="form-input">
                  <label for="prenom">prenom :</label>
                  <input type="text" class="form-control" id="prenom" name="prenom"
                    value="<c:out value="${personneselectionne.prenom}" />" placeholder="muhanad" required />
                </div>
                <input type="hidden" name="idModifier" value="<c:out value="${personneselectionne.identifiant}" />">
                <div class="d-flex justify-content-center mt-5 mb-5">
                  <button type="submit" id="btnSubmit" class="btn btn-primary text-light pb-md-3 ps-md-3">
                    valider
                  </button>
                </div>
              </form>
            </div>
          </div>
        </c:if>
      </main>
      <%@ include file="footer.jsp" %>
  </body>

  </html>