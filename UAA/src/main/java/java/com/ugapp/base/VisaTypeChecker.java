package java.com.ugapp.base;
import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class VisaTypeChecker 
{
    private static JSONObject visaData;

    static 
    {
        try {
            // Read JSON data from the file
            String jsonData = new String(Files.readAllBytes(Paths.get("/Users/divyashree/eclipse-workspace1/undergrad/src/test/resources/com/ugapp/Visa_eligibility/Visa eligibility.json")));

            visaData = new JSONObject(jsonData);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error initializing VisaTypeChecker", e);
        }
    }

    public static String findVisaType(String visaText) {
        JSONArray validVisas = visaData.getJSONArray("validVisa");
        JSONArray invalidVisas = visaData.getJSONArray("invalidVisa");

        for (int i = 0; i < validVisas.length(); i++) {
            JSONObject visa = validVisas.getJSONObject(i);
            if (visa.getString("text").equals(visaText)) {
                return "Valid Visa";
            }
        }

        for (int i = 0; i < invalidVisas.length(); i++) {
            JSONObject visa = invalidVisas.getJSONObject(i);
            if (visa.getString("text").equals(visaText)) {
                return "Invalid Visa";
            }
        }

        return "Visa not found";
    }

    public static void main(String[] args) {
        // Example usage
        String visaTextToCheck = "M1 - Vocational student";
        String result = findVisaType(visaTextToCheck);
        System.out.println("The visa type for '" + visaTextToCheck + "' is: " + result);
    }
}
