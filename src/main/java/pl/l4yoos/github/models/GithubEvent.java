package pl.l4yoos.github.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubEvent {
    private String type;
    private Repo repo;

    public String getType() { return type; }
    public Repo getRepo() { return repo; }

    public void setType(String type) { this.type = type; }
    public void setRepo(Repo repo) { this.repo = repo; }
}
