import org.code.theater.*;
import org.code.media.*;

public class interest extends Scene {

  /** Instance Variables */
  private ImageFilter [][] images;
  private String[][] captions;
  
  /** Constructor */
  public interest(ImageFilter[][] images, String [][] captions) {
    this.images = images;
    this.captions = captions;
  }

  /**
   * Top-level drawScene method which will draw the whole animation
   */
  public void drawScene() {
    drawInterest();
  }

/*
 *sets up the largest caption at the end of my personal narrative, divides it and returns the 2D array for the caption
 */
  public String[][] setUpBigCaption(){
    String[][] intro = {
      {"A sport ", "I also do "},
      {"is track!", " "},
    };
    return intro;
  }

/*
 *iterates through the 2D array for the long caption, returns the actual content of the array
 */
  public String introText(String[][] intro){
    String text = "";
    for(int r = 0; r < intro.length; r++){
      for(int c = 0; c < intro[0].length; c++){
        text+= intro[r][c];
      }
    }

    return text;
  }

/*
 *This draws the soccer image and the caption
 *This also draws the track image and its caption
 *For the soccer image, it will have the colorize filter
 *For track it will have the makeNegative filter
 */
  public void drawInterest() {
    playSound("music.wav"); //plays the music
    setTextStyle(Font.SERIF, FontStyle.BOLD);
    clear("navy");
    drawImage(images[1][0], 50, 50, 300); //drawing image
    pause(1);
    images[1][0].colorize(); //added colorize filter
    drawImage(images[1][0], 50, 50, 300);
    pause(1);
    setFillColor("beige"); //text box
    drawRectangle(30, 290, 335, 70);
    setTextColor("black");
    setTextHeight(30);
    drawText(captions[1][0], 40, 335); //caption
    pause(3);

    //next image, track
    clear("navy");
    drawImage(images[1][1], 50, 50, 300);
    pause(1);
    images[1][1].blueTint(50); //adds blue tint filter (this is the one I made myself)
    drawImage(images[1][1], 50, 50, 300);
    pause(1);
    setFillColor("beige"); //the te4xtbox
    drawRectangle(30, 290, 335, 70);
    setTextColor("black");
    setTextHeight(23);
    String[][] information = setUpBigCaption(); //calls the method that iterates through the array for my large caption
    drawText(introText(information), 50, 335); //prints out the 2D array's content to formulate the caption smoothly
    pause(3);
  }
}