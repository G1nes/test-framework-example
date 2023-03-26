package ui;

import com.codeborne.selenide.Selenide;
import org.awaitility.Awaitility;
import org.openqa.selenium.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DriverContext {

    private final static long TIMEOUT_SPECIFIC_REQUEST_EXECUTION = 10;

    public static void waitUntilRequestComplete(String endpoint) {
        long startAmount = getAmountOfExecutedHttpRequestsByEndpoint(endpoint);
        Awaitility.await()
                .pollInSameThread()
                .atMost(TIMEOUT_SPECIFIC_REQUEST_EXECUTION, TimeUnit.SECONDS)
                .until(() -> startAmount < getAmountOfExecutedHttpRequestsByEndpoint(endpoint));
    }

    private static long getAmountOfExecutedHttpRequestsByEndpoint(String endpointCriterion) {
        List<Map<String, Object>> browserRequests = (List<Map<String, Object>>) getJavaScriptExecutor()
                        .executeScript("var network = performance.getEntries() || {}; return network;");
        return browserRequests.stream()
                .map(request -> String.valueOf(request.get("name")))
                .filter(value -> value.contains(endpointCriterion))
                .count();
    }

    private static JavascriptExecutor getJavaScriptExecutor() {
        return (JavascriptExecutor) Selenide.webdriver().object();
    }
}
