package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));


      User userTest1 = new User("name", "lastName", "email");
      User userTest2 = new User("Ivan", "Ivanov", "ivan@mail.ru");
      Car carTest1 = new Car("model", 123);
      Car carTest2 = new Car("model2", 321);
      userTest1.setCar(carTest1);
      userTest2.setCar(carTest2);
      userService.add(userTest1);
      userService.add(userTest2);

      userService.userByCar(carTest1.getModel(),carTest1.getSeries()).forEach(System.out::println);
      userService.userByCar(carTest2.getModel(), carTest2.getSeries()).forEach(System.out::println);


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         if (user.getCar() != null) {
            System.out.println(user.getCar().toString());
         }
      }

      context.close();
   }
}
