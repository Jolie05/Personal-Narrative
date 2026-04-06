import org.code.theater.*;
import org.code.media.*;

public class me extends Scene {

  // Instance Variables
  private ImageFilter [][] images;
  private String[][] captions;
  
  //Constructor
  public me(ImageFilter[][] images, String [][] captions) {
    this.images = images;
    this.captions = captions;
  }

  /*
   * Top-level drawScene method which will draw the whole animation
   */
  public void drawScene() {
    drawTitle();
    drawFamily();
    drawFriends();
  }

  /*
   * Returns the first caption in each row, if there is no caption, then it returns "no caption".
   *
   * Precondition: Row value must be inputted into the method for it to work.
   * Postcondition: The method returns "No Caption" if the if-statement nested in the for loop returns false.
   * 
   * @param		row        the parameter is used to iterate through the captions array to get the first caption in the list.
   * @return	if the current index of the pcations list is not null and it isn't blank, then the method will return that current index of the captions list.
   */

  public String getFirstCaption(int row) {
    for (int c = 0; c < captions[row].length; c++) {
      if (captions[row][c] != null && !captions[row][c].equals("")) {
          return captions[row][c]; 
      }
    }
    return "No caption";
  }
  
/*
 *This draw the title screen or the start
 *to my narrative
 */
  public void drawTitle() {
    clear("aqua");
    setTextStyle(Font.SERIF, FontStyle.BOLD); //title formatting
    setTextHeight(50);
    setTextColor("Black");
    drawText("My Personal", 60, 150);
    drawText("Narrative", 90, 250);
    pause(3);
  }

/*
 *This is to first draw my family
 *It draws the image without the filter
 *then applies the filter to it
 *I decided to use the sepia filter on it
 */
  public void drawFamily() {
    clear("blue"); //clearing canvas
    drawImage(images[0][0], 50, 50, 300); //drawing the image
    setFillColor("beige"); //text box
    drawRectangle(50, 270, 300, 70);
    setTextColor("black"); 
    setTextHeight(30);
    drawText(captions[0][0], 60, 320); //the caption
    pause(1); 
    images[0][0].applySepia(); //added applySepia() filter
    drawImage(images[0][0], 50, 50, 300);
    pause(3);
  }

/*
 *This draws my friends and then applies the colorshift filter
 *it also draws its captions
 */
  public void drawFriends() {
    clear("blue");
    drawImage(images[0][1], 50, 50, 300); //drawing image
    pause(1);
    images[0][1].colorShift(50); //added colorShift filter
    drawImage(images[0][1], 50, 50, 300);
    pause(1);
    setFillColor("beige"); //text box
    drawRectangle(30, 290, 335, 70);
    setTextColor("black");
    setTextHeight(30);
    drawText(captions[0][1], 40, 335); //the caption
    pause(3);
  }
  
}