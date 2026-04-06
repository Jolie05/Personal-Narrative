import org.code.theater.*;
import org.code.media.*;
// adjustContrast
//   threshold
public class food extends Scene {

  //Instance Variables
  private ImageFilter [][] images;
  private String[][] captions;
  
  //Constructor
  public food(ImageFilter[][] images, String [][] captions) {
    this.images = images;
    this.captions = captions;
  }

/*
 * Top-level drawScene method which will draw the whole animation
 */
  public void drawScene() {
    drawFriedRice();
    drawMango();
    drawEnding();
  }

/*
 *This creates the image and then adjusts the contrast
 *also adds the caption
 */
  public void drawFriedRice() {
    setTextStyle(Font.SERIF, FontStyle.BOLD);
    setTextHeight(20);
    clear("blue");
    drawImage(images[2][0], 50, 50, 300); //drawing image
    pause(1);
    images[2][0].adjustContrast(2); //added adjustContrast filter
    drawImage(images[2][0], 50, 50, 300);
    pause(1);
    setFillColor("beige"); //text box
    drawRectangle(30, 290, 335, 70);
    setTextColor("black");
    drawText(captions[2][0], 40, 335); //caption
    pause(3);
  }

/*
 *This draws the mango image and then adds a threshold
 *along with the caption
 */
  public void drawMango() {
    setTextStyle(Font.SERIF, FontStyle.BOLD);
    setTextHeight(30);
    clear("blue");
    drawImage(images[2][1], 50, 50, 300); //drawing image
    pause(1);
    images[2][0].threshold(200); //added threshold filter
    drawImage(images[2][1], 50, 50, 300);
    pause(1);
    setFillColor("beige"); //text box
    drawRectangle(30, 290, 335, 70);
    setTextColor("black");
    drawText(captions[2][1], 40, 335); //caption
    pause(3);
  }

/*
 *generates end screen for my personal narrative
 */
 public void drawEnding(){
    clear("aqua");
    setTextStyle(Font.SERIF, FontStyle.BOLD);
    setTextHeight(40);
    drawText("Thank You!", 100, 200);
  }
}