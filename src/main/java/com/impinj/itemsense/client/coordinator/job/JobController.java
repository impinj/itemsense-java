package com.impinj.itemsense.client.coordinator.job;

import com.google.gson.Gson;
import com.impinj.itemsense.client.helpers.RestApiHelper;


import javax.ws.rs.client.WebTarget;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by jcombopi on 1/25/16.
 */
public class JobController {
    private Gson gson;
    private WebTarget target;
    private RestApiHelper<Job> restApiHelperPoster;
    private RestApiHelper<JobResponse> restApiHelperGetter;

    public JobController(final Gson gson, final WebTarget target) {
        this.gson = gson;
        this.target = target;
        this.restApiHelperPoster = new RestApiHelper<Job>(Job.class);
        this.restApiHelperGetter = new RestApiHelper<JobResponse>(JobResponse.class);
    }

    public ArrayList<JobResponse> getJobs() {
        return this.restApiHelperGetter.getMultiple(null, "/control/v1/jobs/show", target, gson);
    }

    public JobResponse getJob(String jobId) {
        return this.restApiHelperGetter.get(jobId, "/control/v1/jobs/show", target);
    }

    public Job startJob(Job job) {

        return this.restApiHelperPoster.post(job, "/control/v1/jobs/start", target, gson);
    }

    public Job stopJob(String jobId) {
        return this.restApiHelperPoster.post(null, "/control/v1/jobs/stop/" + jobId, target, gson);
    }

    //TODO: add Job Stats API calls

}
