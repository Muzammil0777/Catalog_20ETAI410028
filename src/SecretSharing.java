import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class SecretSharing {
    public static void main(String[] args) throws Exception {
        // Load and process the first JSON test case file
        processJsonFile("testcases/testcase1.json");

        // Load and process the second JSON test case file
        processJsonFile("testcases/testcase2.json");
    }

    private static void processJsonFile(String filePath) throws Exception {
        // Read the JSON file
        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(content, JsonObject.class);

        // Parse keys
        JsonObject keys = jsonObject.getAsJsonObject("keys");
        int n = keys.get("n").getAsInt();
        int k = keys.get("k").getAsInt();

        // Decode the Y values
        long[][] points = new long[n][2];  // Change to long
        int count = 0;
        for (Map.Entry<String, com.google.gson.JsonElement> entry : jsonObject.entrySet()) {
            if (entry.getKey().equals("keys")) continue; // Skip keys
            JsonObject root = entry.getValue().getAsJsonObject();
            int base = root.get("base").getAsInt();
            String value = root.get("value").getAsString();
            long decodedValue = Long.parseLong(value, base); // Decode Y value as long
            points[count][0] = Long.parseLong(entry.getKey()); // Parse x as long
            points[count][1] = decodedValue; 
            count++;
        }

        // Calculate the constant term using Lagrange interpolation
        double c = lagrangeInterpolation(points, n, 0); // Evaluate at x=0
        System.out.println("The constant term c for file " + filePath + " is: " + c);
    }

    // Lagrange Interpolation Function
    public static double lagrangeInterpolation(long[][] points, int n, double x) {
        double result = 0.0;
        for (int i = 0; i < n; i++) {
            double term = points[i][1]; // Keep the y value as a double for accuracy
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    term = term * (x - points[j][0]) / (points[i][0] - points[j][0]);
                }
            }
            result += term;
        }
        return result;
    }
}
