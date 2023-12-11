package DependencyInversion;

/*
 * Dependency Inversion states that high level modules should not depend on low level modules, but rather they should depend on abstractions.
 * And those abbstractions should not depend on details.
 * 
 * Ill be using the code from Open Closed and refactor it to adhere to the Dependency Inversion principle, as it currently does not.
 * 
 * The UserAuthenticator, FindUsers, UserActivator, UserPrinter, and MessageUser classes are directly dependent on the User class. 
 * 
 * To make this code adhere to the Dependency Inversion Principle, I should introduce an abstraction (interface) that the UserAuthenticator, 
 *  FindUsers, UserActivator, UserPrinter, and MessageUser classes depend on, instead of depending directly on the User class.
 */

 import java.util.*;

 public class DependencyInversion_Good {

   public static void main(String[] args) {

       Users users = new Users();

       users.createUser("John", "1234", false);
       users.createUser("Ben", "1234", false);

       UserAuthenticator userAuthenticator = new UserAuthenticator(users);
       UserPrinter userPrinter = new UserPrinter();
       FindUsers findUsers = new FindUsers(users);


       if(userAuthenticator.authenticateUser("John", "1234")) {
           IUser user = findUsers.findUserByName("John");

           UserActivator userActivator = new UserActivator(user);
           MessageUser userMessage = new MessageUser();

           userActivator.activateUser();
           userPrinter.printUser(user);

           userMessage.sendMessage(user, findUsers.findUserByName("Ben"), "Hello World!");
           user.getOutbox();
       }

       if (userAuthenticator.authenticateUser("Ben", "1234")) {
           IUser user2 = findUsers.findUserByName("Ben");
           UserActivator userActivator = new UserActivator(user2);

           userActivator.activateUser();
           userPrinter.printUser(user2);

           user2.getInbox();
       }

   }

}

//> Users related classes
class Users {
  public List<IUser> users;

  public Users() {
      this.users = new ArrayList<>();
  }

  public void createUser (String name, String password, boolean active) {
      User user = new User(name, password, active);
      users.add(user);
  }

  public List<IUser> getUsers() {
      return users;
  }
}


interface Inbox {
   public Map<IUser, String> inbox = new HashMap<IUser, String>();
}

interface Outbox { //> created outbox
   public Map<IUser, String> outbox = new HashMap<IUser, String>();
}

interface IUser {
  String getUserName();
  String getUserPassword();
  boolean getUserActive();
  void setActive(boolean active);
  void setInbox(String name, String message);
  void addToOutbox(IUser towards, String message);
  void getOutbox();
  void getInbox();
}

class OutboxSystem implements Outbox {

   public void addToOutbox (IUser towards, String message) {
       outbox.put(towards, message);
   }

   public void getOutbox() {
       System.out.println(outbox);
   }

}

class User extends OutboxSystem implements Inbox, IUser { //> extended from outbox

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

   public void setActive(boolean active) {
       this.active = active;
   }

   public void getInbox() {
       System.out.println(inbox);
   }

   public void setInbox(String name, String message) {
       inbox.put(new User(name, password, true), message);
   }

   public void addToOutbox(IUser towards, String message) {
       outbox.put(towards, message);
   }
}


class FindUsers {
   private Users users;

   public FindUsers(Users users) {
       this.users = users;
   }

   public IUser findUserByName(String name) {
       for (IUser user : users.getUsers()) {
           if (user.getUserName().equals(name)) {
               return user;
           }
       }
       return null;
   }

   public IUser findUser(String name, String password) {
       for (IUser user : users.getUsers()) {
           if (user.getUserName().equals(name) && user.getUserPassword().equals(password)) {
               return user;
           }
       }
       return null;
   }

}


class UserAuthenticator {
   private FindUsers findUsers;

   public UserAuthenticator(Users users) {
       this.findUsers = new FindUsers(users);
   }

   public boolean authenticateUser(String name, String password) {

       IUser user = findUsers.findUser(name, password);

       if (user != null) {
           return true;
       }

       return false;
   }

}


class UserActivator {
   private IUser user;

   public UserActivator(IUser user) {
       this.user = user;
   }

   public void activateUser() {
       user.setActive(true);
   }

   public void deactivateUser() {
       user.setActive(false);
   }

}


class UserPrinter {

   public void printUser(IUser user) {
       System.out.println("User name: " + user.getUserName());
       System.out.println("User password: " + user.getUserPassword());
       System.out.println("User active: " + user.getUserActive());
   }

}


class MessageUser {

   public void sendMessage(IUser from, IUser to, String message) {
       to.setInbox(from.getUserName(), message);
       from.addToOutbox(to, message);
   }

}

