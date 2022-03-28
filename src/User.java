public class User {
   public String login;
    public String email;
    public String password;
    public int age;


   public User(String login,  String email, String password, int age){
       this.login = login;
       this.email = email;
       this.password = password;
       this.age = age;

   }

public String getLogin(){

       return login;
       }
    public  String getPassword() {

       return password;
    }
    public int getAge() {
        return age;
    }

    public String toString(){
        return getLogin() + " " + getPassword();


    }

    }
