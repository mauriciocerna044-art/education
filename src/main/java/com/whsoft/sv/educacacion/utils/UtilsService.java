package com.whsoft.sv.educacacion.utils;

import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static com.whsoft.sv.educacacion.utils.Constants.TIME_ZONE;

@Service
public class UtilsService {


public String dateToString(Date date, String format){
    SimpleDateFormat frm=new SimpleDateFormat(format);
    frm.setTimeZone(TimeZone.getTimeZone(TIME_ZONE));
    return frm.format(date);

}

public Date StringToDate(String date,String format) throws ParseException {
    SimpleDateFormat frm=new SimpleDateFormat(format);
    return frm.parse(date);
}

}
