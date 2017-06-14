package com.zzyy.rs.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;




public class FtpClientUtil {
	    public static final String ANONYMOUS_LOGIN = "anonymous";
	    private FTPClient ftp;
	    private String encoding="utf-8";
	    private boolean is_connected;
	    
	    
	    
	    
	    public FtpClientUtil() {
	        ftp = new FTPClient();
	        is_connected = false;
	    }
	    
	    
	    public FtpClientUtil(int defaultTimeoutSecond, int connectTimeoutSecond, int dataTimeoutSecond){
	        ftp = new FTPClient();
	        is_connected = false;
	        
	        ftp.setDefaultTimeout(defaultTimeoutSecond * 1000);
	        ftp.setConnectTimeout(connectTimeoutSecond * 1000);
	        ftp.setDataTimeout(dataTimeoutSecond * 1000);
	    }
	    

	    
	    public String getEncoding() {
			return encoding;
		}

		public void setEncoding(String encoding) {
			this.encoding = encoding;
		}

		/**
	     * Connects to FTP server.
	     * 
	     * @param host
	     *            FTP server address or name
	     * @param port
	     *            FTP server port
	     * @param user
	     *            user name
	     * @param password
	     *            user password
	     * @param isTextMode
	     *            text / binary mode switch
	     * @throws IOException
	     *             on I/O errors
	     */
	    public void connect(String host, int port, String user, String password, boolean isTextMode) throws IOException {
	        // Connect to server.
	        try {
	        	ftp.setControlEncoding(encoding);
	            ftp.connect(host, port);
	            System.out.println("连接成功");
	        } catch (UnknownHostException ex) {
	            throw new IOException("Can't find FTP server '" + host + "'");
	        }

	        // Check rsponse after connection attempt.
	        int reply = ftp.getReplyCode();
	        if (!FTPReply.isPositiveCompletion(reply)) {
	            disconnect();
	            throw new IOException("Can't connect to server '" + host + "'");
	        }

	        if (user == "") {
	            user = ANONYMOUS_LOGIN;
	        }

	        // Login.
	        if (!ftp.login(user, password)) {
	            is_connected = false;
	            disconnect();
	            throw new IOException("Can't login to server '" + host + "'");
	        } else {
	            is_connected = true;
	        }

	        // Set data transfer mode.
	        if (isTextMode) {
	            ftp.setFileType(FTP.ASCII_FILE_TYPE);
	        } else {
	            ftp.setFileType(FTP.BINARY_FILE_TYPE);
	        }
	        
	    }

	    /**
	     * Uploads the file to the FTP server.
	     * 
	     * @param ftpFileName
	     *            server file name (with absolute path)
	     * @param localFile
	     *            local file to upload
	     * @throws IOException
	     *             on I/O errors
	     */
	    public void upload(String ftpFileName, File localFile) throws IOException {
	        // File check.
	        if (!localFile.exists()) {
	            throw new IOException("Can't upload '" + localFile.getAbsolutePath() + "'. This file doesn't exist.");
	        }

	        // Upload.
	        InputStream in = null;
	        try {

	            // Use passive mode to pass firewalls.
	            ftp.enterLocalPassiveMode();

	            in = new BufferedInputStream(new FileInputStream(localFile));
	            if (!ftp.storeFile(ftpFileName, in)) {
	                throw new IOException("Can't upload file '" + ftpFileName + "' to FTP server. Check FTP permissions and path.");
	            }

	        } finally {
	            try {
	                in.close();
	            } catch (IOException ex) {
	            }
	        }
	    }

