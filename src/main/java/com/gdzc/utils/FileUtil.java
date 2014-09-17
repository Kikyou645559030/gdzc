package com.gdzc.utils;

import org.slf4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Liu_Zhichao on 14-6-5.
 */
public class FileUtil {
    private static Logger log = org.slf4j.LoggerFactory.getLogger(FileUtil.class);

    /**
     * 获取扩展名
     *
     * @param filename
     * @return
     */
    public static String getExtensionName(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot > -1) && (dot < (filename.length() - 1))) {
                return filename.substring(dot + 1);
            }
        }
        return "";
    }

    public static void saveUploadFile(MultipartFile file, String path, String name,String dir) {
        if (file.getSize() > 0) {
            Long sizes = file.getSize();
            if (sizes > 0) {
                String extensionName = FileUtil.getExtensionName(file.getOriginalFilename());
                FileOutputStream fos = null;
                try {
                    String[] paths = path.split(",");
                    File f = new File(paths[0]);
                    if (!f.isDirectory()) {
                        f.mkdirs();
                    }
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
                    String time = sdf.format(new Date());
                    String fullPath = paths[0] + "/" + time + "." + extensionName;
                    File f2 = new File(fullPath);
                    fos = new FileOutputStream(new File(f2.getPath()), true);
                    byte[] bytes = file.getBytes();
                    fos.write(bytes);
                    fos.flush();
                    String p = "";
                    if(paths.length > 1){
                        p = paths[1] + "/";
                    }
                    String ps = dir + "/" + p + time + "." + extensionName;
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (fos != null)
                            fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        log.debug("FileUtil.saveUploadFile()中出现异常");
                        log.debug("File file: " + file + "String PATH: " + path);
                    }
                }
            }
        } else {
            log.debug("File file: " + file + "String PATH: " + path);
            log.debug("FileUtil.saveUploadFile()中出现异常");
        }
    }

    public static boolean delete(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            log.info("删除文件失败：" + fileName + "文件不存在");
            return false;
        } else {
            if (file.isFile()) {
                return deleteFile(fileName);
            } else {
                return deleteDirectory(fileName);
            }
        }
    }

    /**
     * 删除单个文件
     *
     * @param fileName
     *            被删除文件的文件名
     * @return 单个文件删除成功返回true,否则返回false
     */
    public static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.isFile() && file.exists()) {
            file.delete();
            log.info("删除单个文件" + fileName + "成功！");
            return true;
        } else {
            log.info("删除单个文件" + fileName + "失败！");
            return false;
        }
    }

    /**
     * 删除目录（文件夹）以及目录下的文件
     *
     * @param dir
     *            被删除目录的文件路径
     * @return 目录删除成功返回true,否则返回false
     */
    public static boolean deleteDirectory(String dir) {
        // 如果dir不以文件分隔符结尾，自动添加文件分隔符
        if (!dir.endsWith(File.separator)) {
            dir = dir + File.separator;
        }
        File dirFile = new File(dir);
        // 如果dir对应的文件不存在，或者不是一个目录，则退出
        if (!dirFile.exists() || !dirFile.isDirectory()) {
            log.info("删除目录失败" + dir + "目录不存在！");
            return false;
        }
        boolean flag = true;
        // 删除文件夹下的所有文件(包括子目录)
        File[] files = dirFile.listFiles();
        for (int i = 0; i < files.length; i++) {
            // 删除子文件
            if (files[i].isFile()) {
                flag = deleteFile(files[i].getAbsolutePath());
                if (!flag) {
                    break;
                }
            }
            // 删除子目录
            else {
                flag = deleteDirectory(files[i].getAbsolutePath());
                if (!flag) {
                    break;
                }
            }
        }
        if (!flag) {
            log.info("删除目录失败");
            return false;
        }
        // 删除当前目录
        if (dirFile.delete()) {
            log.info("删除目录" + dir + "成功！");
            return true;
        } else {
            log.info("删除目录" + dir + "失败！");
            return false;
        }
    }
}
