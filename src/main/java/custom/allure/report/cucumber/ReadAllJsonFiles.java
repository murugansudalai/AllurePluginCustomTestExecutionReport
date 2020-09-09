package custom.allure.report.cucumber;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.*;
import java.util.List;
import static java.lang.System.out;

public class ReadAllJsonFiles<readAllJsonFiles> {

    public void readAllJsonFiles() throws IOException {
        // Step 1: Read JSON File to List Objects
        String jsonString=null;
        JSONParser parser = new JSONParser();
        String folderLocation = "build/allure-results/";
        String fileName = "testCaseStatus";
        File folder = new File(folderLocation);
        File[] listOfFiles = folder.listFiles();
        WriteToFile writeToFile = new WriteToFile();
        // Step 2: Write List Objects to CSV File
        fileName = writeToFile.writeHeaderOfCsvFile(folderLocation,fileName);

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].getName().contains("-result.json")) {
                out.println(listOfFiles[i].getName());

                try {
                    Object obj = parser.parse(new FileReader(folderLocation + listOfFiles[i].getName()));
                    JSONObject jsonObject = (JSONObject) obj;
                    jsonString = jsonObject.toJSONString();

                } catch (Exception e) {
                    e.printStackTrace();
                }

                String jsonStr = "[" + jsonString + "]";
                List<TestCaseStatus> testCaseStatuses = convertJsonString2Objects(jsonStr);
                writeToFile.writeTestStatusToCsv(testCaseStatuses, folderLocation, fileName);
            }
        }
    }
    /**
     *
     * Convert JSON String to List Java Objects
     *
     * @param jsonString
     * @return
     */
    private static List<TestCaseStatus> convertJsonString2Objects(String jsonString){
        List<TestCaseStatus> testCaseStatus = null;
        try {
            testCaseStatus = new ObjectMapper().readValue(jsonString, new TypeReference<List<TestCaseStatus>>(){});
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return testCaseStatus;
    }
}
