package test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class Main {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.loadFromXML(new FileInputStream(new File("Path.xml").getAbsolutePath()));
        String URL = properties.getProperty("URL");
        String directory1 = properties.getProperty("Directory1");
        String directory2 = properties.getProperty("Directory2");
        Type itemsListType = new TypeToken<List<Model>>() {
        }.getType();
        ExecutorService threadPool = new ThreadPoolExecutor(4, 64, 60l,
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(256));

        List<Model> listModel = new Gson().fromJson(new ReadUrl().readUrl(URL), itemsListType);
        listModel.forEach(model -> {
            new ReadUrl().saveFileFromURL(model.getUrl(), directory1, "" + model.getId());
            new ReadUrl().saveFileFromURL(model.getThumbnailUrl(), directory2, "" + model.getId() + "_2");
        });
       /* for (final test.Model model : listModel) {

            threadPool.submit(new Runnable() {
                public void run() {
                    //FilenameUtils
                 new test.ReadUrl().saveFileFromURL(model.getUrl(), "C:\\newDirectory/", "" + model.getId());
            new test.ReadUrl().saveFileFromURL(model.getThumbnailUrl(), "C:\\newDirectory/newCatalog/", "" + model.getId() + "_2");
                }
            });
            new test.ReadUrl().saveFileFromURL(model.getUrl(), "C:\\newDirectory/", "" + model.getId());
            new test.ReadUrl().saveFileFromURL(model.getThumbnailUrl(), "C:\\newDirectory/newCatalog/", "" + model.getId() + "_2");
        }*/
        // new test.ReadUrl().saveFileFromURL("https://upload.wikimedia.org/wikipedia/commons/thumb/7/77/Google_Images_2015_logo.svg/1200px-Google_Images_2015_logo.svg.png", "C:\\newDirectory/", "ssss.png");
    }
}