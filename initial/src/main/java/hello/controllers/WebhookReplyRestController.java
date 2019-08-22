package hello.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/webhook")
public class WebhookReplyRestController {

    @RequestMapping(value="/webhookreplyinit", method = RequestMethod.GET)
    public void webhookReplyGet(){
        System.out.println("Set the webhook url - http://localhost:9090/webhook/webhookreplyinit");
        String urlReplyto = "http://localhost:9091/webhook/webhookreply";
        String urlTo = "http://localhost:9090/webhook/savewebhook?webhook=" + urlReplyto;
        RestTemplate restTemplate = new RestTemplate();

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        Map map = new HashMap<String, String>();
        map.put("Content-Type", "application/json");

        headers.setAll(map);

        Map req_payload = new HashMap();
        req_payload.put("webhook", urlReplyto);

        HttpEntity<?> request = new HttpEntity<>(req_payload, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(urlTo, request, String.class);
        System.out.println(response.getBody());
    }

    @RequestMapping(value="/webhookreply", method = RequestMethod.POST)
    public void webhookReply(@RequestBody String payload){
        System.out.println("Received webhook reply from http://localhost:9091/webhooks");
        System.out.println("Payload: " + payload);
    }
}
