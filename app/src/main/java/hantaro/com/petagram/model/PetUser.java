package hantaro.com.petagram.model;

public class PetUser {

    private String id;
    private int likes;
    private String name;
    private String imageUrl;

    public PetUser() {

    }

    public PetUser(String id, int likes, String name, String imageUrl) {
        this.id = id;
        this.likes = likes;
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
