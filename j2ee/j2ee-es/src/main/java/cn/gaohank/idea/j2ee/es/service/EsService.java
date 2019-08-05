package cn.gaohank.idea.j2ee.es.service;

import java.util.List;

public interface EsService {
    List<String> search(String text, String fieldName) throws Exception;
}
