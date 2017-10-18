package com.tqy.dao;

import java.util.List;

import com.tqy.bean.Picture;

public interface PictureMapper {
	public int addPicture(Picture picture);
	
	public int deletePicture(int p_id);
	
	public int updatePicture(Picture picture);
	
	public Picture getPicture(int p_id);
	
	public List<Picture> getPictures();
	
	public Picture getPictureByDateAndType(Picture picture);
	
	public List<Picture> getPictureByDate(Picture picture);
	
	public List<Picture> getPictureByType(String pic_type);
}