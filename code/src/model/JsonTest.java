package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;


import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.*;
import org.json.simple.parser.JSONParser;



public class JsonTest {

	public static void main (String args[]) throws Exception {
//		try {
//
//	        URL url = new URL("http://gpu0.usask.ca:20001");
////	                + "&key=AIzaSyAhONZJpMCBqCfQjFUj21cR2klf6JWbVSo");
////	                + "&access_token=" + access_token);
//	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//	        conn.setDoOutput(true);
//	        conn.setRequestMethod("POST");
//	        conn.setRequestProperty("Content-Type", "application/json");
//
//	        String input = "{ \"snippet\": {\"playlistId\": \"WL\",\"resourceId\": {\"videoId\": \"\",\"kind\": \"youtube#video\"},\"position\": 0}}";
//
//	        OutputStream os = conn.getOutputStream();
//	        os.write(input.getBytes());
//	        os.flush();
//
//	        if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
//	            throw new RuntimeException("Failed : HTTP error code : "
//	                + conn.getResponseCode());
//	        }
//
//	        BufferedReader br = new BufferedReader(new InputStreamReader(
//	                (conn.getInputStream())));
//
//	        String output;
//	        System.out.println("Output from Server .... \n");
//	        while ((output = br.readLine()) != null) {
//	            System.out.println(output);
//	        }
//
//	        conn.disconnect();
//
//	      } catch (MalformedURLException e) {
//
//	        e.printStackTrace();
//
//	      } catch (IOException e) {
//
//	        e.printStackTrace();
//
//	     }

//		URL url = new URL("http://freegeoip.net/json/");
//		URL url = new URL("http://gpu0.usask.ca:20001");
//		try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
//            HttpPost request = new HttpPost(url);
//            StringEntity params = new StringEntity(body);
//            request.addHeader("content-type", "application/json");
//            request.setEntity(params);
//            HttpResponse result = httpClient.execute(request);
//
//            String json = EntityUtils.toString(result.getEntity(), "UTF-8");
//            try {
//                JSONParser parser = new JSONParser();
//                Object resultObject = parser.parse(json);
//
//                if (resultObject instanceof JSONArray) {
//                    JSONArray array=(JSONArray)resultObject;
//                    for (Object object : array) {
//                        JSONObject obj =(JSONObject)object;
//                        System.out.println(obj.get("example"));
//                        System.out.println(obj.get("fr"));
//                    }
//
//                }else if (resultObject instanceof JSONObject) {
//                    JSONObject obj =(JSONObject)resultObject;
//                    System.out.println(obj.get("example"));
//                    System.out.println(obj.get("fr"));
//                }
//
//            } catch (Exception e) {
//                // TODO: handle exception
//            }
//
//        } catch (IOException ex) {
//        }
//        return null;
        
        URL url = new URL("https://api.tumblr.com/v2/tagged?tag=gif&api_key=fuiKNFp9vQFvjLNvx4sUwti4Yb5yGutBN4Xh10LXZhhRKjWlV4");
        String data = IOUtils.toString(url, Charset.forName("UTF-8"));
        JSONObject obj = new JSONObject(data);
        System.out.println(obj.get("meta"));
        System.out.println( ((JSONObject) obj.get("meta")).get("msg") );
	}

}

