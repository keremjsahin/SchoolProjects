/*************************************************************************
 *  Compilation:  javac ArtCollage.java
 *  Execution:    java ArtCollage
 *
 *  @author: Kerem Sahin 
 *
 *************************************************************************/

import java.awt.Color;

public class ArtCollage {

    private Picture original;

    private Picture collage;

    private int collageDimension;

    private int tileDimension;
    
    public ArtCollage (String filename) {

	   collageDimension = 4;
       tileDimension = 100;
       original = new Picture(filename);
       collage = new Picture(tileDimension * collageDimension, tileDimension * collageDimension);
       for(int c = 0; c < 400; c++){
        for(int r = 0; r < 400; r++){
            int dc = c * original.width() / 400;
            int dr = r * original.height() / 400;
            Color color = original.get(dc, dr);
            this.collage.set(c, r, color);
        }
       }
    }

    public ArtCollage (String filename, int td, int cd) {

	   tileDimension = td;
       collageDimension = cd;
       original = new Picture(filename);
       collage = new Picture(td * cd, td * cd);
       for(int c = 0; c < td * cd; c++){
        for(int r = 0;  r < td * cd; r++){
            int dc = c * original.width() / (td * cd);
            int dr = r * original.height() / (td * cd);
            Color color = original.get(dc, dr);
            this.collage.set(c, r, color);
        }
       }
    }

    public int getCollageDimension() {

	return collageDimension;
    }

    public int getTileDimension() {
	
    return tileDimension;
    }

    public Picture getOriginalPicture() {

	return original;
    }

    public Picture getCollagePicture() {

	return collage;
    }

    public void showOriginalPicture() {
        getOriginalPicture().show();
	
    }

    public void showCollagePicture() {

	   getCollagePicture().show();
    }

    public void replaceTile (String filename,  int collageCol, int collageRow) {

	   Picture aff = new Picture(filename);
       Picture large = new Picture(tileDimension, tileDimension);

       for(int col = 0; col < tileDimension; col++){
        for(int row = 0; row < tileDimension; row++){
            int dc = col * aff.width() / tileDimension;
            int dr = row  * aff.height() / tileDimension;
            Color color = aff.get(dc, dr);
            large.set(col, row, color);
        }
       }
       aff = large;

       for(int c = 0; c < tileDimension; c++){
        for(int r = 0; r < tileDimension; r++){
            Color color = aff.get(c, r);
            for(int i = collageCol; i  < collageCol + 1; i++){
                for(int j = collageRow; j < collageRow + 1; j++){
                    this.collage.set(tileDimension * i + c, tileDimension * j + r, color);
                 }
            }
        }
    }
}
    public void makeCollage () {

	int h = tileDimension;
    int w = tileDimension;
    Picture large = new Picture(w, h);

    for(int c = 0; c < tileDimension; c++){
        for(int r = 0; r < tileDimension; r++){
            int sc = c * original.width() / w;
            int sr = r * original.height() / h;
            Color color = original.get(sc, sr);
            large.set(c, r, color);
        }
    }

    int a = collageDimension;
    int b = collageDimension;

    collage = new Picture(b * large.width() , a * large.height());

    for(int col = 0; col < w; col++){
        for(int row = 0; row < h; row++){
            Color color = large.get(col, row);
                for(int i = 0; i < a; i++){
                    for(int j = 0; j < b; j++){
                        this.collage.set(h * j + col, w * i + row, color);
                 }
             }
        }
    }

 }

    public void colorizeTile (String component,  int collageCol, int collageRow) {
        Picture collagePic = getCollagePicture();
        int tiles = getTileDimension();
        for(int i = collageCol * tiles; i < tiles + (collageCol * tiles); i++){
            for(int j = collageRow * tiles; j < tiles + (collageRow * tiles); j++){
                Color color = collagePic.get(i, j);
                int counter = 0;
                if(component.equals("green")){
                    counter = color.getBlue();
                    collagePic.set(i, j, new Color(0, counter, 0));
                }
                if(component.equals("blue")){
                    counter = color.getBlue();
                    collagePic.set(i, j, new Color(0, 0, counter));
                }
                if(component.equals("red")){
                    counter = color.getRed();
                    collagePic.set(i, j, new Color(counter, 0, 0));
                }
            }
        }
        collage = collagePic;
	   
    }

    public void greyscaleTile (int collageCol, int collageRow) {

	Picture collagePic = getCollagePicture();
    int tile = getTileDimension(); 
    for(int i = (collageCol * tile); i < (tile + (collageCol * tile)); i++){
        for(int j = (collageRow * tile); j < (tile + (collageRow * tile)); j++){
            Color color = collagePic.get(i , j);
            Color gray = Luminance.toGray(color);
            collagePic.set(i, j, gray);
        }
    }
   
   collage = collagePic;
    
} 
    public static void main (String[] args) {
        ArtCollage art = new ArtCollage("Ariel.jpg", 200, 4);
        art.makeCollage();
        art.greyscaleTile(2,1); 
        art.colorizeTile("red", 0, 0);
        art.replaceTile("Flo.jpg", 1, 1);   }
} 

