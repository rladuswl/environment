package com.capstone.environment.controller;

import com.capstone.environment.domain.Trash;
import com.capstone.environment.repository.TrashRepository;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
public class OpenApiController {

    private final TrashRepository trashRepository;

    @GetMapping("open-api")
    public ArrayList<String> openApi() throws UnsupportedEncodingException {
        // 인증키 (개인이 받아와야함)
        String key = "f2BdkrESU1hXUBBIgR2HLWMRWbhF%2BAM8Pw8Y3WcX9weHTu3HskJwtu2sja1iZVojGkPPxCZOtlCxmSJHZ%2Bav0A%3D%3D";

        String result = "";

        try {

            URL url = new URL("https://api.odcloud.kr/api/15088187/v1/uddi:76ce8aea-9662-4bfb-9e1f-ca890396b99c?serviceKey="
                    + key);

            BufferedReader bf;

            bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));

            result = bf.readLine();

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject)jsonParser.parse(result);
            JSONArray data = (JSONArray)jsonObject.get("data");

            System.out.println(data);

            ArrayList<String> itemList = new ArrayList<>();
            ArrayList<String> nameList = new ArrayList<>();

            for(int i = 0; i < data.size(); i++) {
                JSONObject seq = (JSONObject)data.get(i);
                itemList.add((String) seq.get("품목"));
                nameList.add((String) seq.get("세부품목"));
            }

            System.out.println("품목 리스트 : " + itemList);
            System.out.println("세부품목 리스트 : " + nameList);

            for (int i = 0; i < itemList.size(); i++) {
                Trash trash = Trash.builder()
                        .name(nameList.get(i))
                        .item(itemList.get(i)).build();

                trashRepository.save(trash);
            };

//            HashSet<String> itemSet = new HashSet<>(itemList);
//            HashSet<String> nameSet = new HashSet<>(nameList);
//            itemSet.toArray(new String[0]);
//            nameSet.toArray(new String[0]);
//
//            System.out.println("중복 제거된 품목 리스트 : " + itemSet);
//            System.out.println("중복 제거된 세부품목 리스트 : " + nameSet);

            return itemList;

        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}