package com.mago.base;

import org.apache.log4j.Logger;

import com.mago.db.DBConnection;
import com.mago.db.DBConnectionManager;

public class SyncViewNum implements Runnable{
	
	private static SyncViewNum instance;
	private static int viewNum;
	private static int articleId;
	private Logger logger = Logger.getLogger(SyncViewNum.class);
	
	public SyncViewNum(int articleId, int viewNum){
		this.setArticleId(articleId);
		this.setViewNum(viewNum);
	}
	
	public synchronized static SyncViewNum getInstance(int article, int viewNum){
		if(instance == null){
			instance = new SyncViewNum(article, viewNum);
		}else if(instance != null && getArticleId() != article){
			instance = new SyncViewNum(article, viewNum);
		}
		return instance;
	}
	
	@Override
	public void run() {
		syncViewNum();
	}
	
	private synchronized void syncViewNum(){
		DBConnection conn = DBConnectionManager.getInstance().getConnection();
		
		if(conn == null)
		{
			logger.error("Cann't create the connection to DataBase!");
			
		}
		conn.updateViewNum(articleId, ++viewNum);
	}

	/**
	 * @return the viewNum
	 */
	public static int getViewNum() {
		return viewNum;
	}

	/**
	 * @param viewNum the viewNum to set
	 */
	public void setViewNum(int viewNum) {
		SyncViewNum.viewNum = viewNum;
	}

	/**
	 * @return the articleId
	 */
	public static int getArticleId() {
		return articleId;
	}

	/**
	 * @param articleId the articleId to set
	 */
	public void setArticleId(int articleId) {
		SyncViewNum.articleId = articleId;
	}

}
