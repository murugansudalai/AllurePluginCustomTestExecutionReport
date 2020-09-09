package custom.allure.report.cucumber;

public class TestCaseStatusDetails {
    private String message;
    private String trace;
    private String flaky;
    private String muted;
    private String known;
    public TestCaseStatusDetails(){}

    public TestCaseStatusDetails(String message, String trace, String flaky, String muted, String known) {
        this.message = message;
        this.trace = trace;
        this.flaky = flaky;
        this.muted = muted;
        this.known = known;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTrace() {
        return trace;
    }

    public void setTrace(String trace) {
        this.trace = trace;
    }

    public String getFlaky() {
        return flaky;
    }

    public void setFlaky(String flaky) {
        this.flaky = flaky;
    }

    public String getMuted() {
        return muted;
    }

    public void setMuted(String muted) {
        this.muted = muted;
    }

    public String getKnown() {
        return known;
    }

    public void setKnown(String known) {
        this.known = known;
    }

}
