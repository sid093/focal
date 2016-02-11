package beans;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.persistence.User;
/**
 * Session Bean implementation class PersonBean
 */
@Stateless
@LocalBean
public class UserBean {
	@PersistenceContext
	public static EntityManager em;
	public List<User> getAllUsers() {
		return em.createNamedQuery("AllUsers").getResultList();
	}
	public void addUser(User user) {
		em.persist(user);
		em.flush();
	}
}
