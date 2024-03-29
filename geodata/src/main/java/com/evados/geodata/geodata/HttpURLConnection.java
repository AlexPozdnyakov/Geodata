package com.evados.geodata.geodata;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

class MyHttpURLConnection {


    private final String USER_AGENT = "Mozilla/5.0";

    // HTTP GET request
    public void sendGet(String params, String Url) throws Exception {

        URL obj = new URL(Url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + Url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

    }

    // HTTP POST request
    public void sendPost(String params, String Url) throws Exception {
//        HttpClient httpClient = new DefaultHttpClient();
//        HttpPost request = new HttpPost("http://yoururl");
//        StringEntity params =new StringEntity("details={\"name\":\"myname\",\"age\":\"20\"} ");
//        request.addHeader("content-type", "application/x-www-form-urlencoded");
//        request.setEntity(params);
//        HttpResponse response = httpClient.execute(request);

        URL obj = new URL(Url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("charset", "utf-8");
        con.setRequestProperty("Accept", "application/json");
        // Send post request
        con.setDoOutput(true);
        con.connect();
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(params);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + Url);
        System.out.println("Post parameters : " + params);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

    }

}