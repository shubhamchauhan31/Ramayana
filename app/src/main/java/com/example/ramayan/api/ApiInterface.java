package com.example.ramayan.api;

import com.example.ramayan.model.MessageResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {
    public static  final String BASEURL="";

    // request the server
    @GET("{API_KEYS}/SMS/91{user_phone_number}/AUTOGEN")
    Call<MessageResponse>
    sendOTP(@Path("API_KEYS") String apiKey,
            @Path("user_phone_number") String userPhone);

    // response the server
    @GET("{API_KEYS}/SMS/VERIFY/{session_id}/{otp_entered_by_user}")
    Call<MessageResponse>
    verifyOTP(@Path("API_KEYS") String api_keys,
              @Path("session_id")String session_id,
              @Path("user_phone_number") String otp_entered_by_user );

}
