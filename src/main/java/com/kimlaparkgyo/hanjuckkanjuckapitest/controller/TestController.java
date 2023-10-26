package com.kimlaparkgyo.hanjuckkanjuckapitest.controller;

import com.kimlaparkgyo.hanjuckkanjuckapitest.dto.LocationRequest;
import com.kimlaparkgyo.hanjuckkanjuckapitest.service.ApiService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
@Slf4j
public class TestController {

    private final ApiService apiService;

    /**
     * 데이터 제공 가능 장소 전체 조회
     */
    @GetMapping("/puzzle/place/meta/pois")
    public Mono<String> getPois() {
        return apiService.getPois();
    }

    /**
     * 데이터 제공 가능 상권 전체 조회
     */
    @GetMapping("/puzzle/place/meta/areas")
    public Mono<String> getAreas() {
        return apiService.getArea();
    }

    /**
     * 실시간 장소 혼잡도
     * poiId가 있고, 위도 경도값도 같이 요청에 담았을 경우 poiId에 해당하는 장소의 혼잡도와 위도경도에 해당하는 위치의 혼잡도를 같이 보여줌
     * poiId가 없을때는 위도경도에 해당하는 위치의 혼잡도만 보여줌
     * 위도경도값이 없을때는 poiId에 해당하는 장소의 혼잡도만 보여줌
     */
    @GetMapping("/puzzle/place/meta/pois/{poiId}")
    public Mono<String> getPoisCongestion(@PathVariable String poiId, LocationRequest request) {

        return apiService.getRealtimePoisCongestion(poiId, request);
    }

}
