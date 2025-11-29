/*
package com.example.job.recommendation.service;

import com.example.job.recommendation.dto.JobPostingDto; // DTO import 필수
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder; // 이거 없으면 에러남

import java.net.URI;

@Service
@RequiredArgsConstructor
public class JobPostingService {

    private final RestTemplate restTemplate = new RestTemplate();

    // ★ 인증키 확인 (Decoding Key)
    private final String SERVICE_KEY = "7adb8c79f0b39b023435a8f94059a1e0e30d45083ef1d1bb74e69b43bbcf08d4";
    private final String API_URL = "https://apis.data.go.kr/1051000/recruitment";

    // 메서드 이름을 getJobPosting으로 통일! 반환 타입도 JobPostingDto로 통일!
    public JobPostingDto getJobPosting(String companyName) {
        try {
            // 1. URL 만들기
            URI uri = UriComponentsBuilder.fromUriString(API_URL)
                    .queryParam("authKey", SERVICE_KEY)
                    .queryParam("callTp", "L")
                    .queryParam("returnType", "XML")
                    .queryParam("startPage", "1")
                    .queryParam("display", "1")
                    .queryParam("coName", companyName)
                    .build()
                    .encode()
                    .toUri();

            // 로그 찍기
            System.out.println("====== [DEBUG] 요청 URL: " + uri.toString());

            // 2. 외부 API 호출
            String response = restTemplate.getForObject(uri, String.class);
            System.out.println("====== [DEBUG] 응답 데이터: " + response);

            // 3. 결과 담기 (일단 테스트용으로 응답 전체를 title에 넣어봄)
            JobPostingDto dto = new JobPostingDto();
            dto.setTitle(response); // 화면에서 XML 내용 확인용
            dto.setDeadline("2025-12-31");
            dto.setLocation("확인중");

            return dto;

        } catch (Exception e) {
            System.out.println("API 호출 실패: " + e.getMessage());
            return null;
        }
    }
}*//*
*/
/*


*//*

*/
/*
package com.example.job.recommendation.service;

import com.example.job.recommendation.dto.JobPostingDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;

@Service
@RequiredArgsConstructor
public class JobPostingService {

    private final RestTemplate restTemplate = new RestTemplate();

    // ★ 공공데이터포털에서 받은 Decoding Key 입력
    private final String SERVICE_KEY = "여기에_인증키_입력";

    // 알리오(공공기관 채용) API 주소
    private final String API_URL = "https://apis.data.go.kr/1051000/Recruitment/list";

    public JobPostingDto getJobPosting(String companyName) {
        try {
            URI uri = UriComponentsBuilder.fromUriString(API_URL)
                    .queryParam("serviceKey", SERVICE_KEY) // 알리오는 authKey가 아니라 serviceKey를 씁니다
                    .queryParam("pageNo", "1")
                    .queryParam("numOfRows", "1")
                    .queryParam("insttNm", companyName)    // 기관명(coName 아님)
                    .build()
                    .encode()
                    .toUri();

            System.out.println("====== [DEBUG] 요청 URL: " + uri.toString());

            String response = restTemplate.getForObject(uri, String.class);
            System.out.println("====== [DEBUG] 응답 데이터: " + response);

            JobPostingDto dto = new JobPostingDto();
            dto.setTitle(response); // 결과 확인용
            dto.setDeadline("채용 마감일 확인 요망");
            dto.setLocation("공공기관");

            return dto;

        } catch (Exception e) {
            System.out.println("====== [ERROR] API 호출 실패: " + e.getMessage());
            return null;
        }
    }
}*//*
*/
/*


package com.example.job.recommendation.service;

import com.example.job.recommendation.dto.JobPostingDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class JobPostingService {

    // ★ API 키 필요 없음! RestTemplate 필요 없음!

    public JobPostingDto getJobPosting(String companyName) {

        System.out.println("====== [MOCK] 가짜 API 호출 시도: " + companyName);

        // 1. 결과 담을 객체 생성
        JobPostingDto dto = new JobPostingDto();

        // 2. 기업 이름에 따라 '진짜 같은' 가짜 데이터 만들기
        if (companyName.contains("네이버") || companyName.contains("NAVER")) {
            dto.setTitle("[신입/경력] 네이버 클라우드 백엔드 개발자 공채");
            dto.setLocation("경기도 성남시 분당구");
            dto.setDeadline("2025-12-31 (D-Day)");
            dto.setUrl("https://recruit.navercorp.com");

        } else if (companyName.contains("카카오") || companyName.contains("Kakao")) {
            dto.setTitle("카카오페이 서버 개발자 대규모 영입");
            dto.setLocation("경기도 성남시 판교역");
            dto.setDeadline("채용시 마감");
            dto.setUrl("https://careers.kakao.com");

        } else if (companyName.contains("삼성전자")) {
            dto.setTitle("[DX부문] SW개발 신입사원 채용");
            dto.setLocation("경기도 수원시/서울 서초구");
            dto.setDeadline("2025-11-30");
            dto.setUrl("https://www.samsungcareers.com");

        } else if (companyName.contains("쿠팡")) {
            dto.setTitle("Coupang Pay - Java Backend Engineer");
            dto.setLocation("서울 송파구 (잠실)");
            dto.setDeadline("상시 채용");
            dto.setUrl("https://rockstar.coupang.com");

        } else {
            // 그 외 모르는 기업이 들어오면? 그냥 그럴싸하게 만듦
            dto.setTitle("[" + companyName + "] 2025년 상반기 신입/경력 공채");
            dto.setLocation("서울/경기");
            dto.setDeadline("2025-12-31");
            dto.setUrl("#");
        }

        // 3. 바로 리턴 (통신 X)
        return dto;
    }
}*//*


package com.example.job.recommendation.service;

import com.example.job.recommendation.dto.JobPostingDto;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class JobPostingService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper(); // JSON 파싱 도구

    // ★ 서울 열린데이터 광장 인증키 (일반 인증키 - Decoding Key 권장)
    private final String SEOUL_API_KEY = "6359554a4a6a796f36345144675264";

    public JobPostingDto getJobPosting(String companyName) {
        try {
            // 1. URL 만들기 (서울시 API는 슬래시 '/'로 구분합니다)
            // 형식: http://openapi.seoul.go.kr:8088/{KEY}/{TYPE}/{SERVICE}/{START}/{END}
            // 일단 최신 공고 100개를 가져와서 그 안에 기업이 있는지 찾습니다.
            String urlStr = "http://openapi.seoul.go.kr:8088/"
                    + SEOUL_API_KEY + "/json/GetJobInfo/1/100/";

            URI uri = URI.create(urlStr);

            System.out.println("====== [DEBUG] 요청 URL: " + uri.toString());

            // 2. API 호출
            String response = restTemplate.getForObject(uri, String.class);

            // 3. JSON 파싱 및 기업 찾기 (핵심 로직)
            JsonNode root = objectMapper.readTree(response);
            JsonNode rows = root.path("GetJobInfo").path("row"); // 공고 리스트

            for (JsonNode row : rows) {
                // API에서 준 기업명 (CMPNY_NM)
                String apiCompanyName = row.path("CMPNY_NM").asText();

                // 우리가 찾는 기업명이 포함되어 있는지 확인 (예: '네이버' 검색 시 '네이버클라우드'도 찾음)
                if (apiCompanyName.contains(companyName)) {

                    System.out.println("====== [DEBUG] 찾았다! 기업명: " + apiCompanyName);

                    // 4. 찾았으면 DTO에 담아서 리턴
                    JobPostingDto dto = new JobPostingDto();

                    // 명세서 보고 필드 매핑
                    dto.setTitle(row.path("JO_SJ").asText());           // JO_SJ: 구인제목
                    dto.setLocation(row.path("WORK_PARAR_BASS_ADRES_CN").asText()); // 근무예정지 주소
                    dto.setDeadline(row.path("RCEPT_CLOS_NM").asText()); // RCEPT_CLOS_NM: 마감일

                    // URL은 명세서에 따로 없어서 가이드라인(GUI_LN)이 있으면 넣음 (없을 수도 있음)
                    // (서울시 데이터는 상세 URL이 없는 경우가 많아 기본값 처리)
                    String detailUrl = "http://www.seoul.go.kr";
                    dto.setUrl(detailUrl);

                    return dto;
                }
            }

            // 5. 100개 뒤져봤는데 없으면? (없다고 표시)
            System.out.println("====== [DEBUG] 해당 기업의 공고가 없습니다: " + companyName);
            return null;

        } catch (Exception e) {
            System.out.println("====== [ERROR] API 호출 실패: " + e.getMessage());
            return null;
        }
    }
}*/

