package cn.gaohank.idea.j2ee.es.serviceImpl;

import cn.gaohank.idea.j2ee.es.dao.EsDao;
import cn.gaohank.idea.j2ee.es.service.EsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EsServiceImpl implements EsService {
    @Autowired
    private EsDao esDao;

    @Override
    public List<String> search(String text, String fieldName) throws Exception {
        return esDao.search("portrait-dentistry", text, fieldName);
    }
}
