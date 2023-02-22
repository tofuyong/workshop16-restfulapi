package ibf2022.ssf.day16workshop.restfulAPI.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import ibf2022.ssf.day16workshop.restfulAPI.model.Payload;

import org.springframework.data.redis.core.RedisTemplate;

@Repository
public class PayloadRepo {

    public static final String HASH_KEY_NAME = "Payload_Item";

    @Autowired
    private RedisTemplate redisTemplate; 

    //Method to save payload to Redis (Create)
    public Payload save(Payload payload) {
        //It is also possible to use opsForValue which offer different functionalities
        redisTemplate.opsForHash().put(HASH_KEY_NAME, payload.getId(), payload);
        return payload;
    }

    //Read
    public List<Payload> findAll() {
        return redisTemplate.opsForHash().values(HASH_KEY_NAME);
    }

    //Read
    public Payload findPayloadById(Integer id) {
        return (Payload) redisTemplate.opsForHash().get(HASH_KEY_NAME, id);
    }

    //Delete (it is ok to have void method but it is not good practice as we want to get feedback that operation is performed)
    public String deletePayloadById(Integer id) {
        Long lResult = redisTemplate.opsForHash().delete(HASH_KEY_NAME, id);

        if (lResult >= 0) {
            return "Deleted";
        } else {
            return "Failed";
        }
    }


    
}
