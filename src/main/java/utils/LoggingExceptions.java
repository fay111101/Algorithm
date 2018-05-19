<<<<<<< HEAD:test/src/main/java/utils/LoggingExceptions.java
package utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

class LogException extends Exception {
    private static Logger logger= Logger.getLogger("LoggingException");

    public LogException() {
        StringWriter trace=new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }

}
public class LoggingExceptions{
    public static void main(String[] args){
        try{
            throw new LogException();
        }catch(LogException e){
            System.err.println("Caught "+e);
        }
        try{
            throw new LogException();
        }catch(LogException e){
            System.err.println("Caught "+e);

            System.err.println("Caught "+e.getLocalizedMessage());
            System.err.println("Caught "+e.getMessage());


        }
    }

=======
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

class LogException extends Exception {
    private static Logger logger= Logger.getLogger("LoggingException");

    public LogException() {
        StringWriter trace=new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }

}
public class LoggingExceptions{
    public static void main(String[] args){
        try{
            throw new LogException();
        }catch(LogException e){
            System.err.println("Caught "+e);
        }
        try{
            throw new LogException();
        }catch(LogException e){
            System.err.println("Caught "+e);

            System.err.println("Caught "+e.getLocalizedMessage());
            System.err.println("Caught "+e.getMessage());


        }
    }

>>>>>>> 29e5412baafe1c3e828bcc824210d0be06cdac0c:test/src/main/java/LoggingExceptions.java
}