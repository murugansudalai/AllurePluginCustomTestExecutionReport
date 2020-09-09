package custom.allure.report.cucumber;

public class TestStepAttachment {
    private String name;
    private String source;
    private String type;

    public TestStepAttachment() {}

    public TestStepAttachment(String name, String source, String type) {
        this.name = name;
        this.source = source;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() { return source; }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}