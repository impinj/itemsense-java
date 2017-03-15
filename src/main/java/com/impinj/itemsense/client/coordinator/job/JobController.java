package com.impinj.itemsense.client.coordinator.job;

import com.google.common.collect.ImmutableSet;
import com.impinj.itemsense.client.helpers.RestApiHelper;
import java.util.List;
import java.util.Set;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

public class JobController {

  private static final String BASE_PATH = "/control/v1/jobs";

  private static final Set<JobStatus> STARTED_STATUSES =
      ImmutableSet.of(JobStatus.RUNNING, JobStatus.STOPPING, JobStatus.STOPPED);

  private WebTarget target;

  public JobController(final WebTarget target) {
    this.target = target;
  }

  public Response getJobsAsResponse() {
    return RestApiHelper.get(target, BASE_PATH, "show");
  }

  public Response getJobAsResponse(String jobId) {
    return RestApiHelper.get(target, BASE_PATH, "show", jobId);
  }

  public Response startJobAsResponse(Job job) {
    return RestApiHelper.post(job, target, BASE_PATH, "start");
  }

  public Response stopJobAsResponse(String jobId) {
    return RestApiHelper.post(target, BASE_PATH, "stop", jobId);
  }

  public List<JobResponse> getJobs() {
    return getJobsAsResponse().readEntity(new GenericType<List<JobResponse>>() {});
  }

  public JobResponse getJob(String jobId) {
    return getJobAsResponse(jobId).readEntity(JobResponse.class);
  }

  public JobResponse startJob(Job job) {
    return startJobAsResponse(job).readEntity(JobResponse.class);
  }

  public JobResponse stopJob(String jobId) {
    return stopJobAsResponse(jobId).readEntity(JobResponse.class);
  }

  public boolean hasJobStarted(String jobId) {
    Response response = getJobAsResponse(jobId);
    if (response.getStatus() == 200) {
      JobResponse jobResponse = response.readEntity(JobResponse.class);
      JobStatus status = jobResponse.getJobStatusAsEnum();
      return STARTED_STATUSES.contains(status);
    } else {
      response.close();
      return false;
    }
  }

  public boolean hasJobStopped(String jobId) {
    Response response = getJobAsResponse(jobId);
    if (response.getStatus() == 200) {
      JobResponse jobResponse = response.readEntity(JobResponse.class);
      JobStatus status = jobResponse.getJobStatusAsEnum();
      return (status == JobStatus.STOPPED);
    } else {
      response.close();
      return false;
    }
  }
}
