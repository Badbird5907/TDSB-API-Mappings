package dev.badbird.tdsbconnectsapi.schema.request.impl.account;

import dev.badbird.tdsbconnectsapi.TDSBConnects;
import dev.badbird.tdsbconnectsapi.schema.request.APIRequest;
import dev.badbird.tdsbconnectsapi.schema.response.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

@RequiredArgsConstructor
public class GetUserInfo implements APIRequest<UserResponse> {
    private final TDSBConnects tdsbConnects;

    @Override
    public String getEndpoint() {
        return "/api/Account/GetUserInfo";
    }

    @SneakyThrows
    @Override
    public UserResponse onResponse(Response response) {
        ResponseBody body = response.body();
        String bodyString = body == null ? "" : body.string();
        return tdsbConnects.GSON.fromJson(bodyString, UserResponse.class);
    }

    @Override
    public Request.Builder addData(Request.Builder builder) {
        return builder;
    }
}