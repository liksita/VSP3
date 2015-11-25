package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by m on 25.11.15.
 */
public class SettingsReader  {

    static HashMap<String, String> settings = new HashMap<>();

    private static void readSettings()  throws IOException {

        FileReader fr = new FileReader("settings.txt");
        BufferedReader br = new BufferedReader(fr);
        String zeile = "";

        while ((zeile = br.readLine()) != null) {
            if(zeile.contains("banks")){
                settings.put("banks",zeile);
            }else if(zeile.contains("boards")){
                settings.put("boards",zeile);
            }else if(zeile.contains("brokers")){
                settings.put("brokers",zeile);
            }else if(zeile.contains("dice")){
                settings.put("dice",zeile);
            }else if(zeile.contains("games")){
                settings.put("games",zeile);
            }else if(zeile.contains("jail")){
                settings.put("jail",zeile);
            }else if(zeile.contains("player")){
                settings.put("player",zeile);
            }
        }
        br.close();
    }

    public static String getSetting(String setting) throws IOException {
        readSettings();
        return settings.get(setting);
    }


}
