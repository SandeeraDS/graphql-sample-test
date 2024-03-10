package com.ds.graphqltest.service;

import com.ds.graphqltest.bean.Player;
import com.ds.graphqltest.bean.Team;
import com.ds.graphqltest.model.PlayerModel;
import com.ds.graphqltest.repository.PlayerRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @PostConstruct
    public void addInitialTestData() {
        List<Player> playerModelList = new ArrayList<>();
        playerModelList.add(new Player(0, "Sanath Jayasuriya", Team.MI));
        playerModelList.add(new Player(0, "Mahendrasign Dhoni", Team.CSK));
        playerModelList.add(new Player(0, "Virat Kholi", Team.RCB));
        this.playerRepository.saveAll(playerModelList);
    }

    @Transactional
    public Player getPlayerById(int id) {
        return playerRepository.getReferenceById(id);
    }

    @Transactional
    public List<PlayerModel> findAll() {
        List<Player> playerList = this.playerRepository.findAll();
        List<PlayerModel> list = new ArrayList<>();
        for (Player player : playerList) {
            PlayerModel playerModel = new PlayerModel(player.getId(), player.getName(), player.getTeam());
            list.add(playerModel);
        }
        return list;
    }

    @Transactional
    public Optional<PlayerModel> findById(int id) {
        try {
            Player player = this.playerRepository.getReferenceById(id);
            return Optional.of(new PlayerModel(player.getId(), player.getName(), player.getTeam()));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Transactional
    public Optional<PlayerModel> createPlayer(String name, Team team) {
        try {
            Player player = new Player(0, name, team);
            this.playerRepository.save(player);
            return Optional.of(new PlayerModel(player.getId(), player.getName(), player.getTeam()));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Transactional
    public Optional<PlayerModel> updatePlayerTeam(int id, Team team) {
        try {
            Player player = this.playerRepository.getReferenceById(id);
            player.setTeam(team);
            return Optional.of(new PlayerModel(player.getId(), player.getName(), player.getTeam()));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Transactional
    public String deletePlayer(int id) {
        try {
            this.playerRepository.deleteById(id);
            return "1";
        } catch (Exception e) {
            return "-1";
        }
    }
}
