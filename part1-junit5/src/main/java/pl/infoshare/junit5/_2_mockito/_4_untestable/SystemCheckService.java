package pl.infoshare.junit5._2_mockito._4_untestable;

public class SystemCheckService {

    public String getOperationSystem() {
        if (System.lineSeparator().equals("\r\n")) {
            return "Windows";
        }

        if (System.lineSeparator().equals("\n")) {
            return "UNIX";
        }

        return "unknown";
    }
}
