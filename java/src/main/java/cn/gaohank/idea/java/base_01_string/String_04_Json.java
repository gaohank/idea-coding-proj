package cn.gaohank.idea.java.base_01_string;


import org.json.JSONArray;
import org.json.JSONObject;

public class String_04_Json {
    public static void main(String[] args) throws Exception {
        String content = "";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("category", "电影");
        jsonObject.put("rating", 8.9);
        jsonObject.put("last_episode", 1);

        JSONObject episodes = new JSONObject();
        for (int i = 0; i < 5; i++) {
            episodes.put(String.valueOf(i + 1), "resource");
        }
        jsonObject.put("episodes_id", episodes);

        JSONArray objects = new JSONArray();
        objects.put(jsonObject);
        System.out.println(objects.toString());

        System.out.println(new JSONArray().toString());
        System.out.println(new JSONArray().length());
    }
}
