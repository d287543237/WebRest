package com.kingdee;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/staffentry")
public class StaffEntry {

	@GET
	@Produces(MediaType.TEXT_HTML)
	public byte[] getResult(@QueryParam("name") String name) {
		return result(name).getBytes();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String postResult(@QueryParam("name") String name) {
		return result(name);
	}

	private String result(String name) {

		// 读取xml中的入职流程信息
		String workflowid = Utils.getXMLValueByName("入职流程审批", "workflowid");
		System.out.println(workflowid);
		String workflowid2 = Utils.getXMLValueByName("学历确认流程审批", "workflowid");
		System.out.println(workflowid2);
		name = name + "中文";
		name = name + workflowid;

		name = "<input type=\"text\" name=\"textname\"  value=" + name + ">";
		

		/*
		 * try { name= URLEncoder.encode(name,"GBK2312"); } catch
		 * (UnsupportedEncodingException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		

		/*
		 * 成功： {"code":0,"message":"成功" } 失败：
		 * 失败： {"code":99,"message":"失败","reason":"访问超时."}
		 */
		
		
		//拷贝文件
		String file="审批流程.docx";
		String sourcePath="F:\\KindeeJava\\ZTempCopy\\110";
		String targetPath="F:\\KindeeJava\\ZTempCopy\\120";
		Utils.copyFile(file, sourcePath, targetPath);
		

		
		 
		Response.status(Status.OK).build(); 
		name="{\"code\":0,\"message\":\"成功.\",\"status_code\":200 } ";

		return name;
	}
	
	@SuppressWarnings("unused")
	private Response resultPostMethod(String name) {

		// 读取xml中的入职流程信息
		String workflowid = Utils.getXMLValueByName("入职流程审批", "workflowid");
		System.out.println(workflowid);
		String workflowid2 = Utils.getXMLValueByName("学历确认流程审批", "workflowid");
		System.out.println(workflowid2);
		name = name + "中文";
		name = name + workflowid;

		name = "<input type=\"text\" name=\"textname\"  value=" + name + ">";
		

		/*
		 * 成功： {"code":0,"message":"成功" } 失败：
		 * 失败： {"code":99,"message":"失败","reason":"访问超时."}
		 */
		
		 
		Response.status(Status.OK).build(); 
		name="{\"code\":0,\"message\":\"成功\",\"status_code\":200 } ";

		return Response.ok(name, MediaType.APPLICATION_JSON).build();
	}

}
