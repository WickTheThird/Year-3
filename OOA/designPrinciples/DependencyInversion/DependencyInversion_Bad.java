package DependencyInversion;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;


public class DependencyInversion_Bad {

    public static void main(String[] args) {

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
            user.getOutbox();
        }

        if (userAuthenticator.authenticateUser("Ben", "1234")) {
            User user2 = findUsers.findUserByName("Ben");
            UserActivator userActivator = new UserActivator(user2);

            userActivator.activateUser();
            userPrinter.printUser(user2);

            user2.getInbox();
        }

    }

}

//> Users related classes
class Users {
   public List<User> users;

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
}


interface Inbox {
    public Map<User, String> inbox = new HashMap<User, String>();
}

interface Outbox { //> created outbox
    public Map<User, String> outbox = new HashMap<User, String>();
}

class OutboxSystem implements Outbox {

    public void addToOutbox (User towards, String message) {
        outbox.put(towards, message);
    }

    public void getOutbox() {
        System.out.println(outbox);
    }

}

class User extends OutboxSystem implements Inbox  { //> extended from outbox

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

    public void getInbox() {
        System.out.println(inbox);
    }

    public void setInbox(String name, String password) {
        inbox.put(new User(name, password, true), "Hello World!");
    }

}


class FindUsers {
    private Users users;

    public FindUsers(Users users) {
        this.users = users;
    }

    public User findUserByName(String name) {
        for (User user : users.getUsers()) {
            if (user.getUserName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    public User findUser(String name, String password) {
        for (User user : users.getUsers()) {
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

        User user = findUsers.findUser(name, password);

        if (user != null) {
            return true;
        }

        return false;
    }

}


class UserActivator {
    private User user;

    public UserActivator(User user) {
        this.user = user;
    }

    public void activateUser() {
        user.active = true;
    }

    public void deactivateUser() {
        user.active = false;
    }

}


class UserPrinter {

    public void printUser(User user) {
        System.out.println("User name: " + user.getUserName());
        System.out.println("User password: " + user.getUserPassword());
        System.out.println("User active: " + user.getUserActive());
    }

}


class MessageUser {

    public void sendMessage(User from, User to, String message) {
        to.setInbox(from.getUserName(), message);
        from.addToOutbox(to, message);
    }

}