package giuseppe.BackEndEs18.Exception;

public class NotFoundExceptionLongId extends RuntimeException {
	public NotFoundExceptionLongId(String message) {
		super(message);
	}

	public NotFoundExceptionLongId(Long id) {
		super(id + " non trovato!");
	}
}
