package API;

import com.google.gson.JsonObject;

public class GetRequestRepository {
    private API api;

    public GetRequestRepository(API api) {
        this.api = api;
    }

    public JsonObject innerRequest(String uri) {
        JsonObject jsonObject = new JsonObject();
        try {
            jsonObject = api.innerRequest(uri);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
