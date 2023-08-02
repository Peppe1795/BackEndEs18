package giuseppe.BackEndEs18.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import giuseppe.BackEndEs18.entities.User;
import giuseppe.BackEndEs18.entities.UserRequestPayload;
import giuseppe.BackEndEs18.service.UsersService;

@RestController
@RequestMapping("/users")
public class UserController {
	private final UsersService userSrv;

	@Autowired
	public UserController(UsersService userSrv) {
		this.userSrv = userSrv;
	}

	@GetMapping
	public Page<User> getUsers(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "id") String sortBy) {
		return userSrv.find(page, size, sortBy);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User saveUser(@RequestBody UserRequestPayload body) {
		User created = userSrv.create(body);

		return created;
	}

	@GetMapping("/{userId}")
	public User findById(@PathVariable int userId) {
		return userSrv.findById(userId);

	}

	@PutMapping("/{userId}")
	public User updateUser(@PathVariable int userId, @RequestBody UserRequestPayload body) {
		return userSrv.findByIdAndUpdate(userId, body);
	}

	@DeleteMapping("/{userId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable int userId) {
		userSrv.findByIdAndDelete(userId);
	}
}
