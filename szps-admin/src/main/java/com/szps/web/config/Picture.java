package com.szps.web.config;


import org.springframework.stereotype.Service;

@Service
public class Picture {

    private String url="";


    public String getUrl(String strings){

        strings=url+strings;
        return strings;
    }

}
