package com.impinj.itemsense.client.coordinator;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.hamcrest.CoreMatchers.instanceOf;

import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import com.impinj.itemsense.client.TestUtils;
import com.impinj.itemsense.client.coordinator.job.Job;
import com.impinj.itemsense.client.coordinator.job.JobController;
import com.impinj.itemsense.client.coordinator.job.JobResponse;
import com.impinj.itemsense.client.coordinator.job.JobResponseError;
import com.impinj.itemsense.client.coordinator.job.JobStatus;
import com.impinj.itemsense.client.coordinator.job.JobStopReason;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;


public class JobControllerTest {

  private static final int MAX_ERRORS = 4;
  @ClassRule
  public static WireMockClassRule wireMockRule = new WireMockClassRule(TestUtils.MOCK_PORT);
  @Rule
  public WireMockClassRule instanceRule = wireMockRule;
  private CoordinatorApiController coordinatorApiController;
  private JobController jobController;

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
    String jobResponseStrings = "[{\"id\":\"05d2518b-b8e0-41b3-8112-481579d6b512\",\"status\":\"STOPPED\",\"readerNames\":[\"Arlington_Office\"],\"creationTime\":\"2016-01-25T04:41:26.318Z[Etc/UTC]\",\"lastActivityTime\":\"2016-01-25T04:47:24.404Z\",\"activeDuration\":\"PT5M\",\"errorOccurred\":false,\"errors\":[],\"facilities\":[{\"name\":\"Arlington\"}],\"job\":{\"recipeName\":\"Arlington_Location\",\"durationSeconds\":300,\"startDelay\":\"PT0S\",\"reportToDatabaseEnabled\":null,\"reportToMessageQueueEnabled\":null,\"reportToFileEnabled\":null,\"facility\":\"Arlington\"},\"instanceMetadata\":null,\"lastHeartbeatTime\":\"2016-01-25T04:47:19.522Z[Etc/UTC]\"}]";
    stubFor(get(urlEqualTo("/control/v1/jobs/show")).willReturn(aResponse()
                                                                    .withStatus(200)
                                                                    .withHeader(
                                                                        "Content-Type",
                                                                        "application/json")
                                                                    .withBody(jobResponseStrings)));

