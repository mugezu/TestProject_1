package test;

import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;

/**
 * Created by Роман on 07.06.2017.
 */
public class ReadUrl {
    private static final String DEFAULT_PATH = "C:\\newDirectory\\";
    protected final Logger log = Logger.getLogger(this.getClass());

    public String readUrl(String nameUrl) {
        log.info("Read Json from URL - started");
        StringBuffer data = new StringBuffer();
        URL url;
        try {
            url = new URL(nameUrl);
            try (LineNumberReader reader = new LineNumberReader(new InputStreamReader(url.openStream()));) {
                String string = reader.readLine();
                while (string != null) {
                    data.append(string);
                    string = reader.readLine();
                }
                log.info("Read Json from URL - finish");
            }
        } catch (IOException e) {
            log.error(e.getMessage());
            log.error(util.stackTrace(e));
        } finally {
            return data.toString();
        }
    }

    public void saveFileFromURL(String nameUrl, String filePath, String nameFile) {
        log.info("Save file. URL:" + nameUrl + " ->Start");
        URL url;
        try {
            url = new URL(nameUrl);
            BufferedImage image = ImageIO.read(url.openStream());
            File folder = new File(filePath);
            nameFile += url.getFile().substring(1, url.getFile().length());
            folder.mkdirs();
            if (new File(filePath).exists()) {
                log.warn("Invalid directory");
                filePath = DEFAULT_PATH;
                new File(filePath).mkdirs();
                log.warn("Current directory: " + filePath);
            }
            try (FileOutputStream fileOutputStream = (new FileOutputStream(filePath + nameFile))) {
                ImageIO.write(image, FilenameUtils.getExtension(nameFile), fileOutputStream);
                log.info("Save file. URL:" + nameUrl + " ->Finish");
            } catch (FileNotFoundException e) {
                log.error(e.getMessage());
                log.error(util.stackTrace(e));
            }

        } catch (IOException e) {
            log.error(e.getMessage());
            log.error(util.stackTrace(e));
        }
    }
}
