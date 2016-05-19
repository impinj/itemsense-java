package com.impinj.itemsense.client.coordinator.job;

import com.impinj.itemsense.client.helpers.RestApiHelper;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by jcombopi on 1/25/16.
 */
public class JobController {
    private WebTarget target;
    private RestApiHelper<Job> restApiHelperPoster;
    private RestApiHelper<JobResponse> restApiHelperGetter;

    public JobController(final WebTarget target) {
        this.target = target;
        this.restApiHelperPoster = new RestApiHelper<Job>(Job.class);
        this.restApiHelperGetter = new RestApiHelper<JobResponse>(JobResponse.class);
    }

    public Response getJobsAsResponse() {
        return this.restApiHelperGetter.get( "/control/v1/jobs/show", target);
    }

    public ArrayList<JobResponse> getJobs() {
        JobResponse[] jobResponses = getJobsAsResponse().readEntity(JobResponse[].class);
        return new ArrayList<JobResponse>(Arrays.asList(jobResponses));
    }

    public Response getJobAsResponse(String jobId) {
        return this.restApiHelperGetter.get(jobId, "/control/v1/jobs/show", target);
    }
    public JobResponse getJob(String jobId) {
        return this.restApiHelperGetter.get(jobId, "/control/v1/jobs/show", target).readEntity(JobResponse.class);
    }

    public Response startJobAsResponse(Job job) {
        return this.restApiHelperPoster.post(job, "/control/v1/jobs/start", target);
    }

    public JobResponse startJob(Job job) {
        return this.restApiHelperPoster.post(job, "/control/v1/jobs/start", target).readEntity(JobResponse.class);
    }

    public Response stopJobAsResponse(String jobId) {
        return this.restApiHelperPoster.post(null, "/control/v1/jobs/stop/" + jobId, target);
    }

    public JobResponse stopJob(String jobId) {
        return this.restApiHelperPoster.post(null, "/control/v1/jobs/stop/" + jobId, target).readEntity(JobResponse.class);
    }

    //TODO: add Job Stats API calls

}
