package adapters.base;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainAdapter {

    protected Gson gson;
    public MainAdapter() {
        gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
    }
}
