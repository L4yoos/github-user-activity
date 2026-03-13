package pl.l4yoos.github.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Repo {
    private int id;
    private String name;
    private String url;

    public int getId() { return id; }
    public String getName() { return name; }
    public String getUrl() { return url; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setUrl(String url) { this.url = url; }
}
