package com.example.tbnotice.service.impl;

import com.example.tbnotice.domain.Tbnotice;
import com.example.tbnotice.dto.CommonDto;
import com.example.tbnotice.mapper.TbnoticeMapper;
import com.example.tbnotice.repository.TbnoticeRepository;
import com.example.tbnotice.service.TbnoticeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TbnoticeServiceImpl implements TbnoticeService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final TbnoticeRepository tbnoticeRepository;
    private final TbnoticeMapper tbnoticeMapper;

    public TbnoticeServiceImpl(
            TbnoticeRepository tbnoticeRepository
            ,TbnoticeMapper tbnoticeMapper
    ){
        this.tbnoticeRepository = tbnoticeRepository;
        this.tbnoticeMapper = tbnoticeMapper;
    }
    public Map<String, Object> create(Map<String, Object> param){
        Map<String, Object> returnVal = new HashMap<>();
        Tbnotice tbnotice = Tbnotice.of(param.get("title") + "", param.get("cate") + "", param.get("content") + "");
        tbnoticeRepository.save(tbnotice);
        returnVal.put("resultCode", 200);
        return returnVal;
    }
    public Map<String, Object> update(Map<String, Object>param){
        Map<String, Object> returnVal = new HashMap<>();
        int resultCode = 0;

        String id = param.get("id") + "";
        Tbnotice tbnotice = tbnoticeRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
        if(param.get("title")!= null && !"".equals(param.get("title"))){
            tbnotice.setTitle(param.get("title") + "");
            resultCode = 200;
        }
        if(param.get("cate")!= null && !"".equals(param.get("cate"))){
            tbnotice.setCate(param.get("cate") + "");
            resultCode = 200;
        }
        if(param.get("content")!= null && !"".equals(param.get("content"))){
            tbnotice.setContent(param.get("content") + "");
            resultCode = 200;
        }
        tbnoticeRepository.save(tbnotice);

        returnVal.put("resultCode", resultCode);
        return returnVal;
    }
    public Map<String, Object>delete(String id){
        Map<String, Object> returnVal = new HashMap<>();
        int resultCode = 200;

        Tbnotice tbnotice =tbnoticeRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
        tbnoticeRepository.delete(tbnotice);

        returnVal.put("resultCode", resultCode);
        return returnVal;
    }
    public Map<String, Object>detail(String id){
        Map<String, Object> returnVal = new HashMap<>();
        int resultCode = 200;

        //Tbnotice tbnotice =tbnoticeRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
        CommonDto.TbnoticeDetailResDto mapTbnotice = tbnoticeMapper.detail(id);
        //returnVal.put("resultCode", resultCode);
        returnVal.put("resultData", mapTbnotice);
        return returnVal;
    }

    public Map<String, Object> list(){
        Map<String, Object> returnVal = new HashMap<>();
        int resultCode = 200;

        //List<Tbnotice> list_tbnotice = tbnoticeRepository.findAll();
        List<Map<String, Object>> list_tbnotice1 = tbnoticeMapper.list(returnVal);
        //returnVal.put("resultCode", resultCode);
        returnVal.put("resultData", list_tbnotice1);
        return returnVal;
    }

}