	    /**
	     * Downloads the file from the FTP server.
	     * 
	     * @param ftpFileName
	     *            server file name (with absolute path)
	     * @param localFile
	     *            local file to download into
	     * @throws IOException
	     *             on I/O errors
	     */
	    public void download(String ftpFileName, File localFile) throws IOException {
	        // Download.
	        OutputStream out = null;
	        try {
	            // Use passive mode to pass firewalls.
	            ftp.enterLocalPassiveMode();

	            // Get file info.
	            FTPFile[] fileInfoArray = ftp.listFiles(ftpFileName);
	            if (fileInfoArray == null) {
	                throw new FileNotFoundException("File " + ftpFileName + " was not found on FTP server.");
	            }

	            // Check file size.
	            FTPFile fileInfo = fileInfoArray[0];
	            long size = fileInfo.getSize();
	            if (size > Integer.MAX_VALUE) {
	                throw new IOException("File " + ftpFileName + " is too large.");
	            }

	            // Download file.
	            out = new BufferedOutputStream(new FileOutputStream(localFile));
	            if (!ftp.retrieveFile(ftpFileName, out)) {
	                throw new IOException("Error loading file " + ftpFileName + " from FTP server. Check FTP permissions and path.");
	            }

	            out.flush();
	        } finally {
	            if (out != null) {
	                try {
	                    out.close();
	                } catch (IOException ex) {
	                }
	            }
	        }
	    }

	    /**
	     * Removes the file from the FTP server.
	     * 
	     * @param ftpFileName
	     *            server file name (with absolute path)
	     * @throws IOException
	     *             on I/O errors
	     */
	    public void remove(String ftpFileName) throws IOException {
	        if (!ftp.deleteFile(ftpFileName)) {
	            throw new IOException("Can't remove file '" + ftpFileName + "' from FTP server.");
	        }
	    }

	    /**
	     * Lists the files in the given FTP directory.
	     * 
	     * @param filePath
	     *            absolute path on the server
	     * @return files relative names list
	     * @throws IOException
	     *             on I/O errors
	     */
	    public List<String> list(String filePath) throws IOException {
	        List<String> fileList = new ArrayList<String>();
	        // Use passive mode to pass firewalls.
	        ftp.enterLocalPassiveMode();
	        
	        FTPFile[] ftpFiles = ftp.listFiles(filePath);
	        int size = (ftpFiles == null) ? 0 : ftpFiles.length;
	        for (int i = 0; i < size; i++) {
	            FTPFile ftpFile = ftpFiles[i];
	            if (ftpFile.isFile()) {
	                fileList.add(ftpFile.getName());
	            }
	        }
	        
	        return fileList;
	    }

	    /**
	     * Sends an FTP Server site specific command
	     * 
	     * @param args
	     *            site command arguments
	     * @throws IOException
	     *             on I/O errors
	     */
	    public void sendSiteCommand(String args) throws IOException {
	        if (ftp.isConnected()) {
	            try {
	                ftp.sendSiteCommand(args);
	            } catch (IOException ex) {
	            }
	        }
	    }

	    /**
	     * Disconnects from the FTP server
	     * 
	     * @throws IOException
	     *             on I/O errors
	     */
	    public void disconnect() throws IOException {

	        if (ftp.isConnected()) {
	            try {
	                ftp.logout();
	                ftp.disconnect();
	                is_connected = false;
	            } catch (IOException ex) {
	            	
	            }
	        }
	    }

	    /**
	     * Makes the full name of the file on the FTP server by joining its path and
	     * the local file name.
	     * 
	     * @param ftpPath
	     *            file path on the server
	     * @param localFile
	     *            local file
	     * @return full name of the file on the FTP server
	     */
	    public String makeFTPFileName(String ftpPath, File localFile) {
	        if (ftpPath == "") {
	            return localFile.getName();
	        } else {
	            String path = ftpPath.trim();
	            if (path.charAt(path.length() - 1) != '/') {
	                path = path + "/";
	            }

	            return path + localFile.getName();
	        }
	    }

	    /**
	     * Test coonection to ftp server
	     * 
	     * @return true, if connected
	     */
	    public boolean isConnected() {
	        return is_connected;
	    }

	    /**
	     * Get current directory on ftp server
	     * 
	     * @return current directory
	     */
	    public String getWorkingDirectory() {
	        if (!is_connected) {
	            return "";
	        }

	        try {
	            return ftp.printWorkingDirectory();
	        } catch (IOException e) {
	        }

	        return "";
	    }

