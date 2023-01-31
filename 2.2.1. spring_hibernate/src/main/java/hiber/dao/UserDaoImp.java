package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   private String HQL = "SELECT car.user FROM Car car WHERE car.model=:model and car.series=:series";

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {sessionFactory.getCurrentSession().save(user);}

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public List<User> userByCar(String model, int series) {
      return sessionFactory.getCurrentSession().createQuery(HQL)
              .setParameter("model", model)
              .setParameter("series", series)
              .getResultList();
   }

}
