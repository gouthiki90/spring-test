package site.metacoding.serverproject.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer no;

    private String id;
    private String addr;
    private String mgtStaDd;
    private String pcrPsblYn;
    private String ratPsblYn;
    private String recuClCd;
    private String sgguCdNm;
    private String sidoCdNm;
    private String yadmNm;
    private String ykihoEnc;

    //@Column(nullable = false)
    private String xposWgs84;

    //@Column(nullable = false)
    private String yposWgs84;

    //@Column(nullable = false)
    private String xpos;

    //@Column(nullable = false)
    private String ypos;

    
}
