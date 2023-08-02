package giuseppe.BackEndEs18.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import giuseppe.BackEndEs18.Exception.BadRequestException;
import giuseppe.BackEndEs18.Exception.NotFoundException;
import giuseppe.BackEndEs18.entities.User;
import giuseppe.BackEndEs18.entities.UserRequestPayload;
import giuseppe.BackEndEs18.repository.UserRepository;

@Service
public class UsersService {
	private final UserRepository usersRepo;

	@Autowired
	public UsersService(UserRepository userRep) {
		this.usersRepo = userRep;
	}

	public User create(UserRequestPayload body) {
		usersRepo.findByEmail(body.getEmail()).ifPresent(user -> {
			throw new BadRequestException("L'email è già stata utilizzata");
		});
		User newUser = new User(body.getUsername(), body.getNomeCompleto(), body.getEmail());
		return usersRepo.save(newUser);
	}

	public Page<User> find(int page, int size, String sort) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
		return usersRepo.findAll(pageable);
	}

	public User findById(int id) throws NotFoundException {
		return usersRepo.findById(id).orElseThrow(() -> new NotFoundException(id));
	}

	public User findByIdAndUpdate(int id, UserRequestPayload body) throws NotFoundException {
		User found = this.findById(id);
		found.setEmail(body.getEmail());
		found.setNomeCompleto(body.getNomeCompleto());
		found.setUsername(body.getUsername());

		return usersRepo.save(found);
	}

	public void findByIdAndDelete(int id) throws NotFoundException {
		User found = this.findById(id);
		usersRepo.delete(found);
	}
}
