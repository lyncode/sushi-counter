package com.lyncode.sushicounter.util;

import org.junit.Test;

import javax.xml.datatype.XMLGregorianCalendar;

import java.util.Date;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class XMLGregorianCalenderUtilsTest {
    @Test
    public void fromDateShouldBeNullSafe() throws Exception {
        XMLGregorianCalendar result = XMLGregorianCalenderUtils.fromDate().apply(null);

        assertThat(result, is(nullValue()));
    }

    @Test
    public void toDateShouldBeNullSafe() throws Exception {
        Date result = XMLGregorianCalenderUtils.toDate().apply(null);
        assertThat(result, is(nullValue()));
    }
}