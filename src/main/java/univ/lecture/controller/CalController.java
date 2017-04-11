package univ.lecture.controller;

import univ.lecture;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import univ.lecture.model.Result;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Copy by taewook on 2017. 4. 11
 */
@RestController
@RequestMapping("/api/v1/calc")
@Log4j
public class RiotApiController {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${cal.endpoint}")
    private String calEndpoint;

    @RequestMapping(value = "/result/{expression}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result queryResult(@PathVariable("expression") String expression) throws UnsupportedEncodingException {
        final String url = calEndpoint;
	
	Calculator calculator = new Calculator(expression);
	queryResult.result = calculator.calculate;
	
        String response = restTemplate.getForObject(url, String.class);
        Map<String, Object> parsedMap = new JacksonJsonParser().parseMap(response);

        parsedMap.forEach((key, value) -> log.info(String.format("key [%s] type [%s] value [%s]", key, value.getClass(), value)));

        Map<String, Object> summonerDetail = (Map<String, Object>) parsedMap.values().toArray()[0];
        String queriedName = (String)summonerDetail.get("name");
        int queriedLevel = (Integer)summonerDetail.get("summonerLevel");
        Summoner summoner = new Summoner(queriedName, queriedLevel);

        return summoner;
    }
}