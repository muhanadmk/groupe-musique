package exception;

public class DaoException extends Exception {
  int gravite;

  public DaoException(String message) {
    super(message);
  }

  public DaoException(int gravite,String msgErr){
    super(msgErr);
    setGravite(gravite);
  }

  public void setGravite(int gravite) {
    this.gravite = gravite;
  }

  public int getGravite() {
    return gravite;
  }
}
