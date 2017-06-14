package test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Properties;


public class Main {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.loadFromXML(new FileInputStream(new File("configPath.xml").getAbsolutePath()));
        String URL = properties.getProperty("URL");
        String directory1 = properties.getProperty("Directory1");
        String directory2 = properties.getProperty("Directory2");
        Type itemsListType = new TypeToken<List<Model>>() {
        }.getType();

        List<Model> listModel = new Gson().fromJson(new ReadUrl().readUrl(URL), itemsListType);
        listModel.forEach(model -> {
            new ReadUrl().saveFileFromURL(model.getUrl(), directory1, "" + model.getId());
            new ReadUrl().saveFileFromURL(model.getThumbnailUrl(), directory2, "" + model.getId() + "_2");
        });
    }
}