package PackException;

@SuppressWarnings("serial")
public class MissileException extends RuntimeException {

    public MissileException(String message) {
	   super(message);
    }
}