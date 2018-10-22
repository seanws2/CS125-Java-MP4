package edu.illinois.cs.cs125.mp4.lib;

/**
 * Class used to do simple transformations on 2d image arrays.
 */
public class Transform {
    /**
     * fill value pixel.
     */
    private static final RGBAPixel FILL_VALUE = new RGBAPixel(255, 255, 255, 0);
    /**
     * dummy return.
     */
    private static RGBAPixel[][] dumOut = {{FILL_VALUE, FILL_VALUE, FILL_VALUE}};
    /**
     * empty constructor.
     */
    public Transform() { }
    /**
     * @param originalImage is the image we are going to shift.
     * @param amount amount to shift the image LEFT.
     * Shift image left by specified amount.
     */
    public static RGBAPixel[][] shiftLeft(final RGBAPixel[][] originalImage, final int amount) {
        int picHeight = originalImage.length;
        int picWidth = originalImage[0].length;
        RGBAPixel[][] output = new RGBAPixel[picHeight][picWidth];
        for (int i = 0; i < picHeight; i++) {
            for (int j = 0; j < picWidth - amount; j++) {
                output[i][j] = originalImage[i][j + amount];
            }
        }
        for (int i = 0; i < picHeight; i++) {
            for (int j = picWidth - amount; j < picWidth; j++) {
                output[i][j] = FILL_VALUE;
            }
        }
        return output;
    }
    /**
     * @param originalImage is the image we are going to shift.
     * @param amount amount to shift the image RIGHT.
     */
    public static RGBAPixel[][] shiftRight(final RGBAPixel[][] originalImage, final int amount) {
        int picHeight = originalImage.length;
        int picWidth = originalImage[0].length;
        RGBAPixel[][] output = new RGBAPixel[picHeight][picWidth];
        for (int i = 0; i < picHeight; i++) {
            for (int j = 0; j < picWidth - amount; j++) {
                output[i][j + amount] = originalImage[i][j];
            }
        }
        for (int i = 0; i < picHeight; i++) {
            for (int j = 0; j < picWidth - amount; j++) {
                output[i][j] = FILL_VALUE;
            }
        }
        return output;
    }
    /**
     * @param originalImage is the image we are going to shift.
     * @param amount amount to shift the image UP.
     */
    public static RGBAPixel[][] shiftUp(final RGBAPixel[][] originalImage, final int amount) {
        int picHeight = originalImage.length;
        int picWidth = originalImage[0].length;
        RGBAPixel[][] output = new RGBAPixel[picHeight][picWidth];
        for (int i = 0; i < picWidth; i++) {
            for (int j = 0; j < picHeight - amount; j++) {
                output[j][i] = originalImage[j + amount][i];
            }
        }
        for (int i = 0; i < picWidth; i++) {
            for (int j = picHeight - amount; j < picHeight; j++) {
                output[j][i] = FILL_VALUE;
            }
        }
        return output;
    }
    /**
     * @param originalImage is the image we are going to shift.
     * @param amount amount to shift the image DOWN.
     */
    public static RGBAPixel[][] shiftDown(final RGBAPixel[][] originalImage, final int amount) {
        int picHeight = originalImage.length;
        int picWidth = originalImage[0].length;
        RGBAPixel[][] output = new RGBAPixel[picHeight][picWidth];
        for (int i = 0; i < picWidth; i++) {
            for (int j = 0; j < picHeight - amount; j++) {
                output[j + amount][i] = originalImage[j][i];
            }
        }
        for (int i = 0; i < picWidth; i++) {
            for (int j = 0; j < picHeight - amount; j++) {
                output[j][i] = FILL_VALUE;
            }
        }
        return output;
    }
    /**
     * @param originalImage is the image we are going to rotate 90 degrees to the left.
     */
    public static RGBAPixel[][] rotateLeft(final RGBAPixel originalImage) {
        return dumOut;
    }
    /**
     * @param originalImage is the image we are going to rotate 90 degrees to the right.
     */
    public static RGBAPixel[][] rotateRight(final RGBAPixel originalImage) {
        return dumOut;
    }
    /**
     * @param originalImage is the image we are going to flip vertically.
     */
    public static RGBAPixel[][] flipVertical(RGBAPixel[][] originalImage) {
        return dumOut;
    }
    /**
     * @param originalImage is the image we are going to flip horizontally.
     */
    public static RGBAPixel[][] flipHorizontal(RGBAPixel[][] originalImage) {
        return dumOut;
    }
    /**
     * @param originalImage is the image we are going to shrink vertical.
     * @param amount is the factor that the height will be shrinking by.
     */
    public static RGBAPixel[][] shrinkVertical​(RGBAPixel[][] originalImage, int amount) {
        return dumOut;
    }
    /**
     * @param originalImage is the image we are going to shrink vertical.
     * @param amount is the factor that the height will be expanding by.
     */
    public static RGBAPixel[][] expandVertical​(RGBAPixel[][] originalImage, int amount) {
        return dumOut;
    }
    /**
     * @param originalImage is the image we are going to shrink horizontally.
     * @param amount is the factor that the width will be shrinking by.
     */
    public static RGBAPixel[][] shrinkHorizontal​(RGBAPixel[][] originalImage, int amount) {
        return dumOut;
    }
    /**
     * @param originalImage is the image we are going to expand horizontally.
     * @param amount is the factor that the height will be growing by.
     */
    public static RGBAPixel[][] expandHorizontal​(RGBAPixel[][] originalImage, int amount) {
        return dumOut;
    }
    /**
     * @param originalImage is the image we are removing a green screen mask from.
     */
    public static RGBAPixel[][] greenScreen(RGBAPixel[][] originalImage) {
        return dumOut;
    }

}
