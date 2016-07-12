package com.impinj.itemsense.client.coordinator.job;

import com.impinj.itemsense.client.helpers.RestApiHelper;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jcombopi on 1/25/16.
 */
public class JobController {
    private WebTarget target;
    private RestApiHelper<Job> restApiHelperPoster;
    private RestApiHelper<JobResponse> restApiHelperGetter;
    private RestApiHelper<JobStats> restApiHelperStatsGetter;

    public JobController(final WebTarget target) {
        this.target = target;
        this.restApiHelperPoster = new RestApiHelper<>(Job.class);
        this.restApiHelperGetter = new RestApiHelper<>(JobResponse.class);
        this.restApiHelperStatsGetter = new RestApiHelper<>(JobStats.class);
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
        return this.restApiHelperPoster.post(null, "/control/v1/jobs/stop/" + jobId, target);
    }

    public Response getJobStatsAsResponse(String jobId) {
        return this.restApiHelperStatsGetter.get(jobId, "control/v1/jobs/stats/", target);
    }

    public List<JobResponse> getJobs() {
        JobResponse[] jobResponses = getJobsAsResponse().readEntity(JobResponse[].class);
        return new ArrayList<JobResponse>(Arrays.asList(jobResponses));
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

    public JobStats getJobStats(String jobId) {
        return getJobStatsAsResponse(jobId).readEntity(JobStats.class);
    }
}
