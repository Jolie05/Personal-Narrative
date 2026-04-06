import org.code.theater.*;
import org.code.media.*;

/*
 * Represents a image that has multiple filters
 */
public class ImageFilter extends ImagePlus {

/*
 * Calls the super class constructor to initalized the 2D array
 */
  public ImageFilter (String filename){
    super(filename);
  }

/*
 * Lesson 8 image filters
 */
    
/*
 * Shifts the color of each Pixel object by a fixed amount
 */
 public void colorShift(int value) {  
  Pixel [][] pixels = getPixelsFromImage();
    for(int row = 0; row<pixels.length; row++){
      for (int col = 0; col < pixels[0].length; col++){
        Pixel currentPixel = pixels[row][col];

        int red = currentPixel.getRed();
        int green = currentPixel.getGreen();
        int blue = currentPixel.getBlue();

        int newRed = (int)(value + red);
        int newGreen = (int)(value + green);
        int newBlue = (int)(value + blue);

        if (newRed > 255) {
          newRed = 255;
        }
        if (newGreen > 255) {
          newGreen = 255;
        }
        if (newBlue > 255) {
          newBlue = 255;
        }
        
        if (newRed < 0) {
          newRed = 0;
        }
        if (newGreen < 0) {
          newGreen = 0;
        }
        if (newBlue < 0) {
          newBlue = 0;
        }

        currentPixel.setRed(newRed);
        currentPixel.setGreen(newGreen);
        currentPixel.setBlue(newBlue);
      }
    }
 }

/*
 * Applies a colorize filter by converting each Pixel to grayscale and applying
 * a color to it based on its grayscale value
 */
 public void colorize() {  

  Pixel[][] pixels = getPixelsFromImage();

   for (int row = 0; row < pixels.length; row++) {
    for (int col = 0; col < pixels[0].length; col++) {
      Pixel currentPixel = pixels[row][col];

    int currentRed = currentPixel.getRed();
    int currentGreen = currentPixel.getGreen();
    int currentBlue = currentPixel.getBlue();

    int pixelColorAverage = (currentRed + currentGreen + currentBlue) / 3; //finds average of the current RGB values
     
     if (pixelColorAverage < 85) {
      currentPixel.setRed(255);
      currentPixel.setGreen(0);
      currentPixel.setBlue(0);
    }
    else if (pixelColorAverage < 170) {
      currentPixel.setRed(0);
      currentPixel.setGreen(255);
      currentPixel.setBlue(0);
    }
    else {
      currentPixel.setRed(0);
      currentPixel.setGreen(0);
      currentPixel.setBlue(255);
    }

    }
  }
}

/*
 * Adjusts the contrast of the image by multiplying the
 * red, green, and blue values by the multiplier
 */
    public void adjustContrast(int multiplier) {  
    Pixel[][] pixels = this.getImagePixels();

    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[row].length; col++) {
        Pixel p = pixels[row][col];

        int newRed = Math.min(255, p.getRed() * multiplier);
        int newGreen = Math.min(255, p.getGreen() * multiplier);
        int newBlue = Math.min(255, p.getBlue() * multiplier);

        p.setRed(newRed);
        p.setGreen(newGreen);
        p.setBlue(newBlue);
      }
    }
  }

/*
 * Applies a sepia filter by calculating new red, green, and blue color
 * values based on sepia tone formulas and setting the Pixel object to the result
 */
  public void applySepia() {  
    Pixel[][] pixels = getImagePixels();
  
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
        Pixel currentPixel = pixels[row][col];

        int red = currentPixel.getRed();
        int green = currentPixel.getGreen();
        int blue = currentPixel.getBlue();

        // use the formula from instructions to calc new RGB values
        int newRed = (int)(0.393 * red + 0.769 * green + 0.189 * blue);
        int newGreen = (int)(0.349 * red + 0.686 * green + 0.168 * blue);
        int newBlue = (int)(0.272 * red + 0.534 * green + 0.131 * blue);

        // force RBG values to not exceed 255
        if (newRed > 255) {
          newRed = 255;
        }
        if (newGreen > 255) {
          newGreen = 255;
        }
        if (newBlue > 255) {
          newBlue = 255;
        }
        
        // force RBG values to not be below 0
        if (newRed < 0) {
          newRed = 0;
        }
        if (newGreen < 0) {
          newGreen = 0;
        }
        if (newBlue < 0) {
          newBlue = 0;
        }

        // update RGB values
        currentPixel.setRed(newRed);
        currentPixel.setGreen(newGreen);
        currentPixel.setBlue(newBlue);
      }
    }
  }

/* 
 * Applies a threshold filter to an image 
 */ 
public void threshold(int value) {  
    Pixel[][] pixels = getPixelsFromImage(); 

    for (int row = 0; row < pixels.length; row++) { 
        for (int col = 0; col < pixels[0].length; col++) { 
            Pixel currentPixel = pixels[row][col]; 
            
            int currentRed = currentPixel.getRed(); 
            int currentGreen = currentPixel.getGreen(); 
            int currentBlue = currentPixel.getBlue(); 
            
            // Calculate the average (grayscale value)
            int grayScale = (currentRed + currentGreen + currentBlue) / 3; 

            if (grayScale < value) { 
                // Set to BLACK
                currentPixel.setRed(0); 
                currentPixel.setGreen(0); 
                currentPixel.setBlue(0); 
            } else { 
                // Set to WHITE
                currentPixel.setRed(255); 
                currentPixel.setGreen(255); 
                currentPixel.setBlue(255); 
            } 
        } 
    } 
}

/*
 *This applies a blue tint to the whole picture
 */
public void blueTint(int intensity) {  
  Pixel[][] pixels = getPixelsFromImage();

  for (int r = 0; r < pixels.length; r++) {
    for (int c = 0; c < pixels[r].length; c++) {
      Pixel p = pixels[r][c];

      int newBlue = p.getBlue() + intensity;
      if (newBlue > 255){ //makes sure that it doesn't go out of bounds
        newBlue = 255; 
      }
      p.setBlue(newBlue);
    }
  }
}
  
}