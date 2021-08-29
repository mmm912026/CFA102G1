package com.reportProductReviews.model;

import java.sql.Timestamp;
import java.util.List;

public class ReportProductReviewsService {
	private I_ReportProductReviews dao;
	
	public ReportProductReviewsService() {
		dao = new ReportProductReviewsJDBCDAO();
	}
	
	public ReportProductReviewsVO insertReportProductReviews(Integer pr_no, Integer mem_no, String report_content
			) {
		
		ReportProductReviewsVO reportProductReviewsVO = new ReportProductReviewsVO();
		
		reportProductReviewsVO.setPr_no(pr_no);
		reportProductReviewsVO.setMem_no(mem_no);
		reportProductReviewsVO.setReport_content(report_content);

		dao.insert(reportProductReviewsVO);
		
		return reportProductReviewsVO;
	}
	
	public ReportProductReviewsVO updateReportProductReviews(Integer rep_no, Integer pr_no, Integer mem_no, String report_content,
			String rep_status, Timestamp rep_date) {

		ReportProductReviewsVO reportProductReviewsVO = new ReportProductReviewsVO();

		reportProductReviewsVO.setRep_no(rep_no);
		reportProductReviewsVO.setPr_no(pr_no);
		reportProductReviewsVO.setMem_no(mem_no);
		reportProductReviewsVO.setReport_content(report_content);
		reportProductReviewsVO.setRep_status(rep_status);
		reportProductReviewsVO.setRep_date(rep_date);

		dao.update(reportProductReviewsVO);

		return reportProductReviewsVO;
	}

	public void deleteReportProductReviews(Integer rep_no) {
		dao.delete(rep_no);
	}

	public ReportProductReviewsVO getOneReportProductReviews(Integer rep_no) {
		return dao.findByPK(rep_no);
	}

	public List<ReportProductReviewsVO> getAll() {
		return dao.getAll();
	}
}
