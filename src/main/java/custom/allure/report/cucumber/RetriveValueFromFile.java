package custom.allure.report.cucumber;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class RetrieveValueFromFile {
    public String retrieveValueFromFile(String folderLocation, String fileName) throws IOException {
        FileReader fileReader = new FileReader(folderLocation + fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String textData = bufferedReader.readLine();
        System.out.println("the value of the file is: "+textData);
        return textData;
    }
}
