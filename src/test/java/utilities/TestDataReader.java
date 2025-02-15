package utilities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class TestDataReader {

    private String urlMainPage;
    private List<WebTablesData> webTablesTestData;

    public static TestDataReader readTestData() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File("src/test/resources/testData.json"), TestDataReader.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read test data from JSON file", e);
        }
    }

    public String getUrlMainPage() {
        return urlMainPage;
    }

    public void setUrlMainPage(String urlMainPage) {
        this.urlMainPage = urlMainPage;
    }

    public List<WebTablesData> getWebTablesTestData() {
        return webTablesTestData;
    }

    public void setWebTablesTestData(List<WebTablesData> webTablesTestData) {
        this.webTablesTestData = webTablesTestData;
    }

    public String[] getWebTablesTestData(int index) {
        WebTablesData data = webTablesTestData.get(index);
        return new String[]{
            data.getFirstName(),
            data.getLastName(),
            data.getEmail(),
            data.getAge(),
            data.getSalary(),
            data.getDepartment()
        };
    }

    public static class WebTablesData {
        private String firstName;
        private String lastName;
        private String email;
        private String age;
        private String salary;
        private String department;

        public String getFirstName() { return firstName; }

        public void setFirstName(String firstName) { this.firstName = firstName; }

        public String getLastName() { return lastName; }

        public void setLastName(String lastName) { this.lastName = lastName; }

        public String getEmail() { return email; }

        public void setEmail(String email) { this.email = email; }

        public String getAge() { return age; }

        public void setAge(String age) { this.age = age; }

        public String getSalary() { return salary; }

        public void setSalary(String salary) { this.salary = salary; }

        public String getDepartment() { return department; }

        public void setDepartment(String department) { this.department = department; }
    }
}
