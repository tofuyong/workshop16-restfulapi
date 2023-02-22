package ibf2022.ssf.day16workshop.restfulAPI.repository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import ibf2022.ssf.day16workshop.restfulAPI.model.Boardgame;

@Repository
public class BoardgameRepo {
    public static final String HASH_KEY_NAME = "Boardgame_Item";

    @Autowired
    private RedisTemplate redisTemplate; 

    public Boardgame save(Boardgame boardgame) {
        redisTemplate.opsForValue().set(boardgame.getId(), boardgame);

        return boardgame;
    }

    public Boardgame findBoardgameById(Integer id) {
        Boardgame bg = (Boardgame) redisTemplate.opsForValue().get(id);
        return bg;
    }

    public Boardgame update(Boardgame boardgame) {
        redisTemplate.opsForValue().setIfPresent(boardgame.getId(), boardgame);
        return boardgame;
    }

    // public List<Boardgame> findBoardGames() {
    //     redisTemplate.opsForValue().get()
    // }

}
