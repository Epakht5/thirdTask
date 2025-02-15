package utilities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ConfigReader {
    @JsonProperty("ExplicitWaitInSeconds")
    private int explicitWait;
    
    @JsonProperty("Language")
    private String language;

    @JsonProperty("BrowserMode")
    private String browserMode;

    @JsonProperty("BrowserType")
    private String browserType;

    public static ConfigReader configReader() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File("src/test/resources/config.json"), ConfigReader.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read test data from JSON file", e);
        }
    }

    public int getExplicitWait() {
        return explicitWait;
    }

    public void setExplicitWait(int explicitWait) {
        this.explicitWait = explicitWait;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getBrowserMode() {
        return browserMode;
    }

    public void setBrowserMode(String browserMode) {
        this.browserMode = browserMode;
    }

    public String getBrowserType() {
        return browserType;
    }

    public void setBrowserType(String browserType) {
        this.browserType = browserType;
    }
}
