import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner {
  public static void main(String[] args) {

  // Create any 2D arrays & variables to be passed as parameters to constructor
  ImageFilter[][] images = {{ new ImageFilter("fam.JPG"), new ImageFilter("friends.JPG") }, //fam and friends
                            { new ImageFilter("soccer.jpg"), new ImageFilter("track.jpg")}, //my sports
                            { new ImageFilter("friedrice.jpg"), new ImageFilter("mango.png")}}; //favorite foods

/*
 *2D array for the captions of the images
 *Each caption matches with each picture
 */
  String [][] captions = {{"This is my family", "These are my friends"}, //my friends and family
                          {"I play soccer", "I also do track"}, //my sports
                          { "And not to forget, I love fried rice", "And mangos!"}}; //my fav foods
    
    // Instantiate Scene subclass objects
    me scene1 = new me(images, captions);
    interest scene2 = new interest(images, captions);
    food scene3 = new food (images,captions);
    
    // Call drawScene methods in each subclass
    scene1.drawScene();
    scene2.drawScene();
    scene3.drawScene();
    
    // Play scenes in Theater, in order of arguments
    Theater.playScenes(scene1, scene2, scene3);
    
  }
}