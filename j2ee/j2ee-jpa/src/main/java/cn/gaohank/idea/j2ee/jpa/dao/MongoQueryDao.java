package cn.gaohank.idea.j2ee.jpa.dao;

import cn.gaohank.idea.j2ee.jpa.model.SleepMap;
import cn.gaohank.idea.j2ee.jpa.model.SleepMonitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MongoQueryDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<SleepMonitor> findAll() {
        return mongoTemplate.findAll(SleepMonitor.class);
    }

    public List<SleepMap> findMapAll() {
        return mongoTemplate.findAll(SleepMap.class);
    }
}
