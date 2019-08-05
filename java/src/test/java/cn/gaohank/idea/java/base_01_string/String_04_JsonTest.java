package cn.gaohank.idea.java.base_01_string;

import com.google.gson.Gson;
import lombok.Data;
import org.junit.Test;

import java.util.HashMap;

@Data
public class String_04_JsonTest {
    private HashMap<String, String> stuMap;
    private String name;

    @Test
    public void testNum() {
        System.out.println(Double.valueOf("１６７"));
    }

    @Test
    public void testMap() {
        String_04_JsonTest string_04_jsonTest = new String_04_JsonTest();
        string_04_jsonTest.setStuMap(new HashMap<String, String>() {{ put("name", "hank"); put("age", "29"); }});
        System.out.println(new Gson().toJson(string_04_jsonTest));
    }
}