package com.practical.jwt.dao;

import com.practical.jwt.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class UserDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    public User saveUser(User user) throws Exception {
        if(Objects.nonNull(fetchUser(user.getUserName()))){
            throw new Exception("User already exists, try other name");
        }
        return mongoTemplate.save(user);
    }

    public User fetchUser(String userName) {
        var query = new Query();
        var criteria = Criteria.where("userName").is(userName);
        query.addCriteria(criteria);
        return mongoTemplate.findOne(query, User.class);
    }
}
