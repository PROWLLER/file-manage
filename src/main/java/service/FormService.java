package service;

import java.util.Date;

public class FormService {

    public static Date translate(String str) throws FormNotRightException{
        String[] strs = str.split("-");
        if(strs.length != 6)throw new FormNotRightException("Format not right");
        Integer year = Integer.parseInt(strs[0]);
        Integer month = Integer.parseInt(strs[1]);
        Integer day = Integer.parseInt(strs[2]);
        Integer hour = Integer.parseInt(strs[3]);
        Integer min = Integer.parseInt(strs[4]);
        Integer sec = Integer.parseInt(strs[5]);
        assert min < 60 && min >= 0;
        assert sec < 60 && sec >= 0;
        assert hour < 24 && hour >= 0;
        assert day < 32 && day >= 0;
        assert month < 13 && month >= 0;

        Date date = null;

        try{
            date = new Date(year, month, day, hour, min, sec);
        }catch (Exception e){
            throw new FormNotRightException("Date Format not right");
        }

        return date;

    }
}
