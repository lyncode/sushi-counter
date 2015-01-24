package com.lyncode.sushicounter.util;

import com.google.common.base.Function;
import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class XMLGregorianCalenderUtils {
    public static XMLGregorianCalendar now () {
        return fromDate().apply(new Date());
    }

    public static Function<Date, XMLGregorianCalendar> fromDate () {
        return new Function<Date, XMLGregorianCalendar>() {
            @Override
            public XMLGregorianCalendar apply(final Date date) {
                if (date == null) return null;
                return new XMLGregorianCalendarImpl(new GregorianCalendar(TimeZone.getDefault()) {{
                    setTime(date);
                }});
            }
        };
    }

    public static Function<XMLGregorianCalendar, Date> toDate () {
        return new Function<XMLGregorianCalendar, Date>() {
            @Override
            public Date apply(XMLGregorianCalendar xmlGregorianCalendar) {
                if (xmlGregorianCalendar == null) return null;
                return xmlGregorianCalendar.toGregorianCalendar().getTime();
            }
        };
    }
}
