import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LogEntry {
    public final String ipAddr;
    public final LocalDateTime time;
    public final HTTP method;
    public final String path;
    public final int responseCode;
    public final int responseSize;
    public final String referer;
    public final String userAgent;


    public LogEntry(String str) throws ParseException {
        String[] logs = str.split(" \\[| \"");
        this.ipAddr = logs[0].substring(0, logs[0].indexOf(" "));
        String strDate = logs[1].substring(0, logs[1].indexOf(" "));
        String datePattern = "dd/MMM/yyyy:HH:mm:ss";
        this.time = LocalDateTime.parse(strDate, DateTimeFormatter.ofPattern(datePattern, Locale.ENGLISH));
        this.method = HTTP.valueOf(logs[2].substring(0, logs[2].indexOf(" ")));
        this.path = logs[2].substring(logs[2].indexOf(" "), logs[2].lastIndexOf("HTTP")).replaceAll(" ", "");
        this.responseCode = Integer.parseInt(logs[2].substring(logs[2].lastIndexOf("\"")).split(" ")[1]);
        this.responseSize = Integer.parseInt(logs[2].substring(logs[2].lastIndexOf("\"")).split(" ")[2]);
        this.referer = logs[3].substring(0, logs[3].indexOf("\""));
        this.userAgent = logs[4].split("\"| \\[FB_IAB")[0];
    }

    public String getIp() {
        return ipAddr;
    }

    public LocalDateTime getDatestamp() {
        return time;
    }

    public HTTP getRequest() {
        return method;
    }

    public String getPathRequest() {
        return path;
    }

    public int getHttpAnswer() {
        return responseCode;
    }

    public int getDataSize() {
        return responseSize;
    }

    public String getPathStartPage() {
        return referer;
    }

    public String getUserAgent() {
        return userAgent;
    }

    @Override
    public String toString() {
        return "LogEntry:\n" +
                "ip =" + ipAddr
                + "\ndatestamp = " + time
                + "\nrequest = " + method
                + "\npathOfRequest = " + path
                + "\nhttpAnswer = " + responseCode
                + "\ndataSize = " + responseSize
                + "\npathStartPage = " + referer
                + "\nuserAgent = " + userAgent;
    }

    public enum HTTP {
        GET, POST, PUT, DELETE
    }
}
