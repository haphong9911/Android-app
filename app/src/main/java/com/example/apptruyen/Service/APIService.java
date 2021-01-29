package com.example.apptruyen.Service;

public class APIService {
    private static String base_url = "https://haphong.000webhostapp.com/server/";

    public static Dataservice getService(){
        return com.example.apptruyen.Service.APIRetrofitClient.getClient(base_url).create(Dataservice.class);
    }
}
