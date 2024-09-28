package com.htd.sample;

/**
 * Project: retrofit-root
 * Create By: Chen.F.X
 * DateTime: 2024-09-28 16:31
 * <p>
 * Desc:
 */
public class Repository {
    public int id;
    public String name;
    public String html_url;

    public Repository(int id, String name, String html_url) {
        this.id = id;
        this.name = name;
        this.html_url = html_url;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    @Override
    public String toString() {
        return "Repository{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", html_url='" + html_url + '\'' +
                '}';
    }
}
