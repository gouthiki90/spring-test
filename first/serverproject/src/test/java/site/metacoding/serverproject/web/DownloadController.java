package site.metacoding.serverproject.web;

import java.net.URI;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import site.metacoding.serverproject.domain.Hospital;

@Controller
public class DownloadController {
    
    private RestTemplate restTemplate;
    private StringBuffer stringBuffer;

    public DownloadController(RestTemplate restTemplate, StringBuffer stringBuffer){
        this.restTemplate = restTemplate;
        this.stringBuffer = stringBuffer;
    }
    
    @GetMapping("/")
    public String Download(){
        
        StringBuffer sb = stringBuffer.append("http://3.38.254.72:5000/api/hospital?");
        sb.append("sidoCdNm=");
        sb.append("부산&");
        sb.append("sgguCdNm=");
        sb.append("부산사하구");

        System.out.println(sb.toString());

        Hospital response = restTemplate.getForObject("http://3.38.254.72:5000/api/hospital?sidoCdNm=부산&sgguCdNm=부산사하구", Hospital.class);

        System.out.println(response);

        return "list";
    }
    
}
