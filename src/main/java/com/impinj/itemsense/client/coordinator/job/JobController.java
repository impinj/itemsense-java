package com.impinj.itemsense.client.coordinator.job;

import com.impinj.itemsense.client.helpers.RestApiHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class JobController {
    private WebTarget target;
    private RestApiHelper<Job> restApiHelperPoster;
    private RestApiHelper<JobResponse> restApiHelperGetter;

    public JobController(final WebTarget target) {
        this.target = target;
        this.restApiHelperPoster = new RestApiHelper<>(Job.class);
        this.restApiHelperGetter = new RestApiHelper<>(JobResponse.class);
    }

    public Response getJobsAsResponse() {
        return this.restApiHelperGetter.get( "/control/v1/jobs/show", target);
    }

    public Response getJobAsResponse(String jobId) {
        return this.restApiHelperGetter.get(jobId, "/control/v1/jobs/show", target);
    }

    public Response startJobAsResponse(Job job) {
        return this.restApiHelperPoster.post(job, "/control/v1/jobs/start", target);
    }

    public Response stopJobAsResponse(String jobId) {
        return this.restApiHelperPoster.post(jobId, "/control/v1/jobs/stop/", target);
    }

    public List<JobResponse> getJobs() {
        JobResponse[] jobResponses = getJobsAsResponse().readEntity(JobResponse[].class);
        return new ArrayList<>(Arrays.asList(jobResponses));
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
            return (status == JobStatus.RUNNING || status == JobStatus.STOPPING || status == JobStatus.STOPPED);
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
