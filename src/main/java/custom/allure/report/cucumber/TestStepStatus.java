package custom.allure.report.cucumber;

import java.util.List;
import java.util.Map;

public class TestStepStatus {
    private List attachments;
    private String stage;
    private String name;
    private String status;
    private List parameters;
    private String stop;
    private String start;
    private Map statusDetails;
    public List steps;
    public TestStepStatus(){}
    public TestStepStatus(List attachments, String stage, String name, String status, Map statusDetails, List steps, List parameters, String stop, String start) {
        this.attachments = attachments;
        this.stage = stage;
        this.name = name;
        this.status = status;
        this.statusDetails = statusDetails;
        this.steps = steps;
        this.parameters = parameters;
        this.stop = stop;
        this.start = start;
    }


    public List getAttachments() {
        return attachments;
    }

    public void setAttachments(List attachments) {
        this.attachments = attachments;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Map getStatusDetails() {
        return statusDetails;
    }

    public void setStatusDetails(Map statusDetails) {
        this.statusDetails = statusDetails;
    }

    public List getSteps() {
        return steps;
    }

    public void setSteps(List steps) {
        this.steps = steps;
    }

    public List getParameters() {
        return parameters;
    }

    public void setParameters(List parameters) {
        this.parameters = parameters;
    }

    public String getStop() {
        return stop;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

}