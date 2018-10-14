//package duykhanh;
//
//import javafx.scene.control.Alert;
//import org.json.JSONArray;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.net.URLEncoder;
//
//public class Translate {
//    public static String getAPI(String sl, String tl, String text){
//        StringBuilder content = new StringBuilder();
//        try {
//            String urlText = "https://translate.googleapis.com/translate_a/single?client=gtx&sl="+sl+"&tl="+tl+"&dt=t&q=" + text;
//            URL url = new URL(urlText);
//
//            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//            urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36");
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
//
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                content.append(line + "\n");
//            }
//            bufferedReader.close();
//        } catch (Exception e) {
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("Error");
//            alert.setContentText("Can't connect to server. Please check you connection!");
//            alert.showAndWait();
//        }
////
////        Use one line
////        String result=content.toString().split("\\\"", -1)[1];
//
//        JSONArray json = new JSONArray(content.toString());
//        JSONArray jsonResult = (JSONArray) json.get(0);
//
//        System.out.println(jsonResult.toString());
//
//        System.out.println(jsonResult.length());
//        String result = "";
//        for (int i = 0; i < jsonResult.length(); i++) {
//            JSONArray arrayBlock = (JSONArray) jsonResult.get(i);
//            result += arrayBlock.get(0).toString();
//        }
//        return result;
//    }
//}