    List<JobResponse> jobs = jobController.getJobs();
    Assert.assertEquals(jobs.size(), 1);
    Assert.assertThat(jobs, instanceOf(ArrayList.class));
    Assert.assertThat(jobs.get(0), instanceOf(JobResponse.class));
  }

  @Test
  public void testGetAllJobs2() {
    String jobResponsesString = "[{\"id\":\"d5e2fae2-77ea-4783-a9a3-e95545e87951\",\"status\":\"RUNNING\",\"readerNames\":[\"SpeedwayR-11-5D-90\"],\"creationTime\":\"2017-01-03T16:00:04.29Z\",\"lastActivityTime\":\"2017-01-07T07:20:56.94Z\",\"activeDuration\":\"PT87H21M3.475S\",\"errorOccurred\":false,\"errors\":[],\"maxErrors\":5,\"stopReason\":null,\"facility\":{\"name\":\"jt-desk-11\"},\"job\":{\"recipeName\":\"Hybris-Gateway2\",\"durationSeconds\":null,\"startDelay\":\"PT0S\",\"reportToDatabaseEnabled\":true,\"reportToHistoryEnabled\":true,\"reportToMessageQueueEnabled\":true,\"reportToFileEnabled\":false,\"facility\":\"jt-desk-11\"},\"instanceMetadata\":{\"port\":54981,\"instanceId\":\"f6465195-3c73-481a-8bb4-d2fc5c7b3574\",\"controlUrl\":\"http://localhost:54981/itemsense/readermanager\"},\"lastHeartbeatTime\":\"2017-01-07T07:20:56.94Z\",\"startAttempts\":0,\"facilities\":[{\"name\":\"jt-desk-11\"}]},{\"id\":\"0b814897-b9a2-471c-b66a-63965192178a\",\"status\":\"STOPPED\",\"readerNames\":[\"SpeedwayR-11-5D-90\"],\"creationTime\":\"2017-01-03T15:46:32.059Z\",\"lastActivityTime\":\"2017-01-03T15:57:06.147Z\",\"activeDuration\":\"PT10M28.41S\",\"errorOccurred\":false,\"errors\":[],\"maxErrors\":5,\"stopReason\":\"USER_REQUESTED_ABRUPT\",\"facility\":{\"name\":\"jt-desk-11\"},\"job\":{\"recipeName\":\"Hybris-Gateway2\",\"durationSeconds\":null,\"startDelay\":\"PT0S\",\"reportToDatabaseEnabled\":true,\"reportToHistoryEnabled\":true,\"reportToMessageQueueEnabled\":true,\"reportToFileEnabled\":false,\"facility\":\"jt-desk-11\"},\"instanceMetadata\":null,\"lastHeartbeatTime\":\"2017-01-03T15:57:05.092Z\",\"startAttempts\":0,\"facilities\":[{\"name\":\"jt-desk-11\"}]},{\"id\":\"09043905-ae46-4532-b4ce-cd120c84cb07\",\"status\":\"STOPPED\",\"readerNames\":[\"SpeedwayR-11-5D-90\"],\"creationTime\":\"2016-12-21T20:09:17.406Z\",\"lastActivityTime\":\"2017-01-03T15:44:07.739Z\",\"activeDuration\":\"PT307H35M33.577S\",\"errorOccurred\":false,\"errors\":[],\"maxErrors\":5,\"stopReason\":\"USER_REQUESTED_ABRUPT\",\"facility\":{\"name\":\"jt-desk-11\"},\"job\":{\"recipeName\":\"Hybris-Gateway2\",\"durationSeconds\":null,\"startDelay\":\"PT0S\",\"reportToDatabaseEnabled\":true,\"reportToHistoryEnabled\":true,\"reportToMessageQueueEnabled\":true,\"reportToFileEnabled\":false,\"facility\":\"jt-desk-11\"},\"instanceMetadata\":null,\"lastHeartbeatTime\":\"2017-01-03T15:43:59.103Z\",\"startAttempts\":0,\"facilities\":[{\"name\":\"jt-desk-11\"}]}]";

    stubFor(get(urlEqualTo("/control/v1/jobs/show")).willReturn(aResponse()
                                                                    .withStatus(200)
                                                                    .withHeader(
                                                                        "Content-Type",
                                                                        "application/json")
                                                                    .withBody(jobResponsesString)));

    List<JobResponse> jobs = jobController.getJobs();
    Assert.assertEquals(jobs.size(), 3);
    Assert.assertThat(jobs, instanceOf(ArrayList.class));
    Assert.assertThat(jobs.get(0), instanceOf(JobResponse.class));
  }

  @Test
  public void testGetAllJobs3() {
    String jobResponsesString = "[{\"id\":\"24ece453-5e04-41d2-8236-855303d89cfc\",\"status\":\"STOPPED\",\"readerNames\":[\"xArray-11-4D-3D\"],\"creationTime\":\"2017-01-07T05:12:19.9Z\",\"lastActivityTime\":\"2017-01-07T05:13:25.058Z\",\"activeDuration\":\"PT1M0.003S\",\"errorOccurred\":false,\"errors\":[],\"maxErrors\":5,\"stopReason\":\"JOB_COMPLETED\",\"facility\":{\"name\":\"NATALIE\"},\"job\":{\"recipeName\":\"IMPINJ_Deep_Scan_Inventory\",\"durationSeconds\":60,\"startDelay\":\"PT0S\",\"reportToDatabaseEnabled\":false,\"reportToHistoryEnabled\":true,\"reportToMessageQueueEnabled\":false,\"reportToFileEnabled\":false,\"facility\":\"NATALIE\"},\"instanceMetadata\":null,\"lastHeartbeatTime\":\"2017-01-07T05:13:21.833Z\",\"startAttempts\":0,\"facilities\":[{\"name\":\"NATALIE\"}]},{\"id\":\"84ca1f6f-5caf-41ca-a0f8-d24407f00745\",\"status\":\"STOPPED\",\"readerNames\":[\"xArray-11-4D-3D\"],\"creationTime\":\"2017-01-06T23:09:14.431Z\",\"lastActivityTime\":\"2017-01-06T23:10:18.987Z\",\"activeDuration\":\"PT1M0.002S\",\"errorOccurred\":false,\"errors\":[],\"maxErrors\":5,\"stopReason\":\"JOB_COMPLETED\",\"facility\":{\"name\":\"NATALIE\"},\"job\":{\"recipeName\":\"IMPINJ_Deep_Scan_Inventory\",\"durationSeconds\":60,\"startDelay\":\"PT0S\",\"reportToDatabaseEnabled\":false,\"reportToHistoryEnabled\":true,\"reportToMessageQueueEnabled\":false,\"reportToFileEnabled\":false,\"facility\":\"NATALIE\"},\"instanceMetadata\":null,\"lastHeartbeatTime\":\"2017-01-06T23:10:16.323Z\",\"startAttempts\":0,\"facilities\":[{\"name\":\"NATALIE\"}]},{\"id\":\"674ca6e2-0ecc-4751-af24-66212aa1c5a7\",\"status\":\"STOPPED\",\"readerNames\":[\"xArray-11-4D-3D\"],\"creationTime\":\"2017-01-06T22:43:03.1Z\",\"lastActivityTime\":\"2017-01-06T22:47:32.888Z\",\"activeDuration\":\"PT0S\",\"errorOccurred\":true,\"errors\":[{\"time\":\"2017-01-06T22:45:05.378Z\",\"message\":\"No agents acknowledged job start, can't proceed\"},{\"time\":\"2017-01-06T22:47:07.972Z\",\"message\":\"No agents acknowledged job start, can't proceed\"}],\"maxErrors\":5,\"stopReason\":\"USER_REQUESTED_ABRUPT\",\"facility\":{\"name\":\"NATALIE\"},\"job\":{\"recipeName\":\"IMPINJ_Deep_Scan_Inventory\",\"durationSeconds\":60,\"startDelay\":\"PT0S\",\"reportToDatabaseEnabled\":false,\"reportToHistoryEnabled\":true,\"reportToMessageQueueEnabled\":false,\"reportToFileEnabled\":false,\"facility\":\"NATALIE\"},\"instanceMetadata\":null,\"lastHeartbeatTime\":\"2017-01-06T22:47:29.776Z\",\"startAttempts\":2,\"facilities\":[{\"name\":\"NATALIE\"}]},{\"id\":\"ec57406e-3b14-4299-808e-e1f767a960a9\",\"status\":\"STOPPED\",\"readerNames\":[\"xArray-11-4D-3D\"],\"creationTime\":\"2017-01-06T22:27:12.445Z\",\"lastActivityTime\":\"2017-01-06T22:39:24.324Z\",\"activeDuration\":\"PT0S\",\"errorOccurred\":true,\"errors\":[{\"time\":\"2017-01-06T22:29:14.831Z\",\"message\":\"No agents acknowledged job start, can't proceed\"},{\"time\":\"2017-01-06T22:31:17.188Z\",\"message\":\"No agents acknowledged job start, can't proceed\"},{\"time\":\"2017-01-06T22:33:19.564Z\",\"message\":\"No agents acknowledged job start, can't proceed\"},{\"time\":\"2017-01-06T22:35:21.939Z\",\"message\":\"No agents acknowledged job start, can't proceed\"},{\"time\":\"2017-01-06T22:37:24.31Z\",\"message\":\"No agents acknowledged job start, can't proceed\"}],\"maxErrors\":5,\"stopReason\":\"JOB_FAILED\",\"facility\":{\"name\":\"NATALIE\"},\"job\":{\"recipeName\":\"IMPINJ_Deep_Scan_Inventory\",\"durationSeconds\":60,\"startDelay\":\"PT0S\",\"reportToDatabaseEnabled\":false,\"reportToHistoryEnabled\":true,\"reportToMessageQueueEnabled\":false,\"reportToFileEnabled\":false,\"facility\":\"NATALIE\"},\"instanceMetadata\":null,\"lastHeartbeatTime\":\"2017-01-06T22:37:23.889Z\",\"startAttempts\":5,\"facilities\":[{\"name\":\"NATALIE\"}]},{\"id\":\"edacea62-e8ee-47a9-8129-dcffeb5fce9c\",\"status\":\"STOPPED\",\"readerNames\":[\"xArray-11-4D-3D\"],\"creationTime\":\"2017-01-06T21:34:03.77Z\",\"lastActivityTime\":\"2017-01-06T21:46:15.773Z\",\"activeDuration\":\"PT0S\",\"errorOccurred\":true,\"errors\":[{\"time\":\"2017-01-06T21:36:06.044Z\",\"message\":\"No agents acknowledged job start, can't proceed\"},{\"time\":\"2017-01-06T21:38:08.501Z\",\"message\":\"No agents acknowledged job start, can't proceed\"},{\"time\":\"2017-01-06T21:40:10.943Z\",\"message\":\"No agents acknowledged job start, can't proceed\"},{\"time\":\"2017-01-06T21:42:13.283Z\",\"message\":\"No agents acknowledged job start, can't proceed\"},{\"time\":\"2017-01-06T21:44:15.758Z\",\"message\":\"No agents acknowledged job start, can't proceed\"}],\"maxErrors\":5,\"stopReason\":\"JOB_FAILED\",\"facility\":{\"name\":\"NATALIE\"},\"job\":{\"recipeName\":\"IMPINJ_Deep_Scan_Inventory\",\"durationSeconds\":60,\"startDelay\":\"PT0S\",\"reportToDatabaseEnabled\":false,\"reportToHistoryEnabled\":true,\"reportToMessageQueueEnabled\":false,\"reportToFileEnabled\":false,\"facility\":\"NATALIE\"},\"instanceMetadata\":null,\"lastHeartbeatTime\":\"2017-01-06T21:44:15.325Z\",\"startAttempts\":5,\"facilities\":[{\"name\":\"NATALIE\"}]},{\"id\":\"4f89c7e9-3a59-4048-83e7-3769ae0af79a\",\"status\":\"STOPPED\",\"readerNames\":[\"xArray-11-4D-3D\"],\"creationTime\":\"2017-01-06T01:22:40.697Z\",\"lastActivityTime\":\"2017-01-06T01:23:45.227Z\",\"activeDuration\":\"PT1M0.004S\",\"errorOccurred\":false,\"errors\":[],\"maxErrors\":5,\"stopReason\":\"JOB_COMPLETED\",\"facility\":{\"name\":\"NATALIE\"},\"job\":{\"recipeName\":\"IMPINJ_Deep_Scan_Inventory\",\"durationSeconds\":60,\"startDelay\":\"PT0S\",\"reportToDatabaseEnabled\":false,\"reportToHistoryEnabled\":true,\"reportToMessageQueueEnabled\":false,\"reportToFileEnabled\":false,\"facility\":\"NATALIE\"},\"instanceMetadata\":null,\"lastHeartbeatTime\":\"2017-01-06T01:23:42.746Z\",\"startAttempts\":0,\"facilities\":[{\"name\":\"NATALIE\"}]},{\"id\":\"ff24d536-8f81-4903-9c12-f384162308a2\",\"status\":\"STOPPED\",\"readerNames\":[\"xArray-11-4D-3D\"],\"creationTime\":\"2017-01-06T00:51:21.823Z\",\"lastActivityTime\":\"2017-01-06T00:52:27.724Z\",\"activeDuration\":\"PT1M0.004S\",\"errorOccurred\":false,\"errors\":[],\"maxErrors\":5,\"stopReason\":\"JOB_COMPLETED\",\"facility\":{\"name\":\"NATALIE\"},\"job\":{\"recipeName\":\"IMPINJ_Deep_Scan_Inventory\",\"durationSeconds\":60,\"startDelay\":\"PT0S\",\"reportToDatabaseEnabled\":false,\"reportToHistoryEnabled\":true,\"reportToMessageQueueEnabled\":false,\"reportToFileEnabled\":false,\"facility\":\"NATALIE\"},\"instanceMetadata\":null,\"lastHeartbeatTime\":\"2017-01-06T00:52:23.69Z\",\"startAttempts\":0,\"facilities\":[{\"name\":\"NATALIE\"}]},{\"id\":\"773ec5f6-4c80-4ca9-9b18-789cf2d11a71\",\"status\":\"STOPPED\",\"readerNames\":[\"xArray-11-4D-3D\"],\"creationTime\":\"2017-01-06T00:47:46.154Z\",\"lastActivityTime\":\"2017-01-06T00:48:51.343Z\",\"activeDuration\":\"PT1M0.005S\",\"errorOccurred\":false,\"errors\":[],\"maxErrors\":5,\"stopReason\":\"JOB_COMPLETED\",\"facility\":{\"name\":\"NATALIE\"},\"job\":{\"recipeName\":\"IMPINJ_Deep_Scan_Inventory\",\"durationSeconds\":60,\"startDelay\":\"PT0S\",\"reportToDatabaseEnabled\":false,\"reportToHistoryEnabled\":true,\"reportToMessageQueueEnabled\":false,\"reportToFileEnabled\":false,\"facility\":\"NATALIE\"},\"instanceMetadata\":null,\"lastHeartbeatTime\":\"2017-01-06T00:48:48.127Z\",\"startAttempts\":0,\"facilities\":[{\"name\":\"NATALIE\"}]},{\"id\":\"87e9f4a1-4cd8-4100-b5d3-8c50089a2e16\",\"status\":\"STOPPED\",\"readerNames\":[\"xArray-11-4D-3D\"],\"creationTime\":\"2017-01-06T00:32:07.143Z\",\"lastActivityTime\":\"2017-01-06T00:37:46.848Z\",\"activeDuration\":\"PT0S\",\"errorOccurred\":true,\"errors\":[{\"time\":\"2017-01-06T00:34:09.662Z\",\"message\":\"No agents acknowledged job start, can't proceed\"},{\"time\":\"2017-01-06T00:36:12.542Z\",\"message\":\"No agents acknowledged job start, can't proceed\"}],\"maxErrors\":5,\"stopReason\":\"USER_REQUESTED_ABRUPT\",\"facility\":{\"name\":\"NATALIE\"},\"job\":{\"recipeName\":\"IMPINJ_Deep_Scan_Inventory\",\"durationSeconds\":60,\"startDelay\":\"PT0S\",\"reportToDatabaseEnabled\":false,\"reportToHistoryEnabled\":true,\"reportToMessageQueueEnabled\":false,\"reportToFileEnabled\":false,\"facility\":\"NATALIE\"},\"instanceMetadata\":null,\"lastHeartbeatTime\":\"2017-01-06T00:37:44.502Z\",\"startAttempts\":2,\"facilities\":[{\"name\":\"NATALIE\"}]},{\"id\":\"1f4c2e15-f4d6-45aa-bcf7-7c41343da7de\",\"status\":\"STOPPED\",\"readerNames\":[\"xArray-11-4D-3D\"],\"creationTime\":\"2017-01-04T22:39:56.064Z\",\"lastActivityTime\":\"2017-01-04T22:41:00.341Z\",\"activeDuration\":\"PT1M0.004S\",\"errorOccurred\":false,\"errors\":[],\"maxErrors\":5,\"stopReason\":\"JOB_COMPLETED\",\"facility\":{\"name\":\"NATALIE\"},\"job\":{\"recipeName\":\"IMPINJ_Deep_Scan_Inventory\",\"durationSeconds\":60,\"startDelay\":\"PT0S\",\"reportToDatabaseEnabled\":false,\"reportToHistoryEnabled\":true,\"reportToMessageQueueEnabled\":false,\"reportToFileEnabled\":false,\"facility\":\"NATALIE\"},\"instanceMetadata\":null,\"lastHeartbeatTime\":\"2017-01-04T22:40:58.008Z\",\"startAttempts\":0,\"facilities\":[{\"name\":\"NATALIE\"}]},{\"id\":\"a19b910c-1cba-44c7-bd82-9daa755bc87d\",\"status\":\"STOPPED\",\"readerNames\":[\"xArray-11-4D-3D\"],\"creationTime\":\"2017-01-04T22:36:53.64Z\",\"lastActivityTime\":\"2017-01-04T22:37:57.851Z\",\"activeDuration\":\"PT1M0.004S\",\"errorOccurred\":false,\"errors\":[],\"maxErrors\":5,\"stopReason\":\"JOB_COMPLETED\",\"facility\":{\"name\":\"NATALIE\"},\"job\":{\"recipeName\":\"IMPINJ_Deep_Scan_Inventory\",\"durationSeconds\":60,\"startDelay\":\"PT0S\",\"reportToDatabaseEnabled\":false,\"reportToHistoryEnabled\":true,\"reportToMessageQueueEnabled\":false,\"reportToFileEnabled\":false,\"facility\":\"NATALIE\"},\"instanceMetadata\":null,\"lastHeartbeatTime\":\"2017-01-04T22:37:55.58Z\",\"startAttempts\":0,\"facilities\":[{\"name\":\"NATALIE\"}]}]";

    stubFor(get(urlEqualTo("/control/v1/jobs/show")).willReturn(aResponse()
                                                                    .withStatus(200)
                                                                    .withHeader(
                                                                        "Content-Type",
                                                                        "application/json")
                                                                    .withBody(jobResponsesString)));

    List<JobResponse> jobs = jobController.getJobs();
    Assert.assertEquals(11, jobs.size());
    Assert.assertThat(jobs, instanceOf(ArrayList.class));
    Assert.assertThat(jobs.get(0), instanceOf(JobResponse.class));

  }

  @Test
  public void testGetAllJobsWithErrors() {
    String jobResponseStrings = "[{\"id\": \"5301035e-a5ea-47ad-92ef-596d9a2e790e\", \"status\": \"RUNNING\", \"readerNames\": [ \"Arlington_Office\" ], \"creationTime\": \"2016-06-15T21:14:19.488Z[Etc/UTC]\", \"lastActivityTime\": \"2016-06-16T01:39:33.423Z\", \"stateEntryTime\": \"2016-06-15T21:14:33.912Z\", \"activeDuration\": \"PT4H24M59.511S\", \"errorOccurred\": false, \"errors\": [], \"facilities\": [ { \"name\": \"Arlington\" } ], \"job\": { \"recipeName\": \"Arlington_Location\", \"durationSeconds\": 36000000, \"startDelay\": \"PT0S\", \"reportToDatabaseEnabled\": true, \"reportToMessageQueueEnabled\": null, \"reportToFileEnabled\": null, \"facility\": \"Arlington\" }, \"instanceMetadata\": { \"port\": 53869, \"instanceId\": \"194e1bb7-a7fc-4e41-968b-ce7bf1d6a1ee\", \"controlUrl\": \"http://localhost:53869/itemsense/readermanager\"}, \"lastHeartbeatTime\": \"2016-06-16T01:39:39.335Z[Etc/UTC]\", \"startAttempts\": 1 }, { \"id\": \"7f231ecb-3cd5-422f-b09c-670fbf8e4a1b\", \"status\": \"INITIALIZING\", \"readerNames\": [ \"Arlington_Office\" ], \"creationTime\": \"2016-05-31T21:26:45.523Z[GMT]\", \"lastActivityTime\": \"2016-06-15T05:52:19.512Z[GMT]\", \"stateEntryTime\": \"2016-06-15T05:52:19.512Z[GMT]\", \"activeDuration\": \"PT0S\", \"errorOccurred\": true, \"errors\": [ { \"time\": \"2016-06-15T05:49:15.514Z[GMT]\", \"message\": \"Could not detect job progress, possibly dead or in a bad state : Heartbeat Timed Out\" }, { \"time\": \"2016-06-15T05:50:23.641Z[GMT]\", \"message\": \"Error publishing state to JobInstance : Initialization error: An error occurred while connecting to the reader (192.168.15.16): \" }, { \"time\": \"2016-06-15T05:51:20.618Z[GMT]\", \"message\": \"Error publishing state to JobInstance : Initialization error: An error occurred while connecting to the reader (192.168.15.16): \" }, { \"time\": \"2016-06-15T05:52:20.626Z[GMT]\", \"message\": \"Error publishing state to JobInstance : Initialization error: An error occurred while connecting to the reader (192.168.15.16): \" }, { \"time\": \"2016-06-15T05:52:20.797Z[GMT]\", \"message\": \"Job was unable to start within the maximum number of start attempts (4) : Failed job\" } ], \"facilities\": [ { \"name\": \"Arlington\" } ], \"job\": { \"recipeName\": \"Arlington_Location\", \"durationSeconds\": 36000000, \"startDelay\": \"PT0S\", \"reportToDatabaseEnabled\": true, \"reportToMessageQueueEnabled\": null, \"reportToFileEnabled\": null, \"facility\": \"Arlington\" }, \"instanceMetadata\": null, \"lastHeartbeatTime\": \"2016-06-15T05:52:18.584Z[GMT]\", \"startAttempts\": 4}]";
    stubFor(get(urlEqualTo("/control/v1/jobs/show")).willReturn(aResponse()
                                                                    .withStatus(200)
                                                                    .withHeader(
                                                                        "Content-Type",
                                                                        "application/json")
                                                                    .withBody(jobResponseStrings)));

    List<JobResponse> jobs = jobController.getJobs();
    Assert.assertEquals(jobs.size(), 2);
    Assert.assertThat(jobs, instanceOf(ArrayList.class));
    Assert.assertThat(jobs.get(1), instanceOf(JobResponse.class));

  }

  @Test
  public void testGetJob() {
    String jobResponseString = "{\"id\":\"05d2518b-b8e0-41b3-8112-481579d6b512\",\"status\":\"COMPLETE\",\"readerNames\":[\"Arlington_Office\"],\"creationTime\":\"2016-01-25T04:41:26.318Z[Etc/UTC]\",\"lastActivityTime\":\"2016-01-25T04:47:24.404Z\",\"activeDuration\":\"PT5M\",\"errorOccurred\":false,\"errors\":[],\"facilities\":[{\"name\":\"Arlington\"}],\"job\":{\"recipeName\":\"Arlington_Location\",\"durationSeconds\":300,\"startDelay\":\"PT0S\",\"reportToDatabaseEnabled\":null,\"reportToMessageQueueEnabled\":null,\"reportToFileEnabled\":null,\"facility\":\"Arlington\"},\"instanceMetadata\":null,\"lastHeartbeatTime\":\"2016-01-25T04:47:19.522Z[Etc/UTC]\"}";
    stubFor(get(urlEqualTo("/control/v1/jobs/show/05d2518b-b8e0-41b3-8112-481579d6b512"))
                .willReturn(aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", "application/json")
                                .withBody(jobResponseString)));

    String jobId = "05d2518b-b8e0-41b3-8112-481579d6b512";
    JobResponse jobResult = jobController.getJob(jobId);

    Assert.assertThat(jobResult, instanceOf(JobResponse.class));
    Assert.assertThat(jobResult.getReaderNames(), instanceOf(String[].class));
    Assert.assertThat(jobResult.getJob(), instanceOf(Job.class));
  }

  @Test
  public void testStartJob() {
    String[] jobResponseStrings = {
        "{\"status\":\"WAITING\",\"errorOccurred\":false,\"errors\":[{\"time\":\"2016-07-12T22:57:47Z\",\"message\":\"Error message 0\"},{\"time\":\"2016-07-12T22:57:47Z\",\"message\":\"Error message 1\"},{\"time\":\"2016-07-12T22:57:47Z\",\"message\":\"Error message 2\"},{\"time\":\"2016-07-12T22:57:47Z\",\"message\":\"Error message 3\"}],\"maxErrors\":4,\"startAttempts\":0,\"stopReason\":\"JOB_COMPLETED\"}",
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

    for (int index = 0; index < JOB_RESPONSE_COUNT; index++) {
      JobStatus status = JobStatus.values()[index];

      stubFor(post(urlEqualTo("/control/v1/jobs/start")).willReturn(aResponse()
                                                                        .withStatus(200)
                                                                        .withHeader(
                                                                            "Content-Type",
                                                                            "application/json")
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
