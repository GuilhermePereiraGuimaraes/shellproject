package com.example.shellproject.commands;

import com.example.shellproject.model.Event;
import com.example.shellproject.model.mapper.EventMapper;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.Option;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@ShellComponent
@Command(group = "github")
public class GitHubCommands {

    private final WebClient  webClient;
    private final String URL_BASE = "https://api.github.com/users/%s/events";

    public GitHubCommands(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    @Command(command = "github-activity")
    public List<?> githubActivity(@Option(required = true, description = "github username") String user){
        String url = String.format(URL_BASE, user);
        try {
            return webClient
                    .get()
                    .uri(url)
                    .retrieve()
                    .bodyToFlux(Event.class)
                    .map(EventMapper::toDTO)
                    .collectList()
                    .block();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