package com.example.job.recommendation.service;

import com.example.job.recommendation.dto.JobPostingDto;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class JobPostingService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper(); // JSON 파싱 도구

    // ★ 서울 열린데이터 광장 인증키 (일반 인증키 - Decoding Key 권장)
    private final String SEOUL_API_KEY = "6359554a4a6a796f36345144675264";

    public JobPostingDto getJobPosting(String companyName) {
        try {
            // 1. URL 만들기 (서울시 API는 슬래시 '/'로 구분합니다)
            // 형식: http://openapi.seoul.go.kr:8088/{KEY}/{TYPE}/{SERVICE}/{START}/{END}
            // 일단 최신 공고 100개를 가져와서 그 안에 기업이 있는지 찾습니다.
            String urlStr = "http://openapi.seoul.go.kr:8088/"
                    + SEOUL_API_KEY + "/json/GetJobInfo/1/100/";

            URI uri = URI.create(urlStr);

            System.out.println("====== [DEBUG] 요청 URL: " + uri.toString());

            // 2. API 호출
            String response = restTemplate.getForObject(uri, String.class);

            // 3. JSON 파싱 및 기업 찾기 (핵심 로직)
            JsonNode root = objectMapper.readTree(response);
            JsonNode rows = root.path("GetJobInfo").path("row"); // 공고 리스트

            for (JsonNode row : rows) {
                // API에서 준 기업명 (CMPNY_NM)
                String apiCompanyName = row.path("CMPNY_NM").asText();

                // 우리가 찾는 기업명이 포함되어 있는지 확인 (예: '네이버' 검색 시 '네이버클라우드'도 찾음)
                if (apiCompanyName.contains(companyName)) {

                    System.out.println("====== [DEBUG] 찾았다! 기업명: " + apiCompanyName);

                    // 4. 찾았으면 DTO에 담아서 리턴
                    JobPostingDto dto = new JobPostingDto();

                    // 명세서 보고 필드 매핑
                    dto.setTitle(row.path("JO_SJ").asText());           // JO_SJ: 구인제목
                    dto.setLocation(row.path("WORK_PARAR_BASS_ADRES_CN").asText()); // 근무예정지 주소
                    dto.setDeadline(row.path("RCEPT_CLOS_NM").asText()); // RCEPT_CLOS_NM: 마감일

                    // URL은 명세서에 따로 없어서 가이드라인(GUI_LN)이 있으면 넣음 (없을 수도 있음)
                    // (서울시 데이터는 상세 URL이 없는 경우가 많아 기본값 처리)
                    String detailUrl = "http://www.seoul.go.kr";
                    dto.setUrl(detailUrl);

                    return dto;
                }
            }

            // 5. 100개 뒤져봤는데 없으면? (없다고 표시)
            System.out.println("====== [DEBUG] 해당 기업의 공고가 없습니다: " + companyName);
            return null;

        } catch (Exception e) {
            System.out.println("====== [ERROR] API 호출 실패: " + e.getMessage());
            return null;
        }
    }
}