package io.hanshin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println(howManyPeople("14:00:00"));

    }

    public static int howManyPeople(String time) throws IOException {
        List<Human> humanList = new ArrayList<>();
        //파일 객체 생성
        File file = new File("time_data.txt");
        //입력 스트림 생성
        FileReader filereader = new FileReader(file);
        BufferedReader bufReader = new BufferedReader(filereader);
        String line = "";
        int number = 0;
        while((line = bufReader.readLine()) != null){
            String[] splitValue = line.split(" ");
            humanList.add(new Human(number,splitValue[0],splitValue[1]));
        }

        LocalTime presentTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("H:m:s"));
        long count = humanList.stream().filter(human -> presentTime.isAfter(human.getStartTime()) & presentTime.isBefore(human.getEndTime())).count();

        return (int)count;
    }
}
