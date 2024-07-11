package util;

import java.util.Map;

public class AppUtility {

    public static String getKeyFromValue(Map<String, Integer> map, Integer value) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(value))
                return entry.getKey();
        }
        return null;
    }

    public static Integer getIndex(String[] arr, String key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(key))
                return i;
        }
        return 0;
    }

}