	    /**
	     * Set working directory on ftp server
	     * 
	     * @param dir
	     *            new working directory
	     * @return true, if working directory changed
	     */
	    public boolean setAndCreateWorkingDirectory(String dir) {
	        if (!is_connected) 
	            return false;
	        try {
	        	String directory = dir;
	            if(!directory.equalsIgnoreCase("/")&&!ftp.changeWorkingDirectory(new String(directory.getBytes(encoding),"iso-8859-1"))){     
	                //如果远程目录不存在，则递归创建远程服务器目录     
	            	if(directory.startsWith("/"))
	            		directory = directory.substring(1);
	            	if(directory.endsWith("/"))
	            		directory = directory.substring(0,directory.length()-1);
	                String[] directorys = directory.split("/");
	                for (String subDirectory : directorys) {
	                	 if(!ftp.changeWorkingDirectory(subDirectory)){     
		                       if(ftp.makeDirectory(subDirectory)){     
		                    	   ftp.changeWorkingDirectory(subDirectory);     
		                       }else {     
		                           return false;
		                       }     
		                   }     
					}
	           }     
	           return true;    
	        } catch (IOException e) {
	        }
	        return false;
	    }
	    
	    
	    
	    public boolean setWorkingDirectory(String dir) {
	        if (!is_connected) 
	            return false;
	        try {
				return ftp.changeWorkingDirectory(dir);
			} catch (IOException e) {
				return false;
			}
	    }

	    /**
	     * Change working directory on ftp server to parent directory
	     * 
	     * @return true, if working directory changed
	     */
	    public boolean setParentDirectory() {
	        if (!is_connected) {
	            return false;
	        }

	        try {
	            return ftp.changeToParentDirectory();
	        } catch (IOException e) {
	        }

	        return false;
	    }

	    /**
	     * Get parent directory name on ftp server
	     * 
	     * @return parent directory
	     */
	    public String getParentDirectory() {
	        if (!is_connected) {
	            return "";
	        }

	        String w = getWorkingDirectory();
	        setParentDirectory();
	        String p = getWorkingDirectory();
	        setWorkingDirectory(w);

	        return p;
	    }

	/*    *//**
	     * Get directory contents on ftp server
	     * 
	     * @param filePath
	     *            directory
	     * @return list of FTPFileInfo structures
	     * @throws IOException
	     *//*
    public List<Attachment> listFiles(String filePath) throws IOException {
        List<Attachment> fileList = new ArrayList<Attachment>();
        // Use passive mode to pass firewalls.
        ftp.enterLocalPassiveMode();
        FTPFile[] ftpFiles = ftp.listFiles(filePath);
        int size = (ftpFiles == null) ? 0 : ftpFiles.length;
        for (int i = 0; i < size; i++) {
            FTPFile ftpFile = ftpFiles[i];
            Attachment fi = new Attachment();
            fi.setFileName(ftpFile.getName());
            fi.setFileSize(ftpFile.getSize());
            fi.setLastModify(new Timestamp(ftpFile.getTimestamp().getTimeInMillis()));
            //fi.setType(ftpFile.isDirectory());
            fi.setFileType(ftpFile.getType()+"");
            fileList.add(fi);
        }

        return fileList;
    }*/

