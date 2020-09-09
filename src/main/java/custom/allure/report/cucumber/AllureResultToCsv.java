package custom.allure.report.cucumber;

import java.io.IOException;

public class AllureResultToCsv {

    public static void main(String[] args) throws IOException {
        ReadAllJsonFiles readAllJsonFiles = new ReadAllJsonFiles();
        readAllJsonFiles.readAllJsonFiles();
    }
}