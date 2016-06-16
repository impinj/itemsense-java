package com.impinj.itemsense.client.coordinator;

import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import com.google.gson.Gson;
import com.impinj.itemsense.client.coordinator.job.Job;
import com.impinj.itemsense.client.coordinator.job.JobController;
import com.impinj.itemsense.client.coordinator.job.JobResponse;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.junit.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.hamcrest.CoreMatchers.instanceOf;

/**
 * Created by jcombopi on 1/29/16.
 */
public class JobControllerTest {
    private CoordinatorApiController coordinatorApiController;
    private JobController jobController;
    private Gson gson;

    @ClassRule
    public static WireMockClassRule wireMockRule = new WireMockClassRule(8089);

    @Rule
    public WireMockClassRule instanceRule = wireMockRule;


    @Before
    public void setUp() throws Exception {

        Client client = ClientBuilder.newClient().register(HttpAuthenticationFeature.basic("testUser", "testPassword"));

        //http://localhost:8089 is where wiremock is running
        coordinatorApiController = new CoordinatorApiController(client, URI.create("http://localhost:8089"));
        jobController = coordinatorApiController.getJobController();
        gson = new Gson();

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void GetAllJobs(){
        String jobResponseStrings ="[{\"id\":\"05d2518b-b8e0-41b3-8112-481579d6b512\",\"status\":\"COMPLETE\",\"readerNames\":[\"Arlington_Office\"],\"creationTime\":\"2016-01-25T04:41:26.318Z[Etc/UTC]\",\"lastActivityTime\":\"2016-01-25T04:47:24.404Z\",\"activeDuration\":\"PT5M\",\"errorOccurred\":false,\"errors\":[],\"facilities\":[{\"name\":\"Arlington\"}],\"job\":{\"recipeName\":\"Arlington_Location\",\"durationSeconds\":300,\"playbackLoggingEnabled\":null,\"presenceLoggingEnabled\":null,\"startDelay\":\"PT0S\",\"reportToDatabaseEnabled\":null,\"reportToMessageQueueEnabled\":null,\"reportToFileEnabled\":null,\"facility\":\"Arlington\"},\"instanceMetadata\":null,\"lastHeartbeatTime\":\"2016-01-25T04:47:19.522Z[Etc/UTC]\"}]";
        stubFor(get(urlEqualTo("/control/v1/jobs/show")).willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody(jobResponseStrings)));

        List<JobResponse> jobs = jobController.getJobs();
        Assert.assertEquals(jobs.size(), 1);
        Assert.assertThat(jobs, instanceOf(ArrayList.class));
        Assert.assertThat(jobs.get(0), instanceOf(JobResponse.class));

    }

