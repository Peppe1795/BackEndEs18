package giuseppe.BackEndEs18.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import giuseppe.BackEndEs18.entities.User;
import giuseppe.BackEndEs18.service.UsersService;

@RestController
@RequestMapping("/users")
public class UserController {
	private final UsersService userSrv;

	public UserController(UsersService userSrv) {
		this.userSrv = userSrv;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public List<User> find() {
		return userSrv.getUsers();
	}

	@GetMapping("/{userId}")
	public User findById(@PathVariable int userId) throws Exception {
		return userSrv.findById(userId).orElseThrow(() -> new Exception("NON TROVATO"));
	}

	@PutMapping("/{userId}")
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public User findByIdAmdUpdate(@PathVariable int id, @RequestBody User body) throws Exception {
		return userSrv.findByIdAndUpdate(id, body)
				.orElseThrow(() -> new Exception("User non trovato impossibile aggiornare le credenziali"));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User saveUser(@RequestBody User body) throws Exception {
		User createdUser = userSrv.save(body);
		return createdUser;
	}

	@DeleteMapping("/{userId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void findAndDelete(@PathVariable int userId) {
		userSrv.findByIdAndDelete(userId);
	}

}
