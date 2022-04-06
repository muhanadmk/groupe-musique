<header>
  <nav class="navbar navbar-expand-lg navbar-dark bg-primary sticky-top">
    <div class="container">
      <a class="navbar-brand" href="${pageContext.request.contextPath}">Groupe musique</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
        aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav text-black">
          <li class="nav-item">
            <a class="nav-link active rounded-1 third-bgcolor text-light" aria-current="page" href="${pageContext.request.contextPath}">Accueil</a>
          </li>
          <li class="nav-item">
            <a class="nav-link active text-light" href="?cmd=list-de-musiciens">liste</a>
          </li>
          <li class="nav-item">
            <a class="nav-link active text-light" href="?cmd=cree">creation</a>
          </li>
          <li class="nav-item">
            <a class="nav-link active text-light " href="?cmd=modifier">modification</a>
          </li>
          <li class="nav-item">
            <a class="nav-link active text-light" href="?cmd=suppression">suppression</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
  </header>