package giuseppe.BackEndEs18.Exception;

public class NotFoundException extends RuntimeException {
	public NotFoundException(String message) {
		super(message);
	}

	public NotFoundException(int id) {
		super(id + " non trovato!");
	}
}
