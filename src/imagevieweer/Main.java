package imagevieweer;

import imagevieweer.control.NextImageCommand;
import imagevieweer.control.PrevImageCommand;
import imagevieweer.persistence.ImageLoader;
import imagevieweer.persistence.implementation.FileImageLoader;

public class Main {

    public static void main(String[] args) {
        ImageLoader imageloader = new FileImageLoader("C:/Users/nelson/Desktop/Imagen");
        MainFrame mainFrame = new MainFrame();
        mainFrame.add(new NextImageCommand(mainFrame.getImageDisplay()));
        mainFrame.add(new PrevImageCommand(mainFrame.getImageDisplay()));
        mainFrame.getImageDisplay().display(imageloader.load());
        
    }

   
    
}
