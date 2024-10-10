package week4.hcmute.controllers.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import week4.hcmute.entity.*;
import week4.hcmute.services.*;
import week4.hcmute.utls.Constants;


@MultipartConfig()
@WebServlet (urlPatterns= {"/admin/videos", "/admin/video/add","/admin/video/insert","/admin/video/delete","/admin/video/update","/admin/video/edit"})

public class VideoController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public IVideoService vidservice = new VideoService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String url=req.getRequestURI();
		if(url.contains("/admin/video/add")) {
			req.getRequestDispatcher("/view/admin/video-add.jsp").forward(req, resp);
			
		}else if(url.contains("/admin/videos")) {
			List<Video> list= vidservice.findAll();
			req.setAttribute("listvid", list);
			req.getRequestDispatcher("/view/admin/video-list.jsp").forward(req, resp);
			
		}else if(url.contains("/admin/video/delete")) {
			String id =req.getParameter("id");
			try {
				vidservice.delete(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resp.sendRedirect(req.getContextPath()+"/admin/videos");
		}else if(url.contains("/admin/video/edit")) {
			String id =req.getParameter("id");
			Video video = vidservice.findById(id);
			req.setAttribute("vid", video);
			req.getRequestDispatcher("/view/admin/video-edit.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String url=req.getRequestURI();
		if(url.contains("/admin/video/insert")) {
			// lay du lieu tu view
			String vidid = req.getParameter("videoid");
			String titlename = req.getParameter("titlename");
			String description = req.getParameter("description");
			int views = Integer.parseInt(req.getParameter("views"));
			String active = req.getParameter("active");
			String poster = req.getParameter("poster");
			// dua vao model
			Video video = new Video();
			video.setDescription(description);
			video.setTitle(titlename);
			video.setVideoid(vidid);
			video.setViews(views);
			//Xu ly upload file
			String fname="";
			String uploadPath= Constants.UPLOAD_DIRECTORY;
			File uploadDir = new File(uploadPath);
			if(!uploadDir.exists())
			{
				uploadDir.mkdir();
			}
			try {
				Part part = req.getPart("poster1");
				if(part.getSize()>0) {
					String filename =Paths.get(part.getSubmittedFileName()).getFileName().toString();
					//doi ten file
					int index = filename.lastIndexOf(".");
					String ext = filename.substring(index+1);
					fname = System.currentTimeMillis()+"."+ext;
					//upload file
					part.write(uploadPath+"/"+fname );
					// ghi ten file vao data
					video.setPoster(fname);
					
					
				}else if(poster!=null) {
					video.setPoster(poster);
				}else {
					video.setPoster("avata.png");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			video.setActive(active.equals("true"));
			//truyen model vao insert
			vidservice.insert(video);
			//chuyen  ve view
			resp.sendRedirect(req.getContextPath()+"/admin/videos");
		}else if (url.contains("update")) {
			String vidid = req.getParameter("videoid");
			String title = req.getParameter("titlename");
			String poster = req.getParameter("poster");
			String active = req.getParameter("active");

			Video vid = new Video();
			vid.setVideoid(vidid);
			vid.setTitle(title);
			vid.setPoster(poster);
			vid.setActive(active.equals("true"));
			Video vidold = new Video();
			vidold = vidservice.findById(vidid);
			String fname = "";
			String uploadPath = Constants.UPLOAD_DIRECTORY;
			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists()) {
				uploadDir.mkdir();
			}
			try {
				Part part = req.getPart("image");
				if (part.getSize() > 0) {
					String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
					// doi ten file
					int index = filename.lastIndexOf(".");
					String ext = filename.substring(index + 1);
					fname = System.currentTimeMillis() + "." + ext;
					// upload
					part.write(uploadPath + "/" + fname);
					// ghi ten file vao data
					vid.setPoster(fname);
				} else {
					vid.setPoster(vidold.getPoster());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			vidservice.update(vid);
			resp.sendRedirect(req.getContextPath() + "/admin/videos");
		}
	}
	
}
