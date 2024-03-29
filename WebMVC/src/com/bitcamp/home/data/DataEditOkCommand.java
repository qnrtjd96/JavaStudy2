package com.bitcamp.home.data;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitcamp.home.CommandService;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class DataEditOkCommand implements CommandService {

	@Override
	public String pocessStart(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String path = req.getServletContext().getRealPath("/upload");
		
		MultipartRequest mr = new MultipartRequest(req, path, 1024*1024*1024, "UTF-8", new DefaultFileRenamePolicy());
		////////////////////////업로드완료
		DataDAO dao = new DataDAO();
		DataVO vo = new DataVO();
		
		vo.setNo(Integer.parseInt(mr.getParameter("no")));//글번호
		vo.setTitle(mr.getParameter("title"));//제목
		vo.setContent(mr.getParameter("content"));//글내용
		vo.setUserid((String)req.getSession().getAttribute("userid"));//아이디
		
		vo.setDelfile(mr.getParameterValues("delfile"));
//		System.out.println("vo.getDelfile().length = "+ vo.getDelfile().length);
//		for(int i=0; i<vo.getDelfile().length; i++) {
//			System.out.println("delfile["+i+"] = " + vo.getDelfile()[i]);
//		}
		
		//새로 업로드된 파일정보
		Enumeration nameList = mr.getFileNames();//필드명
		int idx=0;
		while(nameList.hasMoreElements()) {
			String filedName = (String)nameList.nextElement();//필드명
			if(mr.getFilesystemName(filedName)!=null) {
				vo.getFilename()[idx++] =mr.getFilesystemName(filedName); //--------------
			}
		}
		
		//데이터베이스에있는 파일명 얻어오기
		List<String> dbFile = dao.getSelectFile(vo.getNo()); //-------------
		
		//db파일중에 삭제된 파일지우기
		if(vo.getDelfile()!=null) {
			for(int delIdx=0; delIdx<vo.getDelfile().length; delIdx++) {
				dbFile.remove(vo.getDelfile()[delIdx]);
			}
		}
		//새로업로드한 파일을 dbFile에 추가
		for(int i=0; i<idx; i++) {
			if(vo.getFilename()[i]!=null) {
				dbFile.add(vo.getFilename()[i]);
			}
		}
		for(int ii=0; ii<dbFile.size(); ii++) {
			System.out.println("list => " + dbFile.get(ii));
		}
		
		//레코드 수정
		int result = dao.dataUpdate(vo, dbFile);
		
		//삭제한 파일을 서버에서 제거한다.
		if(vo.getDelfile()!=null) {
			for(int k=0; k<vo.getDelfile().length; k++) {
				try {
					System.out.println("vo.getDelfile = " + vo.getDelfile()[k]);
					File delfile = new File(path, vo.getDelfile()[k]);
					delfile.delete();
				} catch (Exception e) {
					System.out.println("파일삭제 실패 ==> " + e.getMessage());
				}
			}
		}
		req.setAttribute("result", result);
		req.setAttribute("no", vo.getNo());
		
		return "/data/editOk.jsp";
	}

}
