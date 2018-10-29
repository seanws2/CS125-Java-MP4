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
     * @return output temp return.
     */
    public static RGBAPixel[][] shiftLeft(final RGBAPixel[][] originalImage, final int amount) {
        int picHeight = originalImage.length;
        int picWidth = originalImage[0].length;
        int temp = amount;
        if (amount > picHeight) {
            temp = picWidth;
        }
        RGBAPixel[][] output = new RGBAPixel[picHeight][picWidth];
        for (int i = 0; i < picWidth; i++) {
            for (int j = 0; j < picHeight - temp; j++) {
                output[j][i] = originalImage[j + temp][i];
            }
        }
        for (int i = 0; i < picWidth; i++) {
            for (int j = 0; j < picHeight; j++) {
                if (output[j][i] == null) {
                    output[j][i] = FILL_VALUE;
                }
            }
        }
        return output;
    }
    /**
     * @param originalImage is the image we are going to shift.
     * @param amount amount to shift the image RIGHT.
     * @return output temp return.
     */
    public static RGBAPixel[][] shiftRight(final RGBAPixel[][] originalImage, final int amount) {
        int picHeight = originalImage.length;
        int picWidth = originalImage[0].length;
        RGBAPixel[][] output = new RGBAPixel[picHeight][picWidth];
        for (int i = 0; i < picWidth; i++) {
            for (int j = 0; j < picHeight - amount; j++) {
                output[j + amount][i] = originalImage[j][i];
            }
        }
        for (int i = 0; i < picWidth; i++) {
            for (int j = 0; j < picHeight; j++) {
                if (output[j][i] == null) {
                    output[j][i] = FILL_VALUE;
                }
            }
        }
        return output;
    }
    /**
     * @param originalImage is the image we are going to shift.
     * @param amount amount to shift the image UP.
     * @return output temp return.
     */
    public static RGBAPixel[][] shiftUp(final RGBAPixel[][] originalImage, final int amount) {
        int picHeight = originalImage.length;
        int picWidth = originalImage[0].length;
        RGBAPixel[][] output = new RGBAPixel[picHeight][picWidth];
        for (int i = 0; i < picHeight; i++) {
            for (int j = 0; j < picWidth - amount; j++) {
                output[i][j] = originalImage[i][j + amount];
            }
        }
        for (int i = 0; i < picHeight; i++) {
            for (int j = 0; j < picWidth; j++) {
                if (output[i][j] == null) {
                    output[i][j] = FILL_VALUE;
                }
            }
        }
        return output;
    }
    /**
     * @param originalImage is the image we are going to shift.
     * @param amount amount to shift the image DOWN.
     * @return output temp return.
     */
    public static RGBAPixel[][] shiftDown(final RGBAPixel[][] originalImage, final int amount) {
        int picHeight = originalImage.length;
        int picWidth = originalImage[0].length;
        RGBAPixel[][] output = new RGBAPixel[picHeight][picWidth];
        for (int i = 0; i < picHeight; i++) {
            for (int j = 0; j < picWidth - amount; j++) {
                output[i][j + amount] = originalImage[i][j];
            }
        }
        for (int i = 0; i < picHeight; i++) {
            for (int j = 0; j < picWidth; j++) {
                if (output[i][j] == null) {
                    output[i][j] = FILL_VALUE;
                }
            }
        }
        return output;
    }
    /**
     * @param originalImage is the image we are going to rotate 90 degrees to the left.
     * @return dumOut temp return.
     */
    public static RGBAPixel[][] rotateLeft(final RGBAPixel[][] originalImage) {
        int picWidth = originalImage.length;
        int picHeight = originalImage[0].length;
        int offFill = (picHeight - picWidth) / 2;
        RGBAPixel[][] out = new RGBAPixel[picHeight][picWidth];
        if (offFill > 0) {
            for (int i = 0; i < picWidth; i++) {
                RGBAPixel[] temp = new RGBAPixel[picWidth];
                int tempCount = 0;
                for (int j = offFill; j < picHeight - offFill; j++) {
                    temp[tempCount] = originalImage[i][j];
                    tempCount++;
                }
                for (int h = 0; h < picWidth; h++) {
                    out[picHeight - 1 - i - offFill][h] = temp[h];
                }
            }
        } else {
            offFill *= -1;
            for (int i = 0; i < picHeight; i++) {
                RGBAPixel[] temp = new RGBAPixel[picHeight];
                int tempCount = 0;
                for (int j = offFill; j < picWidth - offFill; j++) {
                    temp[tempCount] = originalImage[j][i];
                    tempCount++;
                }
                tempCount = 0;
                for (int h = picHeight - 1; h >= 0; h--) {
                    out[h][offFill + i] = temp[tempCount];
                    tempCount++;
                }
            }
        }
        for (int i = 0; i < picHeight; i++) {
            for (int j = 0; j < picWidth; j++) {
                if (out[i][j] == null) {
                    out[i][j] = FILL_VALUE;
                }
            }
        }
        RGBAPixel[][] out1 = new RGBAPixel[picWidth][picHeight];
        for (int i = 0; i < picWidth; i++) {
            for (int j = 0; j < picHeight; j++) {
                out1[i][j] = out[j][i];
            }
        }
        return out1;
    }
    /**
     * @param originalImage is the image we are going to rotate 90 degrees to the right.
     * @return dumOut temp return.
     */
    public static RGBAPixel[][] rotateRight(final RGBAPixel[][] originalImage) {
        int picWidth = originalImage.length;
        int picHeight = originalImage[0].length;
        int offFill = (picHeight - picWidth) / 2;
        RGBAPixel[][] out = new RGBAPixel[picHeight][picWidth];
        if (offFill > 0) {
            for (int i = 0; i < picWidth; i++) {
                RGBAPixel[] temp = new RGBAPixel[picWidth];
                int tempCount = 0;
                for (int j = offFill; j < picHeight - offFill; j++) {
                    temp[tempCount] = originalImage[i][j];
                    tempCount++;
                }
                for (int h = 0; h < picWidth; h++) {
                    out[offFill + i][picWidth - 1 - h] = temp[h];
                }
            }
        } else {
            offFill *= -1;
            for (int i = 0; i < picHeight; i++) {
                RGBAPixel[] temp = new RGBAPixel[picHeight];
                int tempCount = 0;
                for (int j = offFill; j < picWidth - offFill; j++) {
                    temp[tempCount] = originalImage[j][i];
                    tempCount++;
                }
                tempCount = 0;
                for (int h = 0; h < picHeight; h++) {
                    out[h][picWidth - offFill - 1 - i] = temp[tempCount];
                    tempCount++;
                }
            }
        }
        for (int i = 0; i < picHeight; i++) {
            for (int j = 0; j < picWidth; j++) {
                if (out[i][j] == null) {
                    out[i][j] = FILL_VALUE;
                }
            }
        }
        RGBAPixel[][] out1 = new RGBAPixel[picWidth][picHeight];
        for (int i = 0; i < picWidth; i++) {
            for (int j = 0; j < picHeight; j++) {
                out1[i][j] = out[j][i];
            }
        }
        return out1;
    }
    /**
     * @param originalImage is the image we are going to flip vertically.
     * @return dumOut temp return.
     */
    public static RGBAPixel[][] flipVertical(final RGBAPixel[][] originalImage) {
        int picWidth = originalImage.length;
        int picHeight = originalImage[0].length;
        int offFill = (picHeight - picWidth) / 2;
        RGBAPixel[][] out = new RGBAPixel[picHeight][picWidth];
        for (int i = 0; i < picWidth; i++) {
            for (int j = 0; j < picHeight; j++) {
                out[j][i] = originalImage[i][picHeight - j - 1];
            }
        }
        RGBAPixel[][] out1 = new RGBAPixel[picWidth][picHeight];
        for (int i = 0; i < picWidth; i++) {
            for (int j = 0; j < picHeight; j++) {
                out1[i][j] = out[j][i];
            }
        }
        return out1;
    }
    /**
     * @param originalImage is the image we are going to flip horizontally.
     * @return dumOut temp return.
     */
    public static RGBAPixel[][] flipHorizontal(final RGBAPixel[][] originalImage) {
        int picWidth = originalImage.length;
        int picHeight = originalImage[0].length;
        int offFill = (picHeight - picWidth) / 2;
        RGBAPixel[][] out = new RGBAPixel[picHeight][picWidth];
        for (int i = 0; i < picHeight; i++) {
            for (int j = 0; j < picWidth; j++) {
                out[i][j] = originalImage[picWidth - j - 1][i];
            }
        }
        RGBAPixel[][] out1 = new RGBAPixel[picWidth][picHeight];
        for (int i = 0; i < picWidth; i++) {
            for (int j = 0; j < picHeight; j++) {
                out1[i][j] = out[j][i];
            }
        }
        return out1;
    }
    /**
     * @param originalImage is the image we are going to shrink vertical.
     * @param amount is the factor that the height will be shrinking by.
     * @return dumOut temp return.
     */
    public static RGBAPixel[][] shrinkVertical(final RGBAPixel[][] originalImage, final int amount) {
        return dumOut;
    }
    /**
     * @param inputArray is the image we are going to shrink vertical.
     * @param amount is the factor that the height will be expanding by.
     * @return dumOut temp return.
     */
    public static RGBAPixel[][] expandVertical(final RGBAPixel[][] inputArray, final int amount) {
        RGBAPixel[][] out = new RGBAPixel[inputArray.length][inputArray[0].length * amount];
        for (int i = 0; i < out.length; i++) {
            for (int j = 0; j < out[0].length; j = j + amount) {
                for (int k = 0; k < amount; k++) {
                    out[i][j + k] =  inputArray[i][j / amount];
                }
            }
        }
        RGBAPixel[][] out1 = new RGBAPixel[inputArray.length][inputArray[0].length];
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[0].length; j++) {
                out1[i][j] = out[i][j + (inputArray[0].length * (amount - 1)) / 2];
            }
        }
        return out1;
    }
    /**
     * @param originalImage is the image we are going to shrink horizontally.
     * @param amount is the factor that the width will be shrinking by.
     * @return dumOut temp return.
     */
    public static RGBAPixel[][] shrinkHorizontal(final RGBAPixel[][] originalImage, final int amount) {
        return dumOut;
    }
    /**
     * @param originalImage is the image we are going to expand horizontally.
     * @param amount is the factor that the height will be growing by.
     * @return dumOut temp return.
     */
    public static RGBAPixel[][] expandHorizontal(final RGBAPixel[][] originalImage, final int amount) {
        RGBAPixel[][] out = new RGBAPixel[originalImage.length * amount][originalImage[0].length];
        for (int i = 0; i < out[0].length; i++) {
            for (int j = 0; j < out.length; j = j + amount) {
                for (int k = 0; k < amount; k++) {
                    out[j + k][i] =  originalImage[j / amount][i];
                }
            }
        }
        RGBAPixel[][] out1 = new RGBAPixel[originalImage.length][originalImage[0].length];
        for (int i = 0; i < originalImage[0].length; i++) {
            for (int j = 0; j < originalImage.length; j++) {
                out1[j][i] = out[j + (originalImage.length * (amount - 1)) / 2][i];
            }
        }
        return out1;
    }
    /**
     * @param originalImage is the image we are removing a green screen mask from.
     * @return dumOut temp return.
     */
    public static RGBAPixel[][] greenScreen(final RGBAPixel[][] originalImage) {
        RGBAPixel[][] output = new RGBAPixel[originalImage.length][originalImage[0].length];
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[0].length; j++) {
                if (originalImage[i][j].getGreen() > originalImage[i][j].getRed()) {
                    if (originalImage[i][j].getGreen() > originalImage[i][j].getBlue()) {
                        output[i][j] = FILL_VALUE;
                    }
                } else {
                    output[i][j] = originalImage[i][j];
                }
            }
        }
        return output;
    }
}
