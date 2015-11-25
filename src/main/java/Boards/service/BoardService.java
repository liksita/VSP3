package Boards.service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import util.SettingsReader;

import java.io.IOException;

import static com.mashape.unirest.http.Unirest.*;

/**
 * Created by m on 25.11.15.
 */
public class BoardService {
    public HttpResponse<JsonNode> getGames() {

        try {
            return get(SettingsReader.getSetting("games")).asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
