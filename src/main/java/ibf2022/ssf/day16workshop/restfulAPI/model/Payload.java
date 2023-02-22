package ibf2022.ssf.day16workshop.restfulAPI.model;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;


@RedisHash("payload")
public class Payload implements Serializable{

    private Integer id;
    private String itemName;

    public Integer getId() {return this.id;}

    public void setId(Integer id) {this.id = id;}

    public String getItemName() {return this.itemName;}

    public void setItemName(String itemName) {this.itemName = itemName;}


}
