package com.company;

import com.pengrad.telegrambot.UpdatesListener;
import org.json.JSONObject;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Lab4 {
    public static void main(String[] args) {

        String API_CALL_TEMPLATE = "http://api.openweathermap.org/data/2.5/weather?lang=ru&q=";
        String API_KEY_TEMPLATE ="&appid=880722fede357fd70293e3829931d52f\n";


        TelegramBot bot = new TelegramBot("1298717979:AAGycMknVEuffAoiZPj6y588GHFh56T-Qw8");
        bot.setUpdatesListener(updates -> {


            long chatId = updates.get(0).message().chat().id();
            String message = updates.get(0).message().text();

            //commands
            switch (message){
                case "/start" :
                    SendResponse response0 = bot.execute(new SendMessage(chatId,"Введите город"));
                    break;

                default: {
                    String URLstring = API_CALL_TEMPLATE + message + API_KEY_TEMPLATE;
                    try {

                        URL urlobj = new URL(URLstring);
                        HttpURLConnection connection = (HttpURLConnection) urlobj.openConnection();
                        connection.setRequestMethod("GET");
                        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
                        int responseCode = connection.getResponseCode();
                        if (responseCode == 404) {
                            throw new IllegalArgumentException();
                        }

                        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                        String inputLine;
                        StringBuffer response = new StringBuffer();
                        while ((inputLine = in.readLine()) != null) {
                            response.append(inputLine);
                        }
                        in.close();
                        JSONObject jsonObject = new JSONObject(response.toString());
                        String city = jsonObject.getString("name");

                        double temperature = jsonObject.getJSONObject("main").getDouble("temp")-273.15;
                        double humidity = jsonObject.getJSONObject("main").getDouble("humidity");
                        double windspeed = jsonObject.getJSONObject("wind").getDouble("speed");
                        String overcast = jsonObject.getJSONArray("weather").getJSONObject(0).getString("description");


                        SendResponse response1 = bot.execute(new SendMessage(chatId,
                                "Погода в городе " + city +"\n" +
                                        "Температура: "+ Math.round(temperature) + "°C\n" +
                                        "Состояние: " + overcast + "\n" +
                                        "Скорость ветра: " + windspeed + " м/с" + "\n" +
                                        "Влажность: " + humidity + "%"));

                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (IllegalArgumentException e){
                        SendResponse response2 = bot.execute(new SendMessage(chatId,"Этот город не найден."));
                        e.printStackTrace();
                    }
                    break;
                }

            }

            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });

    }
}