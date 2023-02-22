package ibf2022.ssf.day16workshop.restfulAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ibf2022.ssf.day16workshop.restfulAPI.model.Boardgame;
import ibf2022.ssf.day16workshop.restfulAPI.repository.BoardgameRepo;

@RestController
@RequestMapping("/api/boardgame")
public class BoardgameController {
    
    @Autowired
    BoardgameRepo bgRepo;

    @PostMapping
    public ResponseEntity<Boardgame> save(@RequestBody Boardgame boardgame){
        Boardgame bg = bgRepo.save(boardgame);
        return new ResponseEntity<Boardgame>(bg, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Boardgame> findById(@PathVariable Integer id){
        Boardgame bg = bgRepo.findBoardgameById(id);
        return new ResponseEntity<Boardgame>(bg, HttpStatus.OK);
    }

    //Task 3
    @PutMapping
    public ResponseEntity<Boardgame> update(@RequestBody Boardgame boardgame) {
        Boardgame bg = bgRepo.update(boardgame);
        return new ResponseEntity<Boardgame>(bg, HttpStatus.OK);
    }
}
