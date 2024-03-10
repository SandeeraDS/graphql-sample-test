package com.ds.graphqltest.model;

import com.ds.graphqltest.bean.Team;

public record PlayerModel(int id, String name, Team team) {
}
