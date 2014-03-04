package com.evados.geodata.geodata;

/**
 * Created with IntelliJ IDEA.
 * User: Павел Самсoнов
 * Date: 03.03.14
 * Time: 15:10
 * To change this template use File | Settings | File Templates.
 */
public class Singleton {


    private String Url = "http://146.185.131.151/api/device/";
    private static Singleton instance;
    private Singleton(){}
    MyHttpURLConnection http = new MyHttpURLConnection();


    public void login(String user, String pass) throws Exception{
        String url = Url + "login";
        String body = String.format("{\"login\":\"%s\",\"password\":\"%s\"}", user, pass);
        http.sendPost(body, url);

    }
    public void logout() throws Exception{
        String url = Url + "logout";
        http.sendPost("{}", url);
    }

    public void sendData(String params) throws Exception{
        String url = Url + "/geodatas";
        http.sendPost(params, url);
    }



    public static Singleton getInstance()
    {
        if (instance == null)
        {
            instance = new Singleton();
        }
        return instance;
    }
}
