package custom.allure.report.cucumber;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static java.lang.System.out;

public class WriteToFile {
    public WriteToFile() throws IOException {
    }

    public String writeHeaderOfCsvFile(String folderLocation, String pathFile) throws IOException {
        String HEADER = "Scenario Name,Test Status,Step Name,Step Test Status,Order Number,Name of Attachment,File Name of Attachment,Type of Attachment";
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        String fileName = folderLocation+pathFile+timeStamp+".csv";
        //File writer
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true));
        //Write header to the File
        bufferedWriter.write(HEADER);
        return fileName;
    }

    /**
     * Write List Objects to CSV File
     *
     * @param testCaseStatus
     */
    public void writeTestStatusToCsv(List<TestCaseStatus> testCaseStatus, String folderLocation, String fileName) throws IOException {
        /*
        Initialize all elements
         */
        List<TestStepStatus> testStepStatus = null;
        List<TestStepAttachment> testStepAttachments = null;
        List<TestCaseStatusDetails> testCaseStatusDetails=null;
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true));

        try {
            //Write Test case name and status
            for (TestCaseStatus caseStatus : testCaseStatus) {
                List<String> data = Arrays.asList(
                        caseStatus.getName(),
                        caseStatus.getStatus(),
                        ""
                );
                bufferedWriter.write(data.toString().replace("[", "").replace("]", ""));
                Gson gson = new Gson();
                //test status details if failed
//                testCaseStatusDetails = (List<TestCaseStatusDetails>) caseStatus.getStatusDetails();
//                String jsonCaseStatusString = gson.toJson(testCaseStatusDetails);
//                testCaseStatusDetails = new ObjectMapper().readValue(jsonCaseStatusString, new TypeReference<List<TestCaseStatusDetails>>() {
//                });
//                for (TestCaseStatusDetails testCaseStatusDetail : testCaseStatusDetails) {
//                    List<String> dataTestCaseStatusDetail = Arrays.asList(
//                            testCaseStatusDetail.getMessage(),
//                            testCaseStatusDetail.getTrace(),
//                            ""
//                    );

//                    bufferedWriter.write(dataTestCaseStatusDetail.toString().replace(","," "));
//                }

                //Test Steps name, status
                testStepStatus = caseStatus.getSteps();
                String jsonStepString = gson.toJson(testStepStatus);
                testStepStatus = new ObjectMapper().readValue(jsonStepString, new TypeReference<List<TestStepStatus>>() {
                });
                for (TestStepStatus testSteps : testStepStatus) {
                    List<String> dataStep = Arrays.asList(
                            testSteps.getName(),
                            testSteps.getStatus()
                    );
                    //append two comma, if it's not first step
                    if (testStepStatus.indexOf(testSteps) >= 1) {
                        bufferedWriter.write(",");
                        bufferedWriter.write(",");
                    }
                    bufferedWriter.write(dataStep.toString().replace("[", "").replace("]", ""));
                    //Add details about the attachments for each step if available
                    testStepAttachments = testSteps.getAttachments();
                    String jsonStepAttachmentString = gson.toJson(testStepAttachments);
                    testStepAttachments = new ObjectMapper().readValue(jsonStepAttachmentString, new TypeReference<List<TestStepAttachment>>() {});
                    for (TestStepAttachment testStepAttach : testStepAttachments) {
                        List<String> dataStepAttachment = Arrays.asList(
                                "",
                                testStepAttach.getName(),
                                testStepAttach.getSource(),
                                testStepAttach.getType()
                        );
                        bufferedWriter.write(dataStepAttachment.toString().replace("[", "").replace("]", ""));
                        //append the content of the text file value
                        if(testStepAttach.getSource().contains(".txt")){
                            RetrieveValueFromFile retrieveValueFromFile = new RetrieveValueFromFile();
                            bufferedWriter.write(",");
                            bufferedWriter.write(retrieveValueFromFile.retrieveValueFromFile(folderLocation,testStepAttach.getSource()));
                        }
                    }
                    bufferedWriter.newLine();
                }
            }

        } catch (Exception e) {
            out.println("Writing CSV error!");
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.flush();
                bufferedWriter.close();
            } catch (IOException e) {
                out.println("Flushing/closing error!");
                e.printStackTrace();
            }
        }
    }
}
