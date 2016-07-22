package com.impinj.itemsense.client.coordinator.helpers;

import com.impinj.itemsense.client.helpers.ZonedDateTimeSerialization;
import org.junit.Assert;
import org.junit.Test;

import java.time.Month;
import java.time.ZonedDateTime;

/**
 * Created by nkershaw on 7/15/16.
 */
public class ZonedDateTimeSerializationTest {

  @Test
  public void testDeserializationFromString() throws Exception {

    ZonedDateTimeSerialization serializer = new ZonedDateTimeSerialization();

    String dateTimeString = "2016-07-12T22:57:47Z";
    ZonedDateTime dateTime = serializer.deserialize(dateTimeString, null);
    Assert.assertEquals(2016, dateTime.getYear());
    Assert.assertEquals(Month.JULY, dateTime.getMonth());
    Assert.assertEquals(12, dateTime.getDayOfMonth());
    Assert.assertEquals(22, dateTime.getHour());
    Assert.assertEquals(57, dateTime.getMinute());
    Assert.assertEquals(47, dateTime.getSecond());
    Assert.assertEquals("Z", dateTime.getOffset().toString());
  }
}
