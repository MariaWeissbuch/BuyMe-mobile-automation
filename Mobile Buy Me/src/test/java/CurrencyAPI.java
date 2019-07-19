import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.json.Json;

import java.io.IOException;

public class CurrencyAPI {
    public static void main(String[] args) throws IOException, JSONException {
        // use OKHttp client to create the connection and retrieve data
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://free.currconv.com/api/v7/convert?q=USD_EUR&compact=y&apiKey=3365ad9e145157bba5a8")
                .build();
        Response response = client.newCall(request).execute();
        String jsonData = response.body().string();
        // parse JSON
        JSONObject mainJsonObject = new JSONObject(jsonData);
        // get Json object
        Json j = new Json();

        JSONObject resultsJson = mainJsonObject.getJSONObject("USD_EUR");
        // get value still JSON
        //getting the value from the JSON as a double
        double val = resultsJson.getDouble("val");
        System.out.println(val);
    }
}
