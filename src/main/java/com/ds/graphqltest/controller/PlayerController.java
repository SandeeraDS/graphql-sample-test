package com.ds.graphqltest.controller;

import com.ds.graphqltest.bean.Team;
import com.ds.graphqltest.model.PlayerModel;
import com.ds.graphqltest.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    private PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @QueryMapping
    public List<PlayerModel> findAll() {
        return this.playerService.findAll();
    }

    @QueryMapping
    public Optional<PlayerModel> findById(@Argument int id) {
        return this.playerService.findById(id);
    }

    @MutationMapping
    public Optional<PlayerModel> createPlayer(@Argument String name, @Argument Team team) {
        return this.playerService.createPlayer(name,team);
    }

    @MutationMapping
    public Optional<PlayerModel> updatePlayerTeam(@Argument int id, @Argument Team team) {
        return this.playerService.updatePlayerTeam(id,team);
    }

    @MutationMapping
    public String deletePlayer(@Argument int id) {
        return this.playerService.deletePlayer(id);
    }
}
