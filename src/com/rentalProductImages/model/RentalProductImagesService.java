package com.rentalProductImages.model;

import java.util.List;

public class RentalProductImagesService {
	private I_RentalProductImagesDAO dao;
	
	public RentalProductImagesService() {
		dao = new RentalProductImagesJDBCDAO();
	}
	
	public RentalProductImagesVO insertRentalProductImages(Integer rc_no, byte[] rpi_img) {
		
		RentalProductImagesVO rentalProductImagesVO = new RentalProductImagesVO();
		
		rentalProductImagesVO.setRc_no(rc_no);
		rentalProductImagesVO.setRpi_img(rpi_img);

		dao.insert(rentalProductImagesVO);
		
		return rentalProductImagesVO;
	}
	
	public RentalProductImagesVO updateRentalProductImages(Integer rpi_no, Integer rc_no, byte[] rpi_img) {

		RentalProductImagesVO rentalProductImagesVO = new RentalProductImagesVO();

		rentalProductImagesVO.setRpi_no(rpi_no);
		rentalProductImagesVO.setRc_no(rc_no);
		rentalProductImagesVO.setRpi_img(rpi_img);
		dao.update(rentalProductImagesVO);

		return rentalProductImagesVO;
	}

	public void deleteRentalProductImages(Integer rpi_no) {
		dao.delete(rpi_no);
	}

	public RentalProductImagesVO getOneRentalProductImages(Integer rpi_no) {
		return dao.findByPK(rpi_no);
	}

	public List<RentalProductImagesVO> getAll() {
		return dao.getAll();
	}
}
