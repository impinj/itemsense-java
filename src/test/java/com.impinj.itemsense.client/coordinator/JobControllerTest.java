package com.impinj.itemsense.client.coordinator;

import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import com.impinj.itemsense.client.TestUtils;
import com.impinj.itemsense.client.coordinator.job.Job;
import com.impinj.itemsense.client.coordinator.job.JobController;
import com.impinj.itemsense.client.coordinator.job.JobResponse;
import com.impinj.itemsense.client.coordinator.job.JobResponseError;
import com.impinj.itemsense.client.coordinator.job.JobStatus;
import com.impinj.itemsense.client.coordinator.job.JobStopReason;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.hamcrest.CoreMatchers.instanceOf;


public class JobControllerTest {
    private CoordinatorApiController coordinatorApiController;
    private JobController jobController;
    private static final int MAX_ERRORS = 4;

    @ClassRule
    public static WireMockClassRule wireMockRule = new WireMockClassRule(TestUtils.MOCK_PORT);

    @Rule
    public WireMockClassRule instanceRule = wireMockRule;


    @Before
    public void setUp() throws Exception {

        Client client = TestUtils.getClient();

        coordinatorApiController = new CoordinatorApiController(client, TestUtils.MOCK_URI);
        jobController = coordinatorApiController.getJobController();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetAllJobs() {
        String jobResponseStrings ="[{\"id\":\"05d2518b-b8e0-41b3-8112-481579d6b512\",\"status\":\"STOPPED\",\"readerNames\":[\"Arlington_Office\"],\"creationTime\":\"2016-01-25T04:41:26.318Z[Etc/UTC]\",\"lastActivityTime\":\"2016-01-25T04:47:24.404Z\",\"activeDuration\":\"PT5M\",\"errorOccurred\":false,\"errors\":[],\"facilities\":[{\"name\":\"Arlington\"}],\"job\":{\"recipeName\":\"Arlington_Location\",\"durationSeconds\":300,\"playbackLoggingEnabled\":null,\"presenceLoggingEnabled\":null,\"startDelay\":\"PT0S\",\"reportToDatabaseEnabled\":null,\"reportToMessageQueueEnabled\":null,\"reportToFileEnabled\":null,\"facility\":\"Arlington\"},\"instanceMetadata\":null,\"lastHeartbeatTime\":\"2016-01-25T04:47:19.522Z[Etc/UTC]\"}]";
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
    public void testGetAllJobsWithErrors() {
        String jobResponseStrings = "[{\"id\": \"5301035e-a5ea-47ad-92ef-596d9a2e790e\", \"status\": \"RUNNING\", \"readerNames\": [ \"Arlington_Office\" ], \"connectionType\": \"LLRP\", \"creationTime\": \"2016-06-15T21:14:19.488Z[Etc/UTC]\", \"lastActivityTime\": \"2016-06-16T01:39:33.423Z\", \"stateEntryTime\": \"2016-06-15T21:14:33.912Z\", \"activeDuration\": \"PT4H24M59.511S\", \"errorOccurred\": false, \"errors\": [], \"facilities\": [ { \"name\": \"Arlington\" } ], \"job\": { \"recipeName\": \"Arlington_Location\", \"durationSeconds\": 36000000, \"playbackLoggingEnabled\": false, \"presenceLoggingEnabled\": false, \"startDelay\": \"PT0S\", \"reportToDatabaseEnabled\": true, \"reportToMessageQueueEnabled\": null, \"reportToFileEnabled\": null, \"facility\": \"Arlington\" }, \"instanceMetadata\": { \"port\": 53869, \"instanceId\": \"194e1bb7-a7fc-4e41-968b-ce7bf1d6a1ee\", \"controlUrl\": \"http://localhost:53869/itemsense/readermanager\", \"connectionType\": \"LLRP\" }, \"lastHeartbeatTime\": \"2016-06-16T01:39:39.335Z[Etc/UTC]\", \"startAttempts\": 1 }, { \"id\": \"7f231ecb-3cd5-422f-b09c-670fbf8e4a1b\", \"status\": \"INITIALIZING\", \"readerNames\": [ \"Arlington_Office\" ], \"connectionType\": \"LLRP\", \"creationTime\": \"2016-05-31T21:26:45.523Z[GMT]\", \"lastActivityTime\": \"2016-06-15T05:52:19.512Z[GMT]\", \"stateEntryTime\": \"2016-06-15T05:52:19.512Z[GMT]\", \"activeDuration\": \"PT0S\", \"errorOccurred\": true, \"errors\": [ { \"time\": \"2016-06-15T05:49:15.514Z[GMT]\", \"message\": \"Could not detect job progress, possibly dead or in a bad state : Heartbeat Timed Out\" }, { \"time\": \"2016-06-15T05:50:23.641Z[GMT]\", \"message\": \"Error publishing state to JobInstance : Initialization error: An error occurred while connecting to the reader (192.168.15.16): \" }, { \"time\": \"2016-06-15T05:51:20.618Z[GMT]\", \"message\": \"Error publishing state to JobInstance : Initialization error: An error occurred while connecting to the reader (192.168.15.16): \" }, { \"time\": \"2016-06-15T05:52:20.626Z[GMT]\", \"message\": \"Error publishing state to JobInstance : Initialization error: An error occurred while connecting to the reader (192.168.15.16): \" }, { \"time\": \"2016-06-15T05:52:20.797Z[GMT]\", \"message\": \"Job was unable to start within the maximum number of start attempts (4) : Failed job\" } ], \"facilities\": [ { \"name\": \"Arlington\" } ], \"job\": { \"recipeName\": \"Arlington_Location\", \"durationSeconds\": 36000000, \"playbackLoggingEnabled\": false, \"presenceLoggingEnabled\": false, \"startDelay\": \"PT0S\", \"reportToDatabaseEnabled\": true, \"reportToMessageQueueEnabled\": null, \"reportToFileEnabled\": null, \"facility\": \"Arlington\" }, \"instanceMetadata\": null, \"lastHeartbeatTime\": \"2016-06-15T05:52:18.584Z[GMT]\", \"startAttempts\": 4}]";
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
    public void testGetJob() {
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

    @Test
    public void testStartJob() {
        String[] jobResponseStrings = {"{\"status\":\"WAITING\",\"errorOccurred\":false,\"errors\":[{\"time\":\"2016-07-12T22:57:47Z\",\"message\":\"Error message 0\"},{\"time\":\"2016-07-12T22:57:47Z\",\"message\":\"Error message 1\"},{\"time\":\"2016-07-12T22:57:47Z\",\"message\":\"Error message 2\"},{\"time\":\"2016-07-12T22:57:47Z\",\"message\":\"Error message 3\"}],\"maxErrors\":4,\"startAttempts\":0,\"stopReason\":\"JOB_COMPLETED\"}",
         "{\"status\":\"INITIALIZING\",\"errorOccurred\":false,\"errors\":[{\"time\":\"2016-07-12T22:57:47Z\",\"message\":\"Error message 0\"},{\"time\":\"2016-07-12T22:57:47Z\",\"message\":\"Error message 1\"},{\"time\":\"2016-07-12T22:57:47Z\",\"message\":\"Error message 2\"},{\"time\":\"2016-07-12T22:57:47Z\",\"message\":\"Error message 3\"}],\"maxErrors\":4,\"startAttempts\":0,\"stopReason\":\"JOB_FAILED\"}",
         "{\"status\":\"STARTING\",\"errorOccurred\":false,\"errors\":[{\"time\":\"2016-07-12T22:57:47Z\",\"message\":\"Error message 0\"},{\"time\":\"2016-07-12T22:57:47Z\",\"message\":\"Error message 1\"},{\"time\":\"2016-07-12T22:57:47Z\",\"message\":\"Error message 2\"},{\"time\":\"2016-07-12T22:57:47Z\",\"message\":\"Error message 3\"}],\"maxErrors\":4,\"startAttempts\":0,\"stopReason\":\"USER_REQUESTED_GRACEFUL\"}",
         "{\"status\":\"RUNNING\",\"errorOccurred\":false,\"errors\":[{\"time\":\"2016-07-12T22:57:47Z\",\"message\":\"Error message 0\"},{\"time\":\"2016-07-12T22:57:47Z\",\"message\":\"Error message 1\"},{\"time\":\"2016-07-12T22:57:47Z\",\"message\":\"Error message 2\"},{\"time\":\"2016-07-12T22:57:47Z\",\"message\":\"Error message 3\"}],\"maxErrors\":4,\"startAttempts\":0,\"stopReason\":\"USER_REQUESTED_ABRUPT\"}",
         "{\"status\":\"STOPPING\",\"errorOccurred\":false,\"errors\":[{\"time\":\"2016-07-12T22:57:47Z\",\"message\":\"Error message 0\"},{\"time\":\"2016-07-12T22:57:47Z\",\"message\":\"Error message 1\"},{\"time\":\"2016-07-12T22:57:47Z\",\"message\":\"Error message 2\"},{\"time\":\"2016-07-12T22:57:47Z\",\"message\":\"Error message 3\"}],\"maxErrors\":4,\"startAttempts\":0, \"stopReason\":\"UNKNOWN\"} }",
         "{\"status\":\"STOPPED\",\"errorOccurred\":false,\"errors\":[{\"time\":\"2016-07-12T22:57:47Z\",\"message\":\"Error message 0\"},{\"time\":\"2016-07-12T22:57:47Z\",\"message\":\"Error message 1\"},{\"time\":\"2016-07-12T22:57:47Z\",\"message\":\"Error message 2\"},{\"time\":\"2016-07-12T22:57:47Z\",\"message\":\"Error message 3\"}],\"maxErrors\":4,\"startAttempts\":0}}",
         "{\"status\":\"UNKNOWN\",\"errorOccurred\":false,\"errors\":[{\"time\":\"2016-07-12T22:57:47Z\",\"message\":\"Error message 0\"},{\"time\":\"2016-07-12T22:57:47Z\",\"message\":\"Error message 1\"},{\"time\":\"2016-07-12T22:57:47Z\",\"message\":\"Error message 2\"},{\"time\":\"2016-07-12T22:57:47Z\",\"message\":\"Error message 3\"}],\"maxErrors\":4,\"startAttempts\":0}"};
        final int JOB_RESPONSE_COUNT = jobResponseStrings.length;

        Job jobToStart = new Job();
        jobToStart.setRecipeName("Test_Recipe");
        jobToStart.setFacility("Facility");
        jobToStart.setStartDelay("PT1M");
        jobToStart.setDurationSeconds(60);
        jobToStart.setPlaybackLoggingEnabled(true);

        for (int index = 0; index < JOB_RESPONSE_COUNT; index++) {
            JobStatus status = JobStatus.values()[index];

            stubFor(post(urlEqualTo("/control/v1/jobs/start")).willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody(jobResponseStrings[index])));

            Response response = jobController.startJobAsResponse(jobToStart);
            Assert.assertEquals(200, response.getStatus());
            response.close();

            JobResponse jobResponse = jobController.startJob(jobToStart);
            Assert.assertEquals(status, jobResponse.getJobStatusAsEnum());
            JobResponseError[] jobResponseErrors = jobResponse.getErrors();
            if (jobResponseErrors.length > 0) {
                Assert.assertEquals("Error message 0", jobResponseErrors[0].getMessage());
                Assert.assertEquals(MAX_ERRORS, jobResponse.getMaxErrors());
            }
            String jobReasonString = jobResponse.getStopReason();
            if (index < JobStopReason.values().length) {
                JobStopReason stopReason = JobStopReason.valueOf(jobReasonString);
                Assert.assertTrue(index == stopReason.ordinal());
            }
        }
    }
}
