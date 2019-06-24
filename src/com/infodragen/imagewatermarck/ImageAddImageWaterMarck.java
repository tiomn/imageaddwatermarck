package com.infodragen.imagewatermarck;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageAddImageWaterMarck {
	// ������ˮӡ 
    public void mark(BufferedImage bufImg, Image img, String text, Font font, Color color, int x, int y) { 
        Graphics2D g = bufImg.createGraphics(); 
        g.drawImage(img, 0, 0, bufImg.getWidth(), bufImg.getHeight(), null); 
        g.setColor(color); 
        g.setFont(font); 
        g.drawString(text, x, y); 
        g.dispose(); 
    } 
    /**
     * ��ͼƬ��������ˮӡ
     * 
     * @param imgPath
     *            -Ҫ���ˮӡ��ͼƬ·��
     * @param outImgPath
     *            -���·��
     * @param text-����
     * @param font
     *            -����
     * @param color
     *            -��ɫ
     * @param x
     *            -����λ�ڵ�ǰͼƬ�ĺ�����
     * @param y
     *            -����λ�ڵ�ǰͼƬ��������
     */ 
    public void mark(String imgPath, String outImgPath, String text, Font font, Color color, int x, int y) { 
        try { 
            // ��ȡԭͼƬ��Ϣ 
            File imgFile = null; 
            Image img = null; 
            if (imgPath != null) { 
                imgFile = new File(imgPath); 
            } 
            if (imgFile != null && imgFile.exists() && imgFile.isFile() && imgFile.canRead()) { 
                img = ImageIO.read(imgFile); 
            } 
            int imgWidth = img.getWidth(null); 
            int imgHeight = img.getHeight(null); 
            // ��ˮӡ 
            BufferedImage bufImg = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_RGB); 
            mark(bufImg, img, text, font, color, x, y); 
            // ���ͼƬ 
            FileOutputStream outImgStream = new FileOutputStream(outImgPath); 
            ImageIO.write(bufImg, "jpg", outImgStream); 
            outImgStream.flush(); 
            outImgStream.close(); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
    } 
    //���ͼƬˮӡ
	 public void mark(BufferedImage bufImg, Image img, Image markImg, int width, int height, int x, int y) { 
	        Graphics2D g = bufImg.createGraphics(); 
	        g.drawImage(img, 0, 0, bufImg.getWidth(), bufImg.getHeight(), null); 
	        g.drawImage(markImg, x, y, width, height, null); 
	        g.dispose(); 
	    } 
	/**
     * ��ͼƬ����ͼƬˮӡ
     * 
     * @param inputImg
     *            -ԴͼƬ��Ҫ���ˮӡ��ͼƬ
     * @param markImg
     *            - ˮӡͼƬ
     * @param outputImg
     *            -���ͼƬ(������ԴͼƬ)
     * @param width
     *            - ˮӡͼƬ���
     * @param height
     *            -ˮӡͼƬ�߶�
     * @param x
     *            -�����꣬�����ԴͼƬ
     * @param y
     *            -�����꣬ͬ��
     */ 
    public void mark(String inputImg, String markImg, String outputImg, int width, int height, int x, int y) { 
        // ��ȡԭͼƬ��Ϣ 
        File inputImgFile = null; 
        File markImgFile = null; 
        Image img = null; 
        Image mark = null; 
        try { 
            if (inputImg != null && markImg != null) { 
                inputImgFile = new File(inputImg); 
                markImgFile = new File(markImg); 
            } 
            if (inputImgFile != null && inputImgFile.exists() && inputImgFile.isFile() && inputImgFile.canRead()) { 
   
                img = ImageIO.read(inputImgFile); 
   
            } 
            if (markImgFile != null && markImgFile.exists() && markImgFile.isFile() && markImgFile.canRead()) { 
   
                mark = ImageIO.read(markImgFile); 
   
            } 
            int imgWidth = img.getWidth(null); 
            int imgHeight = img.getHeight(null); 
            BufferedImage bufImg = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_RGB); 
            mark(bufImg, img, mark, width, height, x, y); 
            FileOutputStream outImgStream = new FileOutputStream(outputImg); 
            ImageIO.write(bufImg, "jpg", outImgStream); 
            outImgStream.flush(); 
            outImgStream.close(); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        } 
    } 
    public static void main(String[] args) { 
        Font font = new Font("����", Font.PLAIN, 14); 
        // ԭͼλ��, ���ͼƬλ��, ˮӡ������ɫ, ˮӡ���� 
        // new MarkText4J().mark("eguidMarkText2.jpg", "eguidMarkText2.jpg", "ˮӡЧ������", font, Color.ORANGE, 0, 14); 
        // ����ͼƬˮӡ 
        new ImageAddImageWaterMarck().mark("C:\\Users\\tm1612\\Desktop\\0001.jpg", "C:\\Users\\tm1612\\Desktop\\20190618.png", "C:\\Users\\tm1612\\Desktop\\1118.jpg", 342, 118, 25, 180); 
    } 
}
