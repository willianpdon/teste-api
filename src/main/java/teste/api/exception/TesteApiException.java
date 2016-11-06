package teste.api.exception;

public class TesteApiException extends Exception {

	private static final long serialVersionUID = 1L;

	public TesteApiException(String msg){
		super(msg);
	}

	public TesteApiException(String msg, Throwable cause){
		super(msg, cause);
	}
}
