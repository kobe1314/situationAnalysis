package com.situation.analysis.util;

import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaosir on 2021/10/22.
 *  调用方法：BASE64DecodedMultipartFile.base64ToMultipart
 */
public class BaseLiuFile implements MultipartFile {

    private final byte[] imgContent;
    private final String header;

    public BaseLiuFile(byte[] imgContent, String header) {
        this.imgContent = imgContent;
        this.header = header.split(";")[0];
    }

    @Override
    public String getName() {
        return System.currentTimeMillis() + Math.random() + "." + header.split("/")[1];
    }

    @Override
    public String getOriginalFilename() {
        return System.currentTimeMillis() + (int) Math.random() * 10000 + "." + header.split("/")[1];
    }

    @Override
    public String getContentType() {
        return header.split(":")[1];
    }

    @Override
    public boolean isEmpty() {
        return imgContent == null || imgContent.length == 0;
    }

    @Override
    public long getSize() {
        return imgContent.length;
    }

    @Override
    public byte[] getBytes() throws IOException {
        return imgContent;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(imgContent);
    }

    @Override
    public void transferTo(File dest) throws IOException, IllegalStateException {
        new FileOutputStream(dest).write(imgContent);
    }

    public static MultipartFile baseLiuToMultipart(String baseLiu) {
        try {
            String[] baseStrs = baseLiu.split(",");

            BASE64Decoder decoder = new BASE64Decoder();
            byte[] b = new byte[0];
            b = decoder.decodeBuffer(baseStrs[1]);

            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            return new BaseLiuFile(b, baseStrs[0]);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<MultipartFile> baseLiuToMultipart(String[] baseLiuList) {
        List<MultipartFile> resultFileList = new ArrayList<>();
        for(int i = 0; i< baseLiuList.length; ++i) {
            MultipartFile fileItem = BaseLiuFile.baseLiuToMultipart(baseLiuList[i]);
            resultFileList.add(fileItem);
        }
        return resultFileList;
    }

}