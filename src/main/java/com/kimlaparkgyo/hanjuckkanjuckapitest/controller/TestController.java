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
     */
    @GetMapping("/puzzle/place/meta/pois/{poiId}")
    public Mono<String> getPoisCongestion(@PathVariable String poiId, LocationRequest request) {

        return apiService.getRealtimePoisCongestion(poiId, request);
    }

}
