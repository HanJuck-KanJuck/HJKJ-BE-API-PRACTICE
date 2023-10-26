package com.kimlaparkgyo.hanjuckkanjuckapitest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class LocationRequest {
    // 위도값
    private float lat;
    // 경도값
    private float lng;
}
