package site.metacoding.serverproject.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import site.metacoding.serverproject.domain.Hospital;
import site.metacoding.serverproject.domain.HospitalRepository;

@Controller
public class DownloadController {

    private HospitalRepository hospitalRepository;

    public DownloadController(HospitalRepository hospitalRepository){
        this.hospitalRepository = hospitalRepository;
    }
    
    @GetMapping("/")
    public String main(){
        return "/mainForm";
    }

    @GetMapping("hospital/download")
    public String Download(Model model){

        StringBuffer sb = new StringBuffer();
        
        sb.append("http://3.38.254.72:5000/api/hospital?");
        sb.append("sidoCdNm=");
        sb.append("부산&");
        sb.append("sgguCdNm=");
        sb.append("부산사하구");

        System.out.println(sb.toString()); // URI 담기

        RestTemplate restTemplate = new RestTemplate(); // Entity에 담을 템플렛 생성
        Hospital[] response = restTemplate.getForObject(sb.toString(), Hospital[].class);
        // Hospital 객체를 Eintity로 생성

        //System.out.println(response);

        List<Hospital> hospitals = Arrays.asList(response); // 배열을 리스트로 전환
        hospitalRepository.saveAll(hospitals); // 쿼리 실행

        //System.out.println(hospitals);

        model.addAttribute("hospital", hospitals); //모델에 담기

        return "/hospital/list";
    }

    @GetMapping("hospital/list")
    public String show(Model model){
        List<Hospital> hosEntity = hospitalRepository.findAll(); // 쿼리 실행

        model.addAttribute("hospitals", hosEntity); 

        return "/listForm";
    }
    
}
