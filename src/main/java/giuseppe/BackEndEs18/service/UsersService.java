package giuseppe.BackEndEs18.service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import giuseppe.BackEndEs18.entities.User;

@Service
public class UsersService {

	private List<User> users = new ArrayList<>();

	public User save(User user) {
		Random rndm = new Random();
		user.setId(rndm.nextInt());
		this.users.add(user);
		return user;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public Optional<User> findById(int id) {
		User u = null;

		for (User user : users) {
			if (user.getId() == id)
				u = user;
		}

		return Optional.ofNullable(u);
	}

	public void findByIdAndDelete(int id) {
		ListIterator<User> iterator = this.users.listIterator();

		while (iterator.hasNext()) {
			User currentUser = iterator.next();
			if (currentUser.getId() == id) {
				iterator.remove();
			}
		}
	}

	public Optional<User> findByIdAndUpdate(int id, User user) {
		User found = null;

		for (User currentUser : users) {
			if (currentUser.getId() == id) {
				found = currentUser;
				found.setUsername(user.getUsername());
				;
				found.setNomeCompleto(user.getNomeCompleto());
				found.setEmail(user.getEmail());
				found.setId(id);
			}
		}
		return Optional.ofNullable(found);

	}

}
