package com.gdzc.picDown;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ImageThread extends Thread{
	private String url ;
	public ImageThread(String url){
		this.url = url;
	}
	@Override
	public void run() {
		try {
			new BigImageLoad().getPaths(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

public class BigImageLoad {
	
	
	public static void main(String[] args) throws Exception {
		//http://www.umei.cc/p/gaoqing/index-1.htm
		//http://www.umei.cc/p/gaoqing/index-45.htm
		String url ;
		//考虑空格情况  http://61.146.178.120:8012/img2012/1212/07/010TW20120929/avy (1).jpg
		for(int i = 1 ; i < 10 ;  i++ ){
			url = "http://www.umei.cc/p/gaoqing/index-"+i+".htm";
			System.out.println("####### 列表页面" + url);
			new ImageThread(url).start();
		}
//		getPaths("http://www.umei.cc/p/gaoqing/index-1.htm");
	}
	
//	@Test
	public void testURL() throws Exception{
		URL url = new URL("http://www.umei.cc/p/gaoqing/index-1.htm");
		URL url2 = new URL(url,"/p/gaoqing/rihan/20121208201700.htm");
		System.out.println(url2);
	}
	
	
	
	///p/gaoqing/rihan/20121208201700.htm
//	@Test
	public void testPath(){
		Pattern pathPattern = Pattern.compile(".*(/p/gaoqing/(.*)/([\\d]*).htm).*");
		String line = "/p/gaoqing/rihan/20121208201700.htm";
		Matcher matcher = pathPattern.matcher(line);
		if(matcher.find()){
			String path = matcher.group(1);
			String category = matcher.group(2);
			String fileName = matcher.group(3);
			System.err.println(path + " : " + category + " : " + fileName);
			
			for(int i = 2 ; i <= 5 ; i ++){
				int lastIndex = path.lastIndexOf(".");
				String p = path.substring(0, lastIndex) + "_" + i + path.substring(lastIndex);
				System.out.println(p);
				
			}
		}
	}
//	@Test
	public void testFile(){
		String category = "rihan";
		File cateFile = new File(filePath + category);
		if(!cateFile.exists()){
			cateFile.mkdirs();
		}
	}
//	@Test
	public void testMaxSize(){
		Pattern maxPattern = Pattern.compile("<a href='([\\d]*)_[\\d]*.htm' >([\\d]*)</a>");
		String v = "<a href='20121208200440_2.htm' >2</a> <a href='20121208200440_3.htm' >3</a> <a href='20121208200440_4.htm' >4</a> <a href='20121208200440_5.htm' >5</a> <a href='20121208200440_6.htm' >6</a> <a href='20121208200440_7.htm' >7</a> <a href='20121208200440_8.htm' >8</a> <a href='20121208200440_9.htm' >9</a> <a href='20121208200440_10.htm' >10</a> <a href='20121208200440_11.htm' >11</a> <a href='20121208200440_12.htm' >12</a>";
		Matcher matcher = maxPattern.matcher(v);
		//System.out.println(matcher.);
		while(matcher.find()){
			System.out.println(matcher.group());
			String category = matcher.group(1);
			String num = matcher.group(2);
			System.out.println(category + " : " + num);
		}
	}
	
	private static  List<String> pathList = new ArrayList<String>();
	private Object obj = new Object();
	private static String filePath = "D:\\other\\image\\高清\\";
	public void getPaths(String u){
		Pattern pathPattern = Pattern.compile(".*(/p/gaoqing/(.*)/([\\d]*).htm).*");
		try {
			
			URL url = new URL(u);
			
			URLConnection conn = url.openConnection();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"gb2312"));
			String line ;
			while( ( line = reader.readLine() ) != null){
//			System.out.println(line);
				///p/gaoqing/gangtai/20121130210951.htm
				String[] allLine = line.split(" ");
				for(int i = 0 ; i < allLine.length ; i ++ ) {
					Matcher matcher = pathPattern.matcher(allLine[i]);
					if(matcher.find()){
						String p = matcher.group(1);
						String category = matcher.group(2);  //大分类
						String preImage = matcher.group(3); //图片名前缀
						//System.err.println(path + " : " + category + " : " + imageName);
						
						//图片第一页地址
						String path = null;
						synchronized (obj) {
							path = new URL(url,p).toString();
							if(!pathList.contains(path)){
								System.out.println("首页" + Thread.currentThread() + " : " + path);
								pathList.add(path);
							} else {
								System.err.println("******* 或略" + path);
								continue;
							}
						}
						if(path != null){
							//创建文件夹
							File cateFile = new File(filePath + category);
							if(!cateFile.exists()){
								cateFile.mkdirs();
								System.out.println("创建文件夹" + cateFile.getAbsolutePath());
							}
							System.out.println(Thread.currentThread() + "*****140*****" + path);
							getContent(cateFile.getAbsolutePath(), preImage, path, true);
						}
					}
				}
			}
			
			reader.close();
		}  catch (Exception e) {
			System.out.println("文件无法打开 :" + u);
		}
	}
	
	//preImage 前缀
	public void getContent(String filePath, String category,String p,boolean other){
		Pattern maxPattern = Pattern.compile("<a href='([\\d]*)_[\\d]*.htm' >([\\d]*)</a>");
		int maxSize = 0;
		try {
			URL url = new URL(p);
			
			URLConnection conn = url.openConnection();
			
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"gb2312"));
			String line ;
			while( ( line = reader.readLine() ) != null){
				Matcher matcher = maxPattern.matcher(line);
//				System.err.println(line);
				while(matcher.find() && other){
					//String category = matcher.group(1); //也是前缀，与preImage相同
					String num = matcher.group(2);
					maxSize = Math.max(maxSize, Integer.valueOf(num));
				}
				//需要保存图片的完整路径
				//D:\other\image\高清\cn/xcv_
				String imageFileURL = filePath + "/" + category;
				File imageFile = new File(imageFileURL);
				if(!imageFile.exists()){
					imageFile.mkdirs();
				}
				downImageURL(imageFileURL,line);
			}
		}  catch (Exception e) {
			System.out.println("文件解析有误" + p);
		}
		
		if(other){
			//获得分页数据
			System.err.println("分页  ：" + maxSize );
			for(int i = 2 ; i <= maxSize ; i ++){
				int lastIndex = p.lastIndexOf(".");
				String path = p.substring(0, lastIndex) + "_" + i + p.substring(lastIndex);
				getContent(filePath, category, path, false );
			}
		}
		
	}
	
	
//	@Test
	public void testImageUrl(){
		Pattern imagePattern = Pattern.compile("(http://i[\\d]*.umei.cc//img2012/[\\d]*[/[\\d]*/]?/[a-zA-z0-9]*/(.*).jpg)");
		String v = "sdfhttp://i2.umei.cc//img2012/1212/01/0054K0068/001.jpg ;j;jhttp://i2.umei.cc//img2012/1212/07/010TW20120929/avy%20(11).jpg";
		String[] vs = v.split(" ");
		for(int i = 0 ; i < vs.length ; i ++){
			Matcher matcher = imagePattern.matcher(vs[i]);
			while(matcher.find()){
				String imageUrl = matcher.group(1);
//				String imageName = matcher.group(2);
				String imageName = imageUrl.substring(imageUrl.lastIndexOf("/") + 1, imageUrl.lastIndexOf("."));
				System.out.println(imageUrl + " : " + imageName);
			}
		}
	}
	
	//获得链接
	public void downImageURL(String imageFileURL, String line){
		Pattern imagePattern = Pattern.compile("(http://i[\\d]*.umei.cc/[/]?img2012/[\\d]*[/[\\d]*/]?/[a-zA-z0-9]*/(.*).jpg)");
		//http://i2.umei.cc//img2012/1212/07/010TW20120929/avy%20(11).jpg
		//http://i2.umei.cc//img2012/1212/07/006TW20121011/DC0234.jpg
		//http://i3.umei.cc/img2012/0202/004b611/b0611-r01.jpg
		//http://i3.umei.cc/img2012/1205/03/007BT674/0000.jpg
		String[] vs = line.split(" ");
		for(int i = 0 ; i < vs.length ; i ++){
			Matcher matcher = imagePattern.matcher(vs[i]);
//			System.out.println("寻找图片 " + vs[i]);
			if(matcher.find()){
				String imageUrl = matcher.group(1);
//				String imageName = matcher.group(2);
//				System.out.println(imageUrl + " : " + imageName);
//				System.out.println("###" + imageName);
				//D:\other\image\高清\cn/xcv_sdfsdf.jpg
				//特殊处理文件名称  xxxx.jpg
				String imageName = imageUrl.substring(imageUrl.lastIndexOf("/") + 1);
				
				String endImage = imageFileURL + "/" +  imageName;
				downImage(imageUrl, endImage);
			}
		}
		
	}
	/**
	 * 下载图片   
	 * @param imageUrl 下载路径
	 * @param endImage 保存路径
	 * @throws Exception 
	 */
	public void downImage(String imageUrl , String endImage){
		imageUrl = imageUrl.replaceAll(" ", "%20");
		try {
			URL url = new URL(imageUrl);
			
			URLConnection conn = url.openConnection();
			
			InputStream is = conn.getInputStream();
			
			File imageFile = new File(endImage);
			if(!imageFile.exists()){
				System.out.println(Thread.currentThread() + "下载图片位置 ：" + endImage);
				imageFile.createNewFile();
				OutputStream out = new FileOutputStream(imageFile);
				byte[] buf = new byte[1024];
				int len = -1;
				while( (len = is.read(buf)) > -1 ){
					out.write(buf, 0, len);
				}
				out.close();
			} else {
				System.out.println(Thread.currentThread() + "已经存在 ： " + endImage);
			}
			is.close();
		} catch (Exception e) {
			System.err.println("########下载失败###########################################");
			e.printStackTrace();
		}
		
	}
//	@Test
	public void testDown() throws UnsupportedEncodingException{
		String imageUrl = "http://61.146.178.120:8012/img2012/1212/07/010TW20120929/avy (1).jpg";
		imageUrl = imageUrl.replaceAll(" ", "%20");
		new BigImageLoad().downImage(imageUrl, "D:\\other\\image\\高清\\a.jpg");
	}
	
	
	
	
	

}
