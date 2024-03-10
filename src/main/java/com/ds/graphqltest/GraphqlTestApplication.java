package com.ds.graphqltest;

import com.ds.graphqltest.bean.Player;
import com.ds.graphqltest.bean.Team;
import com.ds.graphqltest.service.PlayerService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class GraphqlTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphqlTestApplication.class, args);
    }
}
