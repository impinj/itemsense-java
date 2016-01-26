package com.impinj.itemsense.client.coordinator.job;

import com.google.gson.Gson;
import com.impinj.itemsense.client.helpers.RestApiHelper;


import javax.ws.rs.client.WebTarget;

/**
 * Created by jcombopi on 1/25/16.
 */
public class JobController {
    private Gson gson;
    private WebTarget target;
    private RestApiHelper<Job> restApiHelper;

    public JobController(final Gson gson, final WebTarget target){
        this.gson = gson;
        this.target = target;
        this.restApiHelper = new RestApiHelper<Job>(Job.class);
    }
    public Job[] getJobs(){
        return this.restApiHelper.getMultiple(null, "/control/jobs/show", target, gson);
    }
    public Job getJob(String jobId){
        return this.restApiHelper.get(jobId, "/control/jobs/show", target);
    }
    public Job startJob(Job job){
        return this.restApiHelper.post(job, "/control/jobs/start", target, gson);
    }
    public Job stopJob(String jobId){
        return this.restApiHelper.post(null, "/control/jobs/stop/" + jobId, target, gson);
    }

    //TODO: add Job Stats API calls

}
