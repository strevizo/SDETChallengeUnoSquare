package Challenge;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import java.io.IOException;

public class APICalls {
    private CloseableHttpClient client;
    private CloseableHttpResponse response;
    private int statusCode;
    private JSONArray ja;
    private JSONObject jo;

    public APICalls() throws IOException, ParseException {
        this.client = HttpClientBuilder.create().build();
        makeTheCall();
    }

    private void makeTheCall() throws IOException, ParseException {
        //Make the call
        try {
            response = client.execute(new HttpGet("https://jsonplaceholder.typicode.com/users"));
            statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Could not fetch endpoint with HTTP error code : " + statusCode);
            }

            //Now get the response object
            HttpEntity httpEntity = response.getEntity();
            String apiOutput = EntityUtils.toString(httpEntity);

            //Parse the object, convert to array and get the first item
            //this can be changed later to work the test with all users in the JSON
            Object obj = new JSONParser().parse(apiOutput);
            ja = (JSONArray) obj;
        }finally{
            client.close();
        }
    }

    public String getName() throws IOException, ParseException {
        jo = (JSONObject) ja.get(0);
        String name = (String) jo.get("name");
        return name;
    }

    public String getEmail(){
        jo = (JSONObject) ja.get(0);
        String email = (String) jo.get("email");
        return email;
    }
}
