package com.example.shellproject.commands;

import com.example.shellproject.model.Event;
import com.example.shellproject.model.dto.EventDTO;
import com.example.shellproject.model.mapper.EventMapper;
import com.example.shellproject.service.EventService;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.Option;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Objects;

@ShellComponent
@Command(group = "github")
public class GitHubCommands {

    private final EventService service;
    private final WebClient  webClient;
    private final String URL_BASE = "https://api.github.com/users/%s/events";

    public GitHubCommands(WebClient.Builder webClientBuilder, EventService service) {
        this.webClient = webClientBuilder.build();
        this.service = service;
    }

    @Command(command = "github-activity")
    public void githubActivity(@Option(required = true, description = "github username") String user){
        String url = String.format(URL_BASE, user);
        try {
             service.transFromDTO(Objects.requireNonNull(webClient
                    .get()
                    .uri(url)
                    .retrieve()
                    .bodyToFlux(Event.class)
                    .map(EventMapper::toDTO)
                    .collectList()
                    .block())).forEach(System.out::println);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
