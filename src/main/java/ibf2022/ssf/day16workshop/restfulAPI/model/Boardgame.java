package ibf2022.ssf.day16workshop.restfulAPI.model;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("boardgame")
public class Boardgame implements Serializable {

    private Integer id;
    private Integer count;

    public Integer getId() {return this.id;}

    public void setId(Integer id) {this.id = id;}

    public Integer getCount() {return this.count;}

    public void setCount(Integer count) {this.count = count;}

    
}
