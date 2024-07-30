package com.example.tbnotice.mapper;

import com.example.tbnotice.dto.CommonDto;

import java.util.List;
import java.util.Map;

public interface TbnoticeMapper {
    CommonDto.TbnoticeDetailResDto detail(String id);
    List<Map<String, Object>> list(Map<String, Object> param);

}
