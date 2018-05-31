package com.tfd.poi2html;

import com.tfd.POIUtils;
import com.tfd.pdf2html.PDF2Image;

import java.io.File;
import java.io.IOException;

/**
 * @author TangFD@HF 2018/5/29
 */
public class POI2Html {

    public static void pdf2HtmlByPassword(String filePath, String htmlDir, String imgDir, String imgWebPath, String password) throws IOException {
        File file = POIUtils.checkFileExists(filePath);
        htmlDir = POIUtils.dealTargetDir(htmlDir);
        imgDir = POIUtils.dealTargetDir(imgDir);
        imgWebPath = POIUtils.dealTargetDir(imgWebPath);
        PDF2Image.pdf2Image(file, htmlDir, imgDir, imgWebPath, password);
    }

    public static void poi2Html(String filePath, String htmlDir, String imgDir, String imgWebPath) throws Exception {
        File file = POIUtils.checkFileExists(filePath);
        htmlDir = POIUtils.dealTargetDir(htmlDir);
        imgDir = POIUtils.dealTargetDir(imgDir);
        imgWebPath = POIUtils.dealTargetDir(imgWebPath);
        if (filePath.endsWith("ppt") || filePath.endsWith("pptx")) {
            PPT2Image.ppt2Html(file, htmlDir, imgDir, imgWebPath);
        } else if (filePath.endsWith("doc") || filePath.endsWith("docx")) {
            Word2Html.word2Html(file, htmlDir, imgDir, imgWebPath);
        } else if (filePath.endsWith("xls") || filePath.endsWith("xlsx")) {
            Excel2Html.xls2Html(filePath, htmlDir);
        } else if (filePath.endsWith("pdf")) {
            PDF2Image.pdf2Image(file, htmlDir, imgDir, imgWebPath, null);
        } else {
            throw new RuntimeException("invalid file type![filePath : " + filePath + "]");
        }
    }
}
