package abhishekint.com.mapprrgithub.app.Home.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RepoSearchModel {
    @SerializedName("items")
    private List<InnerItem> items;

    public List<InnerItem> getItems() {
        return items;
    }

    public void setItems(List<InnerItem> items) {
        this.items = items;
    }

    public class InnerItem{
        @SerializedName("name")
        private String name;
        @SerializedName("full_name")
        private String full_name;
        @SerializedName("html_url")
        private String html_url;
        @SerializedName("owner")
        private InnerOwner owner;
        @SerializedName("forks_count")
        private String forks_count;
        @SerializedName("watchers_count")
        private Integer watchers_count;
        @SerializedName("stargazers_count")
        private Integer stargazers_count;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFull_name() {
            return full_name;
        }

        public void setFull_name(String full_name) {
            this.full_name = full_name;
        }

        public String getHtml_url() {
            return html_url;
        }

        public void setHtml_url(String html_url) {
            this.html_url = html_url;
        }

        public InnerOwner getOwner() {
            return owner;
        }

        public void setOwner(InnerOwner owner) {
            this.owner = owner;
        }

        public String getForks_count() {
            return forks_count;
        }

        public void setForks_count(String forks_count) {
            this.forks_count = forks_count;
        }

        public Integer getWatchers_count() {
            return watchers_count;
        }

        public void setWatchers_count(Integer watchers_count) {
            this.watchers_count = watchers_count;
        }

        public Integer getStargazers_count() {
            return stargazers_count;
        }

        public void setStargazers_count(Integer stargazers_count) {
            this.stargazers_count = stargazers_count;
        }

        public class InnerOwner
        {
            @SerializedName("avatar_url")
            private String avatar_url;

            public String getAvatar_url() {
                return avatar_url;
            }

            public void setAvatar_url(String avatar_url) {
                this.avatar_url = avatar_url;
            }
        }
    }
}
