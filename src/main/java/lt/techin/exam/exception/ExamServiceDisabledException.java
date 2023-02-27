package lt.techin.exam.exception;


public class ExamServiceDisabledException extends RuntimeException {


    public ExamServiceDisabledException() {
    }

    public ExamServiceDisabledException(String message) {
        super(message);
    }

}
