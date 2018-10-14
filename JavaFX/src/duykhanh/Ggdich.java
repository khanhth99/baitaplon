package duykhanh;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Ggdich {
    public static String getAPI(String sl, String tl, String text) throws JSONException {
        StringBuilder content = new StringBuilder();
        try {
            String urlText = "https://translate.googleapis.com/translate_a/single?client=gtx&sl="+sl+"&tl="+tl+"&dt=t&q=" + text;
            URL url = new URL(urlText);

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
//            Alert.ErrorNetwork();
            return "";
        }

//        Use one line
//        String result=content.toString().split("\\\"", -1)[1];

        JSONArray json = new JSONArray(content.toString());
        JSONArray jsonResult = (JSONArray) json.get(0);

        System.out.println(jsonResult.toString());

        System.out.println(jsonResult.length());
        String result = "";
        for (int i = 0; i < jsonResult.length(); i++) {
            JSONArray arrayBlock = (JSONArray) jsonResult.get(i);
            result += arrayBlock.get(0).toString();
        }
        return result;
    }
    public static void speakAPI(String lang, String text){
        try {
            URL url = new URL("https://translate.google.com/translate_tts?ie=UTF-8&tl="+lang+"&client=tw-ob&q=" + text);
            HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
            urlConn.addRequestProperty("User-Agent", "Mozilla/5.0");
            InputStream audioSrc = urlConn.getInputStream();

            new Player(audioSrc).play();


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            System.out.println(1);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println(2);
        } catch (IOException e) {
//loi            Alert.ErrorNetwork();
        } catch (JavaLayerException e) {
            e.printStackTrace();
            System.out.println(4);
        }
    }
}