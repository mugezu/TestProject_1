package test;

/**
 * Created by Роман on 07.06.2017.
 */
public class Model {
    private int albumId;
    private int id;
    private String title;
    private String url;
    private String thumbnailUrl;

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    @Override
    public String toString() {
        return "test.Model{" +
                "albumId=" + albumId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Model model = (Model) o;

        if (albumId != model.albumId) return false;
        if (id != model.id) return false;
        if (title != null ? !title.equals(model.title) : model.title != null) return false;
        if (url != null ? !url.equals(model.url) : model.url != null) return false;
        return thumbnailUrl != null ? thumbnailUrl.equals(model.thumbnailUrl) : model.thumbnailUrl == null;
    }

    @Override
    public int hashCode() {
        int result = albumId;
        result = 31 * result + id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (thumbnailUrl != null ? thumbnailUrl.hashCode() : 0);
        return result;
    }
}
