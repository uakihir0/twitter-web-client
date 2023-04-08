package net.socialhub.twitter.web.internal;

import net.socialhub.twitter.web.api.LoginResource;
import net.socialhub.twitter.web.utility.Cookie;
import net.socialhub.twitter.web.entity.Response;
import net.socialhub.twitter.web.entity.request.LoginRequest;
import net.socialhub.twitter.web.entity.response.Onboarding;
import net.socialhub.twitter.web.utility.Endpoint;
import net.socialhub.twitter.web.utility.Session;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LoginResourceImpl extends AbstractResource implements LoginResource {

    public LoginResourceImpl(String baseUrl, Session session) {
        super(baseUrl, session);
    }

    @Override
    public Cookie login(LoginRequest request) {
        String flowToken = loginStartSubtask();
        flowToken = loginJsInstrumentationSubtask(flowToken);
        flowToken = loginEnterUserIdentifierSSOSSubtask(flowToken, request.getUsername());
        return null;
    }

    /*
     * Start subtask for login
     * ログインにおけるサブタスクを開始
     */
    private String loginStartSubtask() {

        Map<String, Object> startLocation = new HashMap<>();
        startLocation.put("location", "splash_screen");

        Map<String, Object> flowContext = new HashMap<>();
        flowContext.put("debug_overrides", new HashMap<>());
        flowContext.put("start_location", startLocation);

        Map<String, Object> inputFlowData = new HashMap<>();
        inputFlowData.put("flow_context", flowContext);

        Map<String, Integer> subtaskVersions = new HashMap<>();
        subtaskVersions.put("contacts_live_sync_permission_prompt", 0);
        subtaskVersions.put("email_verification", 1);
        subtaskVersions.put("topics_selector", 1);
        subtaskVersions.put("wait_spinner", 1);
        subtaskVersions.put("cta", 4);

        Map<String, Object> data = new HashMap<>();
        data.put("input_flow_data", inputFlowData);
        data.put("subtask_versions", subtaskVersions);

        return post(
                Endpoint.Onboarding.path()
                        + "?flow_name=login",
                gson.toJson(data),
                Onboarding.class
        ).get().getFlowToken();
    }

    /*
     * Return UI metrics for login
     * ログインにおける UI メトリクスを返却
     */
    private String loginJsInstrumentationSubtask(String flowToken) {

        Map<String, Integer> rf = new HashMap<>();
        rf.put("af07339bbc6d24ced887d705eb0c9fd29b4a7d7ddc21136c9f94d53a4bc774d2", 88);
        rf.put("a6ce87d6481c6ec4a823548be3343437888441d2a453061c54f8e2eb325856f7", 250);
        rf.put("a0062ad06384a8afd38a41cd83f31b0dbfdea0eff4b24c69f0dd9095b2fb56d6", 16);
        rf.put("a929e5913a5715d93491eaffaa139ba4977cbc826a5e2dbcdc81cae0f093db25", 186);

        Map<String, Object> metrics = new HashMap<>();
        metrics.put("s", "Q-H-53m1uXImK0F0ogrxRQtCWTH1KIlPbIy0MloowlMa4WNK5ZCcDoXyRs1q_cPbynK73w_wfHG_UVRKKBWRoh6UJtlPS5kMa1p8fEvTYi76hwdzBEzovieR8t86UpeSkSBFYcL8foYKSp6Nop5mQR_QHGyEeleclCPUvzS0HblBJqZZdtUo-6by4BgCyu3eQ4fY5nOF8fXC85mu6k34wo982LMK650NsoPL96DBuloqSZvSHU47wq2uA4xy24UnI2WOc6U9KTvxumtchSYNnXq1HV662B8U2-jWrzvIU4yUHV3JYUO6sbN6j8Ho9JaUNJpJSK7REwqCBQ3yG7iwMAAAAX2Vqcbs");
        metrics.put("rf", rf);

        Map<String, Object> jsInstrumentation = new HashMap<>();
        jsInstrumentation.put("response", gson.toJson(metrics));
        jsInstrumentation.put("link", "next_link");

        Map<String, Object> subtask = new HashMap<>();
        subtask.put("subtask_id", "LoginJsInstrumentationSubtask");
        subtask.put("js_instrumentation", jsInstrumentation);

        List<Map<String, Object>> subtasks = new ArrayList<>();
        subtasks.add(subtask);

        Map<String, Object> data = new HashMap<>();
        data.put("flow_token", flowToken);
        data.put("subtask_inputs", subtasks);

        return post(
                Endpoint.Onboarding.path(),
                gson.toJson(data),
                Onboarding.class
        ).get().getFlowToken();
    }

    /*
     * Enter user identifier
     * ログインにおける UserID の入力
     */
    private String loginEnterUserIdentifierSSOSSubtask(
            String flowToken,
            String identify
    ) {
        Map<String, Object> textData = new HashMap<>();
        textData.put("result", identify);

        Map<String, Object> responseData = new HashMap<>();
        responseData.put("text_data", textData);

        Map<String, Object> settingResponse = new HashMap<>();
        settingResponse.put("key", "user_identifier");
        settingResponse.put("response_data", responseData);

        List<Map<String, Object>> settingResponses = new ArrayList<>();
        settingResponses.add(settingResponse);

        Map<String, Object> settingsList = new HashMap<>();
        settingsList.put("setting_responses", settingResponses);
        settingsList.put("link", "next_link");

        Map<String, Object> subtask = new HashMap<>();
        subtask.put("subtask_id", "LoginEnterUserIdentifierSSO");
        subtask.put("settings_list", settingsList);

        List<Map<String, Object>> subtasks = new ArrayList<>();
        subtasks.add(subtask);

        Map<String, Object> data = new HashMap<>();
        data.put("flow_token", flowToken);
        data.put("subtask_inputs", subtasks);

        return post(
                Endpoint.Onboarding.path(),
                gson.toJson(data),
                Onboarding.class
        ).get().getFlowToken();
    }
}
