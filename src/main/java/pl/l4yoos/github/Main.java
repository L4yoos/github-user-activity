package pl.l4yoos.github;

import pl.l4yoos.github.formatter.EventFormatter;
import pl.l4yoos.github.models.GithubEvent;
import pl.l4yoos.github.service.GitHubService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Use: mvn exec:java -Dexec.mainClass='pl.l4yoos.github.Main' -Dexec.args='l4yoos'");
            return;
        }
        List<GithubEvent> events = GitHubService.fetch(args[0]);

        System.out.println("Output:");
        for (GithubEvent event : events) {
            System.out.println(EventFormatter.format(event));
        }
    }
}