	    /**
	     * Get file from ftp server into given output stream
	     * 
	     * @param ftpFileName
	     *            file name on ftp server
	     * @param out
	     *            OutputStream
	     * @throws IOException
	     */
	    public void getFile(String ftpFileName, OutputStream out) throws IOException {
	        try {
	            // Use passive mode to pass firewalls.
	            ftp.enterLocalPassiveMode();
	            
	            // Get file info.
	            FTPFile[] fileInfoArray = ftp.listFiles(ftpFileName);
	            if (fileInfoArray == null || fileInfoArray.length == 0) {
	                throw new FileNotFoundException("File '" + ftpFileName + "' was not found on FTP server.");
	            }

	            // Check file size.
	            FTPFile fileInfo = fileInfoArray[0];
	            long size = fileInfo.getSize();
	            if (size > Integer.MAX_VALUE) {
	                throw new IOException("File '" + ftpFileName + "' is too large.");
	            }

	            // Download file.
	            if (!ftp.retrieveFile(fileInfo.getName(), out)) {
	                throw new IOException("Error loading file '" + ftpFileName + "' from FTP server. Check FTP permissions and path.");
	            }

	            out.flush();

	        } finally {
	            if (out != null) {
	                try {
	                    out.close();
	                } catch (IOException ex) {
	                }
	            }
	        }
	    }
	    public InputStream getFileStream(String ftpFileName) throws IOException {
    		// Use passive mode to pass firewalls.
    		ftp.enterLocalPassiveMode();
    		
    		// Get file info.
    		FTPFile[] fileInfoArray = ftp.listFiles(ftpFileName);
    		if (fileInfoArray == null || fileInfoArray.length == 0) {
    			throw new FileNotFoundException("File '" + ftpFileName + "' was not found on FTP server.");
    		}
    		
    		// Check file size.
    		FTPFile fileInfo = fileInfoArray[0];
    		long size = fileInfo.getSize();
    		if (size > Integer.MAX_VALUE) {
    			throw new IOException("File '" + ftpFileName + "' is too large.");
    		}
    		// Download file.
    		return ftp.retrieveFileStream(fileInfo.getName());
	    }

	    /**
	     * Put file on ftp server from given input stream
	     * 
	     * @param ftpFileName
	     *            file name on ftp server
	     * @param in
	     *            InputStream
	     * @throws IOException
	     */
	    public void putFile(String ftpFileName, InputStream in) throws IOException {
	        try {
	            // Use passive mode to pass firewalls.
	            ftp.enterLocalPassiveMode();
	            
	            if (!ftp.storeFile(ftpFileName, in)) {
	                throw new IOException("Can't upload file '" + ftpFileName + "' to FTP server. Check FTP permissions and path.");
	            }
	        } finally {
	            try {
	                in.close();
	            } catch (IOException ex) {
	            }
	        }
	    }
	    /**
	     * 一站式：加载FTP服务器文件
	     * <p>example : new FtpUtil().DownLoanFile(SysConstants.FTP_HOST,SysConstants.FTP_PORT,SysConstants.FTP_USERNAME,SysConstants.FTP_PASSWORD,false
	    			, "GBK", "/upload/bidding_ico/20150405", "5212355463521463.jpg");</p>
	     * @param host FTP服务器 Ip/域名
	     * @param port ftp服务器使用端口（默认21）
	     * @param username 用户名
	     * @param password 密码
	     * @param isTextMode 是否ASCII纯文本模式
	     * @param encoding 中文文件名编码
	     * @param directory 目标文件所在ftp服务目录
	     * @param fileName  目标文件名
	     * @return
	     * @throws IOException
	     */
	    public InputStream DownLoanFile(String host,int port,String username,String password,boolean isTextMode,String encoding
	    		,String directory,String fileName) throws IOException{
	    	FtpClientUtil ftp = new FtpClientUtil();
			ftp.setEncoding(encoding);
			ftp.connect(host, port, username, password,isTextMode);
			if(ftp.setWorkingDirectory(directory)){
				return ftp.getFileStream(fileName);
			}
			throw new IOException("FTP Server DownLoan file failed ： The Directory may not exist!");
	    }
	    public static void main(String[] args) {
			try {
				FtpClientUtil ftp = new FtpClientUtil();
				ftp.setEncoding("GBK");
				ftp.connect("116.62.12.85", Integer.valueOf("21"),"huangkewei", "admin",false);
				/*ftp.setAndCreateWorkingDirectory("/20150429/20150429");
				FileInputStream in = new FileInputStream(new File("E:/倒萨.jpg"));
				ftp.putFile("aa.jpg", in);
				OutputStream os = new FileOutputStream(new File("D:/倒萨.jpg"));
				ftp.getFile("aa.jpg", os);*/
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}

	
	

}
