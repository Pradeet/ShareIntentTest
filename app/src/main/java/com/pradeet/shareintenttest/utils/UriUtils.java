package com.pradeet.shareintenttest.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by pradeetswamy on 25/01/18.
 */

public class UriUtils {

    public static File createFileForPic(Context context) throws IOException {
        String fileName = "JPEG_" + new SimpleDateFormat("yyyyMMdd_HHmmssSSS", Locale.getDefault()).format(new Date()) + ".jpg";
        File storageDic = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        return new File(storageDic, fileName);
    }

    public static File createTmpFileForPic(Context context) throws IOException {
        String fileName = "JPEG_" + new SimpleDateFormat("yyyyMMdd_HHmmssSSS", Locale.getDefault()).format(new Date());
        File storageDic = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        return File.createTempFile(fileName, ".jpg", storageDic);
    }

    public static Uri fromFile(Context context, File file) {
        if (context == null || file == null) {
            throw new RuntimeException("context or file can't be null");
        }
        return Uri.fromFile(file);
    }
}