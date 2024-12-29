import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class UserAgent {
    public final String os;
    public final String browser;

    public UserAgent(String str) throws ParseException {

        if (str.contains("Windows")) {
            this.os = "Windows";
        } else if (str.contains("Linux")) {
            this.os = "Linux";
        } else if (str.contains("Macintosh")) {
            this.os = "macOS";
        } else this.os = "another OS";

        if (str.contains("Firefox/")) {
            this.browser = "Firefox";
        } else if (str.contains("Chrome/")) {
            if (str.contains("OPR")) {
                this.browser = "Opera";
            } else if (str.contains("Edg")) {
                this.browser = "EDGE";
            } else {
                this.browser = "Chrome";
            }
        } else if ((str.contains("Mobile/")) && (str.contains("Safari"))) {
            this.browser = "Safari";
        } else if (str.contains("Opera")) {
            this.browser = "Opera";
        } else {
            this.browser = "another Browser";
        }

    }

    public String getOs() {
        return os;
    }

    public String getBrowser() {
        return browser;
    }

    @Override
    public String toString() {
        return
                "os = " + os + "\nbrowser = " + browser;
    }
}
