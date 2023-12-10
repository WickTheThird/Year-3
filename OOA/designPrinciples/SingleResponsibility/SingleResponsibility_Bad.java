package SingleResponsibility;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;


/*
 * This is a code that violates SRP
 * 
 * The reason this code violates SRP is because the Users class has too many responsabilities.
 * It finds the users, it sends messages to users, it authenticates users, etc. 
 * Those tasks should be split as this this class will need multiple changes if one of those tasks changes, thus violating one of the SRP principles.
 */


public class SingleResponsibility_Bad {

   public static void main(String[] args) {
       //> Showcase SRP violation

       Users users = new Users();

       users.createUser("John", "1234", false);
       users.createUser("Ben", "1234", false);

       UserAuthenticator userAuthenticator = new UserAuthenticator(users);
       UserPrinter userPrinter = new UserPrinter();
       FindUsers findUsers = new FindUsers(users);

       if(userAuthenticator.authenticateUser("John", "1234")) {
           User user = findUsers.findUserByName("John");

           UserActivator userActivator = new UserActivator(user);
           MessageUser userMessage = new MessageUser();

           userActivator.activateUser();
           userPrinter.printUser(user);

           userMessage.sendMessage(user, findUsers.findUserByName("Ben"), "Hello World!");
       }

       if (userAuthenticator.authenticateUser("Ben", "1234")) {
           User user2 = findUsers.findUserByName("Ben");
           UserActivator userActivator = new UserActivator(user2);

           userActivator.activateUser();
           userPrinter.printUser(user2);

           users.getInbox(user2);
       }

   }

}

interface Inbox {
    public Map<User, String> inbox = new HashMap<User, String>();

}

class Users implements Inbox {
  public List<User> users;
  public Map<User, String> inbox = new HashMap<>();

  public Users() {
      this.users = new ArrayList<>();
  }

  public void createUser (String name, String password, boolean active) {
      User user = new User(name, password, active);
      users.add(user);
  }

  public List<User> getUsers() {
      return users;
  }

  public void setInbox(User user, String message) {
      inbox.put(user, message);
  }

  public void getInbox(User user) {
      System.out.println(inbox.get(user));
  }

  public User findUserByName(String name) {
      for (User user : users) {
          if (user.getUserName().equals(name)) {
              return user;
          }
      }
      return null;
  }

  public User findUser(String name, String password) {
      for (User user : users) {
          if (user.getUserName().equals(name) && user.getUserPassword().equals(password)) {
              return user;
          }
      }
      return null;
  }

  public boolean authenticateUser(String name, String password) {
      User user = findUser(name, password);
      return user != null;
  }

  public void activateUser(User user) {
      user.active = true;
  }

  public void deactivateUser(User user) {
      user.active = false;
  }

  public void printUser(User user) {
      System.out.println("User name: " + user.getUserName());
      System.out.println("User password: " + user.getUserPassword());
      System.out.println("User active: " + user.getUserActive());
  }

  public void sendMessage(User from, User to, String message) {
      setInbox(to, message);
  }
}


class User {

   private String name;
   private String password;
   public boolean active;

   public User(String name, String password, boolean active) {
       this.name = name;
       this.password = password;
       this.active = active;
   }

   public String getUserName() {
       return name;
   }

   public String getUserPassword() {
       return password;
   }

   public boolean getUserActive() {
       return active;
   }


}

