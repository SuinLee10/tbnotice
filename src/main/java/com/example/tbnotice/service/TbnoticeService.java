package com.example.tbnotice.service;

import java.util.Map;

public interface TbnoticeService {
    public Map<String, Object> create(Map<String, Object> param);
    public Map<String, Object> update(Map<String, Object> param);
    public Map<String, Object> delete(String id);
    public Map<String, Object> detail(String id);
    public Map<String, Object> list();
}
