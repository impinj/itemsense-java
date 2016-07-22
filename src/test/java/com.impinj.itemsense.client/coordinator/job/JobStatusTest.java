package com.impinj.itemsense.client.coordinator.job;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by nkershaw on 7/15/16.
 */
public class JobStatusTest {

  @Test
  public void testJobStatus() {
    String str = "randomString";
    JobResponse jobResponse = new JobResponse();
    jobResponse.setStatus(str);

    Assert.assertTrue("Job Status does not equal unknown", jobResponse.getJobStatusAsEnum() == JobStatus.UNKNOWN);
  }
}
