package org.checkin_app.code.controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import javafx.scene.image.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import java.util.TimerTask;

public class GenerateDynamicQRCodeTask extends TimerTask {

    private String path = "src/main/java/org/checkin_app/qrcode";
    private ImageView imageView;
    private String nameQR;
    private String roomCheckin;
    public GenerateDynamicQRCodeTask(ImageView imageView, String nameQR, String roomCheckin){
        this.imageView = imageView;
        this.nameQR = nameQR + ".png";
        this.roomCheckin = roomCheckin;
    }

    @Override
    public void run() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        String currentTime = dateFormat.format(new Date());
        String dynamicData = "Checkin Thành Công Lúc: " +  currentTime; // Example dynamic data
        String qrCodeData = dynamicData; // QR code data is the dynamic data
        // QR code data is the dynamic data
        int width = 500;
        int height = 500;
        try {
            // Generate QR code
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            BitMatrix bitMatrix = new QRCodeWriter().encode(qrCodeData, BarcodeFormat.QR_CODE, width, height);
            ImageIO.write(matrixToImage(bitMatrix), "png", byteArrayOutputStream);

            // Convert to JavaFX Image
            byte[] bytes = byteArrayOutputStream.toByteArray();
            String encoded = Base64.getEncoder().encodeToString(bytes);
            Image image = new Image("data:image/png;base64," + encoded);
            imageView.setImage(image);
            /*

             */
            Image img = new Image(image.getUrl());
            PixelReader reader = img.getPixelReader();
            byte[] buffer = new byte[width * height * 4];
            WritablePixelFormat<ByteBuffer> format = PixelFormat.getByteBgraInstance();
            reader.getPixels(0, 0, width, height, format, buffer, 0, width * 4);
            try {
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(path + "/" + roomCheckin +".data"));
                for(int count = 0; count < buffer.length; count += 4) {
                    out.write(buffer[count + 2]);
                    out.write(buffer[count + 1]);
                    out.write(buffer[count]);
                    out.write(buffer[count + 3]);
                }
                out.flush();
                out.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static BufferedImage matrixToImage(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
            }
        }
        return image;
    }


}