    @Test
    public void GetAllJobsWithErrors(){
        String jobResponseStrings = "[{\"id\": \"5301035e-a5ea-47ad-92ef-596d9a2e790e\", \"status\": \"RUNNING\", \"readerNames\": [ \"Arlington_Office\" ], \"connectionType\": \"LLRP\", \"creationTime\": \"2016-06-15T21:14:19.488Z[Etc/UTC]\", \"lastActivityTime\": \"2016-06-16T01:39:33.423Z\", \"stateEntryTime\": \"2016-06-15T21:14:33.912Z\", \"activeDuration\": \"PT4H24M59.511S\", \"errorOccurred\": false, \"errors\": [], \"facilities\": [ { \"name\": \"Arlington\" } ], \"job\": { \"recipeName\": \"Arlington_Location\", \"durationSeconds\": 36000000, \"playbackLoggingEnabled\": false, \"presenceLoggingEnabled\": false, \"startDelay\": \"PT0S\", \"reportToDatabaseEnabled\": true, \"reportToMessageQueueEnabled\": null, \"reportToFileEnabled\": null, \"facility\": \"Arlington\" }, \"instanceMetadata\": { \"port\": 53869, \"instanceId\": \"194e1bb7-a7fc-4e41-968b-ce7bf1d6a1ee\", \"controlUrl\": \"http://localhost:53869/itemsense/readermanager\", \"connectionType\": \"LLRP\" }, \"lastHeartbeatTime\": \"2016-06-16T01:39:39.335Z[Etc/UTC]\", \"startAttempts\": 1 }, { \"id\": \"7f231ecb-3cd5-422f-b09c-670fbf8e4a1b\", \"status\": \"FAILED\", \"readerNames\": [ \"Arlington_Office\" ], \"connectionType\": \"LLRP\", \"creationTime\": \"2016-05-31T21:26:45.523Z[GMT]\", \"lastActivityTime\": \"2016-06-15T05:52:19.512Z[GMT]\", \"stateEntryTime\": \"2016-06-15T05:52:19.512Z[GMT]\", \"activeDuration\": \"PT0S\", \"errorOccurred\": true, \"errors\": [ { \"time\": \"2016-06-15T05:49:15.514Z[GMT]\", \"message\": \"Could not detect job progress, possibly dead or in a bad state : Heartbeat Timed Out\" }, { \"time\": \"2016-06-15T05:50:23.641Z[GMT]\", \"message\": \"Error publishing state to JobInstance : Initialization error: An error occurred while connecting to the reader (192.168.15.16): \" }, { \"time\": \"2016-06-15T05:51:20.618Z[GMT]\", \"message\": \"Error publishing state to JobInstance : Initialization error: An error occurred while connecting to the reader (192.168.15.16): \" }, { \"time\": \"2016-06-15T05:52:20.626Z[GMT]\", \"message\": \"Error publishing state to JobInstance : Initialization error: An error occurred while connecting to the reader (192.168.15.16): \" }, { \"time\": \"2016-06-15T05:52:20.797Z[GMT]\", \"message\": \"Job was unable to start within the maximum number of start attempts (4) : Failed job\" } ], \"facilities\": [ { \"name\": \"Arlington\" } ], \"job\": { \"recipeName\": \"Arlington_Location\", \"durationSeconds\": 36000000, \"playbackLoggingEnabled\": false, \"presenceLoggingEnabled\": false, \"startDelay\": \"PT0S\", \"reportToDatabaseEnabled\": true, \"reportToMessageQueueEnabled\": null, \"reportToFileEnabled\": null, \"facility\": \"Arlington\" }, \"instanceMetadata\": null, \"lastHeartbeatTime\": \"2016-06-15T05:52:18.584Z[GMT]\", \"startAttempts\": 4}]";
        stubFor(get(urlEqualTo("/control/v1/jobs/show")).willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody(jobResponseStrings)));

        List<JobResponse> jobs = jobController.getJobs();
        Assert.assertEquals(jobs.size(), 2);
        Assert.assertThat(jobs, instanceOf(ArrayList.class));
        Assert.assertThat(jobs.get(1), instanceOf(JobResponse.class));

    }

    @Test
    public void GetJob(){

        String jobResponseString = "{\"id\":\"05d2518b-b8e0-41b3-8112-481579d6b512\",\"status\":\"COMPLETE\",\"readerNames\":[\"Arlington_Office\"],\"creationTime\":\"2016-01-25T04:41:26.318Z[Etc/UTC]\",\"lastActivityTime\":\"2016-01-25T04:47:24.404Z\",\"activeDuration\":\"PT5M\",\"errorOccurred\":false,\"errors\":[],\"facilities\":[{\"name\":\"Arlington\"}],\"job\":{\"recipeName\":\"Arlington_Location\",\"durationSeconds\":300,\"playbackLoggingEnabled\":null,\"presenceLoggingEnabled\":null,\"startDelay\":\"PT0S\",\"reportToDatabaseEnabled\":null,\"reportToMessageQueueEnabled\":null,\"reportToFileEnabled\":null,\"facility\":\"Arlington\"},\"instanceMetadata\":null,\"lastHeartbeatTime\":\"2016-01-25T04:47:19.522Z[Etc/UTC]\"}";
        stubFor(get(urlEqualTo("/control/v1/jobs/show/05d2518b-b8e0-41b3-8112-481579d6b512")).willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody(jobResponseString)));

        String jobId = "05d2518b-b8e0-41b3-8112-481579d6b512";
        JobResponse jobResult =  jobController.getJob(jobId);

        Assert.assertThat(jobResult, instanceOf(JobResponse.class));
        Assert.assertThat(jobResult.getReaderNames(), instanceOf(String[].class));
        Assert.assertThat(jobResult.getJob(), instanceOf(Job.class));
    }
}
