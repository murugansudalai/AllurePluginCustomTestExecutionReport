package custom.allure.report.cucumber;

import java.util.List;
import java.util.Map;

public class TestCaseStatus {
    private List attachments;
    private String start;
    private String description;
    private String fullName;
    public List steps;
    private String uuid;
    private List labels;
    private String stage;
    private String stop;
    private String historyId;
    private String name;
    private List links;
    private String status;
    private List parameters;
    private Map statusDetails;

    public Map getStatusDetails() {
        return statusDetails;
    }

    public void setStatusDetails(Map statusDetails) {
        this.statusDetails = statusDetails;
    }

    public TestCaseStatus(){}
    public TestCaseStatus(List attachments, Map statusDetails,String start, String description, String fullName, List steps, String uuid, List labels, String stage, String stop, String historyId, String name, List links, String status, List parameters) {
        this.attachments = attachments;
        this.statusDetails = statusDetails;
        this.start = start;
        this.description = description;
        this.fullName = fullName;
        this.steps = steps;
        this.uuid = uuid;
        this.labels = labels;
        this.stage = stage;
        this.stop = stop;
        this.historyId = historyId;
        this.name = name;
        this.links = links;
        this.status = status;
        this.parameters = parameters;
    }



    public List getAttachments() {
        return attachments;
    }

    public void setAttachments(List attachments) {
        this.attachments = attachments;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List getSteps() {
        return steps;
    }

    public void setSteps(List steps) {
        this.steps = steps;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public List getLabels() {
        return labels;
    }

    public void setLabels(List labels) {
        this.labels = labels;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getStop() {
        return stop;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }

    public String getHistoryId() {
        return historyId;
    }

    public void setHistoryId(String historyId) {
        this.historyId = historyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getLinks() {
        return links;
    }

    public void setLinks(List links) {
        this.links = links;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List getParameters() {
        return parameters;
    }

    public void setParameters(List parameters) {
        this.parameters = parameters;
    }


}