package com.veranda.community.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import com.veranda.common.controller.SuperClass;
import com.veranda.common.utility.FlowParameters;
import com.veranda.common.utility.Paging;
import com.veranda.community.dao.CommunityDao;
import com.veranda.community.vo.Community;


public class CommunityListController extends SuperClass{

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		FlowParameters param = new FlowParameters(request.getParameter("pageNumber"), request.getParameter("mode"), request.getParameter("keyword"));
  
		/* log로 던지는 형식으로 교체 필요 */
		System.out.println("param list");
		System.out.println(param.toString());
		
		String contextPath = request.getContextPath();
		
		String url = contextPath + "/veranda?command=coList";
		
		CommunityDao cdao = new CommunityDao();
		
		// 게시글 행(Row) 총 개수 담을 변수
		int totalCount = cdao.SelectTotalCount( param.getMode(), param.getKeyword() );
		
		System.out.println("총 데이터 크기는 :  " +  totalCount + " 입니다. ");
		
		Paging pageInfo = new Paging ( param.getPageNumber(), totalCount, url, param.getMode(), param.getKeyword());
		
		List<Community> lists = cdao.SelectDataList(pageInfo.getBeginRow(), pageInfo.getEndRow(), param.getMode(), param.getKeyword());
		
		System.out.println("커뮤니티 게시판 리스트 개수는 : " + lists.size() + " 와 같습니다.");
		
		request.setAttribute("lists", lists);
		
		request.setAttribute("pageInfo", pageInfo);
		
		request.setAttribute("param", param.toString());
		
		String gotopage = "/community/comunityList.jsp";
		super.GotoPage(gotopage);
  }
  
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		super.doPost(request, response);
		
	}
}