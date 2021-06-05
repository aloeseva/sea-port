package app.mapper;

import app.domain.entities.dto.MyDate;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface MyDateMapper {

    static String map(MyDate myDate) {
        if (myDate != null) {
            return myDate.getDay() + ":" + myDate.getHour();
        }
        return null;
    }

    static MyDate toMyDate(String date) {
        if (date != null) {
            String[] array = date.split(":");
            int day = Integer.parseInt(array[0]);
            int hour = Integer.parseInt(array[1]);
            return new MyDate(day, hour);
        }
        return null;

    }
}
