package util;

import com.google.gson.Gson;
import spark.ResponseTransformer;

/**
 * Created by diana on 20.11.15.
 */
public class JsonUtil {

    public static String toJson(Object object) {
        return new Gson().toJson(object);
    }

    public static ResponseTransformer json() {
        return JsonUtil::toJson;
    }


}

