package test;

/**
 * Created by Роман on 14.06.2017.
 */
public class util {
    public static String stackTrace(Exception e) {
        StringBuffer stringBuffer = new StringBuffer();
        StackTraceElement[] stackTraceElements = e.getStackTrace();
        for (int i = 0; i < stackTraceElements.length; i++) {
            stringBuffer.append(stackTraceElements[i].toString() + System.lineSeparator());
        }
        return stringBuffer.toString();
    }
}
