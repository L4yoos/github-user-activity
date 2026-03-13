package pl.l4yoos.github.formatter;

import pl.l4yoos.github.models.GithubEvent;

public class EventFormatter {
    public static String format(GithubEvent event) {
        switch (event.getType()) {
            case "CreateEvent":
                return String.format("- Created new Repo %s", event.getRepo().getName());
            case "DeleteEvent":
                return String.format("- Deleted Repo %s", event.getRepo().getName());
            case "DiscussionEvent":
                return String.format("- Created discussion in Repo %s", event.getRepo().getName());
            case "ForkEvent":
                return String.format("- Created fork in Repo %s", event.getRepo().getName());
            case "GollumEvent":
                return String.format("- Created or Updated wiki in Repo %s", event.getRepo().getName());
            case "IssueCommentEvent":
                return String.format("- Comment issue, or pull request in Repo %s", event.getRepo().getName());
            case "IssuesEvent":
                return String.format("- Opened a new issue in %s", event.getRepo().getName());
            case "MemberEvent":
                return String.format("- Activity in Repo %s", event.getRepo().getName());
            case "PublicEvent":
                return String.format("- Make private to public Repo %s", event.getRepo().getName());
            case "PullRequestEvent":
                return String.format("- Pull request in Repo %s", event.getRepo().getName());
            case "PullRequestReviewEvent":
                return String.format("- Review pull request in Repo %s", event.getRepo().getName());
            case "PullRequestReviewCommentEvent":
                return String.format("- Comment at review pull request in Repo %s", event.getRepo().getName());
            case "PushEvent":
                return String.format("- Pushed changes to Repo %s", event.getRepo().getName());
            case "ReleaseEvent":
                return String.format("- Release in Repo %s", event.getRepo().getName());
            case "WatchEvent":
                return String.format("- Starred %s", event.getRepo().getName());
            default:
                return String.format("- Unknown event: %s", event.getRepo().getName());
        }
    }
}
