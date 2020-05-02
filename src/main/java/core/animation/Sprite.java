package core.animation;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

public class Sprite {

    private static BufferedImage spriteSheet;
    private static final int TILE_WIDTH = 104;
    private static final int TILE_HEIGHT = 190;

    public static BufferedImage loadSprite() {

        BufferedImage sprite = null;

        try {
            sprite = ImageIO.read(new File("C:\\Users\\kevin\\Google Drive\\proyectos\\hilosu3\\src\\main\\resources\\DonJoaquin.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sprite;
    }

    public static BufferedImage getSprite(int xGrid, int yGrid) {

        if (spriteSheet == null) {
            spriteSheet = loadSprite();
        }

        return spriteSheet.getSubimage(xGrid * TILE_WIDTH+(xGrid +1), yGrid * TILE_HEIGHT+yGrid+1, TILE_WIDTH, TILE_HEIGHT);
    }
    public static BufferedImage getSprite(int xGrid, int yGrid,boolean transparency) {
        BufferedImage sprite = getSprite(xGrid,yGrid);
        int color = sprite.getRGB(5, 5);

        Image image = makeColorTransparent(sprite, new Color(color));

        return imageToBufferedImage(image);
    }
    private static BufferedImage imageToBufferedImage(Image image) {

        BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = bufferedImage.createGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();

        return bufferedImage;

    }
    public static Image makeColorTransparent(BufferedImage im, final Color color) {
        ImageFilter filter = new RGBImageFilter() {

            public final int markerRGB = color.getRGB() | 0xFF000000;

            public final int filterRGB(int x, int y, int rgb) {
                if ((rgb | 0xFF000000) == markerRGB) {
                    return 0x00FFFFFF & rgb;
                } else {
                    return rgb;
                }
            }
        };

        ImageProducer ip = new FilteredImageSource(im.getSource(), filter);
        return Toolkit.getDefaultToolkit().createImage(ip);
    }

    public static BufferedImage[] getRow(int yGrid,int rowSize){
        BufferedImage[] row = new BufferedImage[rowSize];
        for (int i = 0; i < rowSize; i++) {
            row[i] = getSprite(i,yGrid,true);
        }
        return row;
    }

    public static int getTileWidth() {
        return TILE_WIDTH;
    }

    public static int getTileHeight() {
        return TILE_HEIGHT;
    }
}
