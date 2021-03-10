package com.kingdee;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Utils {
	
     /**
      * SHA256算法
	  * @param str
	  * @return String
	  */
    public static String getSHA256(String str){
        MessageDigest messageDigest;
        String encodestr = "";
        try {
 	        messageDigest = MessageDigest.getInstance("SHA-256");
 	        messageDigest.update(str.getBytes("UTF-8"));
 	        encodestr = byte2Hex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
             e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
             e.printStackTrace();
        }
             return encodestr;
     }
     
     /**
      * 转换成十六进制：补位
	  * @param bytes
	  * @return
	  */
     private static String byte2Hex(byte[] bytes){
 	    StringBuffer stringBuffer = new StringBuffer();
 	    String temp = null;
 	    for (int i=0;i<bytes.length;i++){
 	       temp = Integer.toHexString(bytes[i] & 0xFF);
 		   if (temp.length()==1){
 	       stringBuffer.append("0");
 		   }
 		   stringBuffer.append(temp);
 	     }
 	     return stringBuffer.toString();
     }
     
     /**
      * 读取xml值
      * @param 1.workflow's seq 2.elementName
      * @return 1.the property value
      */
     public static String getXMLValueBySeq(String workflowSeq,String elementName) {
    	 
 		try {
			SAXReader sax=new SAXReader();
			//FileInputStream fin=new FileInputStream(new File("src/application.xml"));
			
			FileInputStream fin=new FileInputStream(new File(Utils.class.getClassLoader().getResource("application.xml").getPath()));
			Document doc=sax.read(fin);
			Element ele=doc.getRootElement();
			@SuppressWarnings("unchecked")
			List<Element> list=ele.elements();
			
			//Element workflow= ele.element("workflow");
			//System.out.println(workflow.getName());
			//String seq= workflow.attributeValue("seq");
			//System.out.println(seq);
			
			for (Element element : list) {
				String seq=element.attributeValue("seq");
				if(seq.trim().equals(workflowSeq)) {
					Element fileIDElement= element.element(elementName);
					if(fileIDElement==null) {
						return "";
					}
					return fileIDElement.getText();
				}
			 }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(DocumentException e) {
			e.printStackTrace();
		}
    	 return "";
     }
     
     /**
      * 读取xml值
      * @param 1.workflow's name  2.elementName
      * @return 1.the property value
      */
     public static String getXMLValueByName(String workflowName,String elementName) {
 		try {
			SAXReader sax=new SAXReader();
			//FileInputStream fin=new FileInputStream(new File("src/application.xml"));
			String applicationPath=Utils.class.getClassLoader().getResource("application.xml").getPath();
			FileInputStream fin=new FileInputStream(new File(applicationPath));
			System.out.println(applicationPath);
			Document doc=sax.read(fin);
			Element ele=doc.getRootElement();
			@SuppressWarnings("unchecked")
			List<Element> list=ele.elements();
			for (Element element : list) {
				String name=element.attributeValue("name");
				if(name.trim().equals(workflowName)) {
					Element fileIDElement= element.element(elementName);
					if(fileIDElement==null) {
						return "";
					}
					return fileIDElement.getText();
				}
			 }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(DocumentException e) {
			e.printStackTrace();
		}
    	 return "";
     }
     
     /**
      *  拷贝文件
      *  @param   1.String fileName (文件名称)   2.String sourcePath (源文件地址)  3.String targetPath(目标文件地址)
      *  @return 
      */
     public static void copyFile(String fileName,String sourcePath,String targetPath) {
    	 File sourceFile=new File(sourcePath+"\\"+fileName);
    	 File targetDir=new File(targetPath);
    	 if(!targetDir.exists()) {
    		 targetDir.mkdirs();
    	 }
    	 try {
			FileInputStream fis=new FileInputStream(sourceFile);
			FileOutputStream fos=new FileOutputStream(targetPath+"\\"+fileName);
		    byte[] buff=new byte[1024*1024];
		    int readCount=0;
		    while((readCount=fis.read(buff))>0) {
		    	fos.write(buff, 0, readCount);
		    }
		    fis.close();
		    fos.close();
		    
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
     }
     

}
