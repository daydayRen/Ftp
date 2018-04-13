package com.taotao.pageTest;
import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.net.ftp.FTP;
/**
 * 测试ftp上传文件
 */
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

import com.taotao.utils.FtpUtil;

public class FTPtest {

	@Test
	public void test() throws Exception {
		//创建ftp对象
		FTPClient  ftpClient=new FTPClient();
		//链接
		ftpClient.connect("172.20.10.2", 21);
		//登录ftp服务器 使用用户和密码
		ftpClient.login("oneday", "root");
		//解决防火墙问题
		ftpClient.enterLocalPassiveMode();
		//上传文件	
		FileInputStream inputStream=new FileInputStream(new File("D:\\images\\img2.jpg"));
		//读取本地文件		
		//修改上传路径
		ftpClient.changeWorkingDirectory("/home/oneday/www/images");
		//修改上传格式
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
		//上传关闭链接
		ftpClient.storeFile("img1.jpg", inputStream);
		ftpClient.logout();
	}

	@Test
	public void testFtpUtil() throws Exception {
		FileInputStream inputStream = new FileInputStream(new File("D:\\images\\img2.jpg"));
		FtpUtil.uploadFile("172.20.10.2", 21, "oneday", "root", "/home/oneday/www/images", "/2018/4/13", "hello.jpg", inputStream);
		
	}

}
