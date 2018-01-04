package imagevieweer.model;

public interface Image {
    byte[] bitmap();

    Image next();
    Image prev();
    int getIndex();
}
