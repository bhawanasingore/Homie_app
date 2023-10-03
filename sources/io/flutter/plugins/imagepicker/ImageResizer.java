package io.flutter.plugins.imagepicker;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import androidx.annotation.Nullable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

class ImageResizer {
    private final ExifDataCopier exifDataCopier;
    private final File externalFilesDirectory;

    ImageResizer(File externalFilesDirectory2, ExifDataCopier exifDataCopier2) {
        this.externalFilesDirectory = externalFilesDirectory2;
        this.exifDataCopier = exifDataCopier2;
    }

    /* access modifiers changed from: package-private */
    public String resizeImageIfNeeded(String imagePath, @Nullable Double maxWidth, @Nullable Double maxHeight, @Nullable Integer imageQuality) {
        Bitmap bmp = decodeFile(imagePath);
        if (bmp == null) {
            return null;
        }
        if (!((maxWidth == null && maxHeight == null && !isImageQualityValid(imageQuality)) ? false : true)) {
            return imagePath;
        }
        try {
            String[] pathParts = imagePath.split("/");
            File file = resizedImage(bmp, maxWidth, maxHeight, imageQuality, pathParts[pathParts.length - 1]);
            copyExif(imagePath, file.getPath());
            return file.getPath();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private File resizedImage(Bitmap bmp, Double maxWidth, Double maxHeight, Integer imageQuality, String outputImageName) throws IOException {
        double originalWidth = ((double) bmp.getWidth()) * 1.0d;
        double originalHeight = ((double) bmp.getHeight()) * 1.0d;
        Integer imageQuality2 = imageQuality;
        if (!isImageQualityValid(imageQuality2)) {
            imageQuality2 = 100;
        }
        boolean shouldDownscale = true;
        boolean hasMaxWidth = maxWidth != null;
        boolean hasMaxHeight = maxHeight != null;
        Double width = Double.valueOf(hasMaxWidth ? Math.min(originalWidth, maxWidth.doubleValue()) : originalWidth);
        Double height = Double.valueOf(hasMaxHeight ? Math.min(originalHeight, maxHeight.doubleValue()) : originalHeight);
        boolean shouldDownscaleWidth = hasMaxWidth && maxWidth.doubleValue() < originalWidth;
        boolean shouldDownscaleHeight = hasMaxHeight && maxHeight.doubleValue() < originalHeight;
        if (!shouldDownscaleWidth && !shouldDownscaleHeight) {
            shouldDownscale = false;
        }
        if (shouldDownscale) {
            double downscaledWidth = (height.doubleValue() / originalHeight) * originalWidth;
            double downscaledHeight = (width.doubleValue() / originalWidth) * originalHeight;
            if (width.doubleValue() < height.doubleValue()) {
                if (!hasMaxWidth) {
                    width = Double.valueOf(downscaledWidth);
                } else {
                    height = Double.valueOf(downscaledHeight);
                }
            } else if (height.doubleValue() < width.doubleValue()) {
                if (!hasMaxHeight) {
                    height = Double.valueOf(downscaledHeight);
                } else {
                    width = Double.valueOf(downscaledWidth);
                }
            } else if (originalWidth < originalHeight) {
                width = Double.valueOf(downscaledWidth);
            } else if (originalHeight < originalWidth) {
                height = Double.valueOf(downscaledHeight);
            }
        }
        double d = originalWidth;
        return createImageOnExternalDirectory("/scaled_" + outputImageName, createScaledBitmap(bmp, width.intValue(), height.intValue(), false), imageQuality2.intValue());
    }

    private File createFile(File externalFilesDirectory2, String child) {
        File image = new File(externalFilesDirectory2, child);
        if (!image.getParentFile().exists()) {
            image.getParentFile().mkdirs();
        }
        return image;
    }

    private FileOutputStream createOutputStream(File imageFile) throws IOException {
        return new FileOutputStream(imageFile);
    }

    private void copyExif(String filePathOri, String filePathDest) {
        this.exifDataCopier.copyExif(filePathOri, filePathDest);
    }

    private Bitmap decodeFile(String path) {
        return BitmapFactory.decodeFile(path);
    }

    private Bitmap createScaledBitmap(Bitmap bmp, int width, int height, boolean filter) {
        return Bitmap.createScaledBitmap(bmp, width, height, filter);
    }

    private boolean isImageQualityValid(Integer imageQuality) {
        return imageQuality != null && imageQuality.intValue() > 0 && imageQuality.intValue() < 100;
    }

    private File createImageOnExternalDirectory(String name, Bitmap bitmap, int imageQuality) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        boolean saveAsPNG = bitmap.hasAlpha();
        if (saveAsPNG) {
            Log.d("ImageResizer", "image_picker: compressing is not supported for type PNG. Returning the image with original quality");
        }
        bitmap.compress(saveAsPNG ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG, imageQuality, outputStream);
        File imageFile = createFile(this.externalFilesDirectory, name);
        FileOutputStream fileOutput = createOutputStream(imageFile);
        fileOutput.write(outputStream.toByteArray());
        fileOutput.close();
        return imageFile;
    }
}
