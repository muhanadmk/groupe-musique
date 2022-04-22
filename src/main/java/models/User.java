package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "iduser")
  private Integer id;

  @Column(name = "user", nullable = false, unique = true)
  private String user;

  @Column(name = "password" , nullable = false)
  private String password;

  @Column(name = "sel" , nullable = false)
  private  String sel;

  public User() {
  }

  public User(String user, String password, String sel) {
    setUser(user);
    setPassword(password);
    setSel(sel);
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUser() {
    return this.user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public  String getSel() {
    return this.sel;
  }

  public void setSel( String sel) {
    this.sel = sel;
  }


  @Override
  public String toString() {
    return "{" +
      " user='" + getUser() + "'" +
      ", password='" + getPassword() + "'" +
      "}";
  }
}
