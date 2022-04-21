<header class="p-3 bg-primary sticky-top text-white">
  <div class="container">
    <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
      <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
        <li class="nav-item">
          <a class="nav-link active rounded-1 third-bgcolor text-light" aria-current="page"
            href="${pageContext.request.contextPath}">Accueil</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active text-light" href="?cmd=list">liste</a>
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

      <div class="text-end">
        <a type="button"  href="?cmd=login" class="btn btn-outline-light me-2"> Login</a>
        <a type="button" href="?cmd=sinup" class="btn btn-warning">Sign-up</a>
      </div>
    </div>
  </div>
</header>